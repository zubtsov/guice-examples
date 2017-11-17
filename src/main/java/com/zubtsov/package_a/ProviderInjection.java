package com.zubtsov.package_a;

import com.google.inject.Provider;

public class ProviderInjection
{

    public static class MyProvider implements Provider<ProviderInjection>
    {
        @Override
        public ProviderInjection get()
        {
//            return null;
            return new ProviderInjection();
        }
    }

    public void hello()
    {
        System.out.println("Provider injected!");
    }
}
