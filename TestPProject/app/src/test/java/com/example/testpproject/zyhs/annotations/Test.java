package com.example.testpproject.zyhs.annotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@MyAnnotation(age = 27, name = "韩琦", grade = {98, 96, 99})
public class Test {


    @MyAnnotation(age = 25, name = "琪琪", grade = {88, 99})
    private void getAnnotation() {

    }


    @org.junit.Test
    public void test() throws ClassNotFoundException, NoSuchMethodException {
//        Class<?> aClass = Class.forName("com.zhangyuhuishou.zyhs.annotations.Test");
//
//        MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
//
//        if (aClass != null) {
//            System.out.println(annotation.age());
//            System.out.println(annotation.name());
//            System.out.println(Arrays.toString(annotation.grade()));
//        }

//        Method getAnnotation = aClass.getDeclaredMethod("getAnnotation");
//
//        MyAnnotation annotation1 = getAnnotation.getAnnotation(MyAnnotation.class);
//
//        if (annotation1 != null) {
//            System.out.println(annotation1.age());
//            System.out.println(annotation1.name());
//            System.out.println(Arrays.toString(annotation1.grade()));
//        }


//        Method[] declaredMethods = aClass.getDeclaredMethods();
//
//
//        for (int i = 0; i < declaredMethods.length; i++) {
//
//            declaredMethods[i].setAccessible(true);
//
//            MyAnnotation annotation1 = declaredMethods[i].getAnnotation(MyAnnotation.class);
//
//            if (annotation1 != null) {
//
//                System.out.println(annotation1.age());
//                System.out.println(annotation1.name());
//                System.out.println(Arrays.toString(annotation1.grade()));
//            }
//
//
//        }


//        获取注解上面的注解 1
//        Class<?> aClass1 = Class.forName("com.zhangyuhuishou.zyhs.annotations.MyAnnotation");
//        TestAnnotation annotation1 = aClass1.getAnnotation(TestAnnotation.class);
//
//        if (annotation1 != null) {
//
//            System.out.println(annotation1.value());
//        }
//
//
//        System.out.println(aClass1.isAnnotationPresent(TestAnnotation.class));


//        获取注解上面的注解2
//        Class<?> aClass1 = Class.forName("com.zhangyuhuishou.zyhs.annotations.MyAnnotation");
//        Annotation[] annotations = aClass1.getAnnotations();
//        for (int i = 0; i < annotations.length; i++) {
//            Annotation annotation = annotations[i];
//
//            if (TestAnnotation.class.isInstance(annotation)) {
//                TestAnnotation annotation1 = (TestAnnotation) annotation;
//                System.out.println(annotation1.value());
//            }
//
//        }

//        获取方法上的多个注解 1
//        Class<?> aClass1 = Class.forName("com.zhangyuhuishou.zyhs.annotations.Test");
//
//        Method method = aClass1.getDeclaredMethod("getAnnotation");
//
//        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
//
//        System.out.println(Arrays.toString(annotation.grade()));
//
//        System.out.println(annotation.age());
//
//        System.out.println(annotation.name());
//
//        TestAnnotation annotation1 = method.getAnnotation(TestAnnotation.class);
//
//        System.out.println(annotation1.value());


        //        获取方法上的多个注解 2

//        Class<?> aClass1 = Class.forName("com.zhangyuhuishou.zyhs.annotations.Test");
//
//        Method[] declaredMethods = aClass1.getDeclaredMethods();
//
//        for (Method declaredMethod : declaredMethods) {
//
//            MyAnnotation annotation = declaredMethod.getAnnotation(MyAnnotation.class);
//
//            TestAnnotation annotation1 = declaredMethod.getAnnotation(TestAnnotation.class);
//
//            if (annotation != null) {
//
//                System.out.println(Arrays.toString(annotation.grade()));
//
//                System.out.println(annotation.age());
//
//                System.out.println(annotation.name());
//            }
//
//            if (annotation1 != null) {
//                System.out.println(annotation1.value());
//
//            }
//
//        }


//        获取类上面注解的注解
        Class<?> aClass1 = Class.forName("com.example.testpproject.zyhs.annotations.Test");

//        MyAnnotation annotation = aClass1.getAnnotation(MyAnnotation.class);
//
//        System.out.println(annotation.getClass().getSimpleName());
////
//        Class<? extends Annotation> aClass = annotation.annotationType();
//
//        System.out.println(aClass.getSimpleName());
////
//        TestAnnotation annotation1 = aClass.getAnnotation(TestAnnotation.class);
//
//        System.out.println(annotation1.value());


//        获取方法上面的注解
        Method[] methods = aClass1.getDeclaredMethods();

        for (Method method : methods) {

            Annotation[] annotations = method.getAnnotations();

            if (null == annotations) {
                continue;
            }

            for (Annotation annotation : annotations) {

                Class<? extends Annotation> aClass = annotation.annotationType();

                TestAnnotation annotation1 = aClass.getAnnotation(TestAnnotation.class);

                if (annotation1 != null) {

                    System.out.println(annotation1.value());
                }

            }
//
        }

    }

}
