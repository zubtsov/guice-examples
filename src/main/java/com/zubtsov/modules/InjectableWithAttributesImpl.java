package com.zubtsov.modules;

import java.lang.annotation.Annotation;

public class InjectableWithAttributesImpl implements InjectableWithAttributesA
{
    private int value1;
    private int value2;

    public InjectableWithAttributesImpl(int value1, int value2)
    {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public int value1()
    {
        return value1;
    }

    @Override
    public int value2()
    {
        return value2;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return InjectableWithAttributesA.class;
    }

    @Override
    public int hashCode()
    {
        return (127 * "value1".hashCode() ^ Integer.valueOf(value1).hashCode()) + (127 * "value2".hashCode() ^ Integer.valueOf(value2).hashCode());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null ||
                !(obj instanceof InjectableWithAttributesA))
        {
            return false;
        } else
        {
            return Integer.valueOf(value1).equals(((InjectableWithAttributesA) obj).value1()) &&
                    Integer.valueOf(value2).equals(((InjectableWithAttributesA) obj).value2());
        }
    }
}
