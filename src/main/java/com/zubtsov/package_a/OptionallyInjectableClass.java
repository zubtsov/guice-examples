package com.zubtsov.package_a;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class OptionallyInjectableClass
{
    private String message;

    //Uncomment to allow optional injection
//    @Inject
    public OptionallyInjectableClass(@Named("Author") String message)
    {
        this.message = message;
    }
}
