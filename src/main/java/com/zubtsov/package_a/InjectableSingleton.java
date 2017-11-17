package com.zubtsov.package_a;

import com.google.inject.Singleton;

@Singleton
public class InjectableSingleton
{
    public void hello()
    {
        System.out.println("I'm singleton! My hash code is " + hashCode());
    }
}
