package com.zubtsov.package_a;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class BindToConstructor
{
    String message;

    public BindToConstructor()
    {
        message = "Default constructor";
    }

    //@Inject
    public BindToConstructor(@Named("Author") String message)
    {
        this.message = "Construtor with argument: " + message;
    }

    public void hello()
    {
        System.out.println(message);
    }
}
