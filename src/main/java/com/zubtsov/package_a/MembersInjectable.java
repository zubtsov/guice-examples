package com.zubtsov.package_a;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MembersInjectable
{
    @Inject
    @Named("Author")
    private String message;

    public void hello()
    {
        System.out.println("Message: " + message);
    }
}
