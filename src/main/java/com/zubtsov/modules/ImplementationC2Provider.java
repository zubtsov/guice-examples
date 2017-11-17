package com.zubtsov.modules;

import com.google.inject.Provider;
import com.zubtsov.package_a.ImplementationC2;
import com.zubtsov.package_a.InjectableC2;

public class ImplementationC2Provider implements Provider<InjectableC2>
{
    @Override
    public InjectableC2 get()
    {
        return new ImplementationC2();
    }
}
