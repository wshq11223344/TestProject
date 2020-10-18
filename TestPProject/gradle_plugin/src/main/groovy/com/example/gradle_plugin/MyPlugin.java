package com.example.gradle_plugin;

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println("apply my plugin")
    }
}
