package com.zubtsov.modules;

import com.google.inject.Provider;
import com.zubtsov.package_a.ImplementationB3;

public class ImplementationB3Provider implements Provider<ImplementationB3>
{
    @Override
    public ImplementationB3 get()
    {
        return new ImplementationB3();
    }
}
