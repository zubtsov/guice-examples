package com.zubtsov.package_a;

public interface InjectableA
{
    default public void hello()
    {
        Class c = getClass();
        System.out.println(c.getName() + ".hello(); hashCode(): " + hashCode());
    }
}
