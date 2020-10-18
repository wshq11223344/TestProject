package com.example.testpproject.dagger2.module;


import com.example.testpproject.dagger2.AppScope;
import com.example.testpproject.dagger2.object.HttpObject;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {

    @Provides
    @AppScope
//    @Singleton
    public HttpObject providerHttpObject() {
        return new HttpObject();
    }


}
