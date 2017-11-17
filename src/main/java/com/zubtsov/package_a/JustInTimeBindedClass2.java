package com.zubtsov.package_a;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class JustInTimeBindedClass2
{
    //Another injectable constructor
    @Inject
    public JustInTimeBindedClass2(@Named("Author") String message)
    {
        System.out.println("JIT Binding is successful. Author: " + message);
    }
}
