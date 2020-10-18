package com.example.testpproject.dagger2.module;


import com.example.testpproject.dagger2.object.DateBaseObject;

import dagger.Module;
import dagger.Provides;

@Module
public class DateBaseModule {


    @Provides
    public DateBaseObject providerDataBaseObject() {

        return new DateBaseObject();

    }


}
