package com.zubtsov.package_a;

import com.google.inject.ImplementedBy;

//Acts like bind clause, but has lower precedence/priority
@ImplementedBy(ImplementationC1.class)
public interface InjectableC1
{
    default public void hello()
    {
        Class c = getClass();
        System.out.println(c.getName() + ".hello(); hashCode(): " + hashCode());
    }
}
