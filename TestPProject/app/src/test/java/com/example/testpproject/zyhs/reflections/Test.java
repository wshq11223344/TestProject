package com.example.testpproject.zyhs.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {


    @org.junit.Test
    public void test_2() {

        try {
            Class<?> aClass = Class.forName("com.zhangyuhuishou.zyhs.reflections.User");

            Constructor<?> constructor = aClass.getConstructor(String.class, String.class, int.class);

            User user = (User) constructor.newInstance("韩琦", "男", 27);

            System.out.println(user.toString());


            Constructor<?>[] constructors = aClass.getConstructors();

            for (int i = 0; i < constructors.length; i++) {

                Class<?>[] parameterTypes = constructors[i].getParameterTypes();

                System.out.println(i);

                for (int j = 0; j < parameterTypes.length; j++) {

                    String name = parameterTypes[j].getName();

                    System.out.println(name);
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //    获取属性
    @org.junit.Test
    public void test() {

        try {
            Class<?> aClass = Class.forName("com.example.testpproject.zyhs.reflections.User");
            User user = (User) aClass.newInstance();

            Field name = aClass.getDeclaredField("name");


            name.setAccessible(true);

            name.set(user, "韩琦");

            Object o = name.get(user);
            System.out.println(name.get(user));

            System.out.print(name.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //    获取全部属性
    @org.junit.Test
    public void test_3() {

        try {
            Class<?> aClass = Class.forName("com.example.testpproject.zyhs.reflections.User");
            User user = (User) aClass.newInstance();

            user.setName("韩琦");
            user.setSex("男");
            user.setAge(25);

            Field[] declaredFields = aClass.getDeclaredFields();

            for (int i = 0; i < declaredFields.length; i++) {

                declaredFields[i].setAccessible(true);

                System.out.println(declaredFields[i].getName());
//
//                System.out.println(declaredFields[i].get(user));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //    获取方法
    @org.junit.Test
    public void test_4() {
        try {
            Class<?> aClass = Class.forName("com.example.testpproject.zyhs.reflections.User");

            User user = (User) aClass.newInstance();


            Method setName = aClass.getMethod("setName", String.class);

            Method getName = aClass.getMethod("getName");

            getName.setAccessible(true);

            setName.setAccessible(true);

            setName.invoke(user, "韩琦");


            System.out.println(getName.invoke(user));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //    获取所有方法
    @org.junit.Test
    public void test_5() {

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.zhangyuhuishou.zyhs.reflections.User");

            User user = (User) aClass.newInstance();

            Method[] declaredMethods = aClass.getDeclaredMethods();

            for (int i = 0; i < declaredMethods.length; i++) {

                declaredMethods[i].setAccessible(true);

                System.out.println(declaredMethods[i].getName());
                Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();

                for (int j = 0; j < parameterTypes.length; j++) {

//                    System.out.println(parameterTypes[j].getName());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
