package com.zubtsov.modules;

import com.google.inject.*;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.zubtsov.package_a.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        //Simplest binding
        bind(InjectableA.class).to(ImplementationA1.class);

        bind(InjectableA.class).annotatedWith(BindingAnnotationA1.class).to(ImplementationA2.class);
        bind(InjectableA.class).annotatedWith(Names.named("ImplementationA3")).to(ImplementationA3.class);
        bind(InjectableA.class).annotatedWith(Names.named("Field injection")).to(ImplementationA4.class);

        //Custom annotation with attributes
        bind(InjectableA.class).annotatedWith(new InjectableWithAttributesImpl(123, 456)).to(ImplementationA5.class);

        bind(String.class).annotatedWith(Names.named("Author")).toInstance("Zubtsov Ruslan");
        bind(InjectableB.class).annotatedWith(Names.named("B3")).toProvider(ImplementationB3Provider.class);

        //Binding generic types
        bind(new TypeLiteral<List<String>>()
        {
        }).toInstance(Arrays.asList("hello", "guice"));
        bind(new TypeLiteral<List<Integer>>()
        {
        }).toInstance(Arrays.asList(1, 2, 3));

        //Binding to concrete constructor
        try
        {
            bind(BindToConstructor.class).toConstructor(BindToConstructor.class.getConstructor(String.class));
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }

        //Binding singleton (application scoped injection). Scope corresponds to the bound type.
        bind(InjectableSingleton.class).in(Singleton.class);

        //Binding interceptor. AOP
        MethodInterceptor mi = new MethodInterceptor()
        {
            @Inject
            private InterceptorDependency id;

            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable
            {
                System.out.println("Interception begins!");
                methodInvocation.proceed();
                System.out.println("Interception is successful!");
                id.hello();
                return null;
            }
        };

        //It is needed to request injection for method's interceptors.
        requestInjection(mi);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(InterceptThis.class), mi);

        //Binding properties from file
        Map<String, String> props = new HashMap();
        props.put("One", "Two");
        Names.bindProperties(this.binder(), props);

        //Binding provider injection
        bind(ProviderInjection.class).toProvider(ProviderInjection.MyProvider.class);
    }

    //Methods-providers
    @Provides
    InjectableB provideInjectableB1()
    {
        return new ImplementationB1();
    }

    @Provides
    @Named("B2")
    InjectableB provideInjectableB2()
    {
        return new ImplementationB2();
    }
}
