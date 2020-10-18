package com.example.testpproject.mvp.databus;




import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class RxBus {
    //订阅者集合
    private Set<Object> subscribers;
    /**
     * 注册
     */
    public synchronized void register(Object subscriber){
        subscribers.add(subscriber);
    }
    /**
     * 取消注册
     */
    public synchronized void unRegister(Object subscriber){
        subscribers.remove(subscriber);
    }

    //volatile 自带线程安全(禁止指令重排)
    private static volatile  RxBus instance;

    public static synchronized RxBus getInstance(){
        if(instance==null){
            synchronized (RxBus.class){
                if(instance==null){
                    instance=new RxBus();
                }
            }
        }
        return instance;
    }

    private RxBus(){
        //读写分离的集合
        subscribers=new CopyOnWriteArraySet<>();
    }

    /**
     * 把处理过程包装起来
     * function:就是用户的操作
     */
    public void chainProcess(Function function){
        Observable.just("")
                .subscribeOn(Schedulers.io())
                .map(function)//在这里进行网络操作
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object data) throws Exception {
                        //上面的function的处理结果就会到data上
                        if(data==null){
                            return;
                        }
                        //把数据发送到表示层
                        send(data);
                    }
                });
    }
    public void send(Object data){
        for (Object subscriber : subscribers) {
            //扫描注解，将数据发送到注册的对象标记的位置(一个方法)
            //subscriber表示层
            callMethodByAnnotation(subscriber,data);
        }

    }

    private void callMethodByAnnotation(Object target, Object data) {
        //1.得到presenter中写的所有的方法
        Method[] methodArray = target.getClass().getDeclaredMethods();
        for(int i=0;i<methodArray.length;i++){
            try {
                //2.如果哪个方法上用了我们写的注解，就把数据输入
                if (methodArray[i].getAnnotation(RegisterRxBus.class) != null) {
                    Class paramType = methodArray[i].getParameterTypes()[0];
                    if (data.getClass().getName().equals(paramType.getName())) {
                        System.out.println(data.getClass().getName());
                        System.out.println(paramType.getName());
                        //执行
                        methodArray[i].invoke(target, new Object[]{data});
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }

}


















