package com.zubtsov.package_a;

import com.google.inject.ProvidedBy;
import com.zubtsov.modules.ImplementationC2Provider;

//Acts like bind clause, but has lower precedence/priority
@ProvidedBy(ImplementationC2Provider.class)
public interface InjectableC2
{
    default public void hello()
    {
        Class c = getClass();
        System.out.println(c.getName() + ".hello(); hashCode(): " + hashCode());
    }
}
