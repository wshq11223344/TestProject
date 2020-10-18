package com.example.testpproject.finalizes;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.example.testpproject.finalizes.User.user;

public class FinalizerTest {


    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user = null;
        System.gc();
        Thread.sleep(1000);

        user = User.user;
        System.out.println(user != null);//true
//
//        user = null;
//        System.gc();
//        Thread.sleep(1000);
//        System.out.println(user != null);//false


        Person person = new Person("韩琦", 123);
        ReferenceQueue<Person> objectReferenceQueue = new ReferenceQueue<>();

        WeakReference<Person> weakReference = new WeakReference<Person>(person, objectReferenceQueue);

        System.out.println(weakReference.get().toString());

        System.out.println(objectReferenceQueue.poll());


        person = null;

        System.gc();

        Thread.sleep(2000);

        System.out.println(weakReference.get());

        Reference<? extends Person> remove = objectReferenceQueue.poll();

        System.out.println(remove);
        System.out.println(remove.get());


//        ReferenceQueue<Object> objectReferenceQueue1 = new ReferenceQueue<>();
//
//        PhantomReference<Object> phantomReference = new PhantomReference<Object>(person, objectReferenceQueue1);
//
//        System.out.println(phantomReference.get());
//
//        System.out.println(objectReferenceQueue1.poll());
//
//        System.gc();
//
//        Thread.sleep(1000);
//
//
//        System.out.println(phantomReference.get());
//
//        System.out.println(objectReferenceQueue1.poll());


//        Set<String> set = new HashSet<>();
//
//        set.add("123");
//        set.add("345");
//        set.add("455");
//        set.add("666");
//
//        Iterator<String> iterator = set.iterator();
//
//        while (iterator.hasNext()) {
//
//
//            String next = iterator.next();
//
//            if (iterator.next() != null) {
//                iterator.remove();
//
//            }
//
//        }
//
//        System.out.println(set.size());
//
//
//    }

    }
}
