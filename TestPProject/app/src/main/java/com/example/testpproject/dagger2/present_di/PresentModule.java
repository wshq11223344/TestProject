package com.example.testpproject.dagger2.present_di;


import dagger.Module;
import dagger.Provides;

@Module
public class PresentModule {

    @Provides
    public PresentObject providerPresentObject() {

        return new PresentObject();

    }

}

