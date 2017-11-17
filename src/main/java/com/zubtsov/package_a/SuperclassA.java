package com.zubtsov.package_a;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.zubtsov.modules.BindingAnnotationA1;
import com.zubtsov.modules.InjectableWithAttributesA;
import com.zubtsov.modules.InterceptThis;
import com.zubtsov.modules.TestModule;

import java.util.List;
import java.util.logging.Logger;

public class SuperclassA
{
    //Injected by injecting constructor's parameters
    private final InjectableA a1;

    private final InjectableA a2;

    private final InjectableA a3;

    //Injection in field
    @Inject
    @Named("Field injection")
    private InjectableA a4;

    //Using custom binding annotation with attributes
    @Inject
    @InjectableWithAttributesA(value1 = 123, value2 = 456)
    private InjectableA a5;

    //Binding to instance
    @Inject
    @Named("Author")
    String name;

    //Provider methods in module
    @Inject
    private InjectableB b1;

    @Inject
    @Named("B2")
    private InjectableB b2;

    //Binding to provider
    @Inject
    @Named("B3")
    private InjectableB b3;

    //ImplementedBy(Implementation.class) binding
    @Inject
    private InjectableC1 c1;

    //ProvidedBy(Provider.class) binding
    @Inject
    InjectableC2 c2;

    //Binding to constructor
    @Inject
    BindToConstructor btc;

    //Members injector for manually created objects
    @Inject
    public MembersInjector<MembersInjectable> minjector;

    //Generic type binding by TypeLiteral<T>
    @Inject
    List<String> helloGuice;

    @Inject
    List<Integer> helloGuice2;

    //Built-in binding
    @Inject
    private Logger logger;

    //Just in time bindings
    @Inject
    private JustInTimeBindedClass jitbc;

    @Inject
    private JustInTimeBindedClass2 jitbc2;

    //Singleton (application scoped injection). Also, @Singleton annotation is available for providers
    @Inject
    private InjectableSingleton is;

    @Inject
    private InjectableSingleton is2;

    @Inject(optional = true)
    private OptionallyInjectableClass oic;

    @Inject
    @Named("One")
    String propertyBinding;

    //Injecting provider
//    @Inject
    Provider<ProviderInjection> pi = Guice.createInjector(new TestModule()).getProvider(ProviderInjection.class);

    //Injected constructor
    @Inject
    public SuperclassA(InjectableA a1, @BindingAnnotationA1 InjectableA a2, @Named("ImplementationA3") InjectableA a3)
    {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    @InterceptThis
    public void interceptedMethod()
    {
        System.out.println("Intercept me!");
    }

    public void test()
    {
        System.out.println("SuperclassA.test()");
        System.out.println("Before a1.hello()");

        a1.hello();

        System.out.println("Before a2.hello()");

        a2.hello();

        System.out.println("Before a3.hello()");

        a3.hello();

        System.out.println("Before a4.hello()");

        a4.hello();

        System.out.println("Before a5.hello()");

        a5.hello();

        System.out.println("name: " + name);

        System.out.println("Before b1.hello()");

        b1.hello();

        System.out.println("Before b2.hello()");

        b2.hello();

        System.out.println("Before b3.hello()");

        b3.hello();

        System.out.println("Before c1.hello()");

        c1.hello();

        System.out.println("Before c2.hello()");

        c2.hello();

        System.out.println("Before btc.hello()");

        btc.hello();

        MembersInjectable mi = new MembersInjectable();

        System.out.println("Before members inject.");
        mi.hello();
        minjector.injectMembers(mi);
        System.out.println("After members inject.");
        mi.hello();

        System.out.println("List<String>.toString(): " + helloGuice.toString());

        System.out.println("List<Integer>.toString(): " + helloGuice2.toString());

        logger.info("Injected logger! Built-in binding.");

        is.hello();
        is2.hello();

        System.out.println("Comparing two singletones: " + is.equals(is2));

        System.out.println("Optional injection: " + oic);

        System.out.println("Testing interception...");

        interceptedMethod();

        System.out.println("Property binding: One=" + propertyBinding);

        System.out.println("Provider injection...");
        pi.get().hello();
    }
}
