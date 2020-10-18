package com.example.testpproject.dagger2.present_di;


import dagger.Component;

@Component(modules = {PresentModule.class})
public interface PresentComponent {

    PresentObject providerPresent();

}
