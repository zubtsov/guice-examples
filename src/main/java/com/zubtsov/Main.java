package com.zubtsov;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zubtsov.modules.TestModule;
import com.zubtsov.package_a.SuperclassA;

public class Main
{
    //Don't tried to inject injector and to use stages. Also extensions are not examined
    public static void main(String[] args)
    {
        System.out.println("Guice test by Zubtsov Ruslan.");

        Injector injector = Guice.createInjector(new TestModule());

        SuperclassA superclassA = injector.getInstance(SuperclassA.class);

        superclassA.test();
    }
}
