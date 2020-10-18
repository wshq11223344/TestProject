package com.example.testpproject.rxjava;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    public void test1() {
        /**
         * Observable --- 被观察者
         * create  ---操作符
         * ObservableEmitter  ---  发射器向观察者发送事件
         */
        Observable<String> objectObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("Observable");
                emitter.onNext("1");
                emitter.onNext("6");

                emitter.onComplete();

            }
        });

        Observable<String> objectObservable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Throwable {

                emitter.onNext("Observable");
            }
        });


        // Flowable被观察者（背压）的创建
        Flowable<Object> objectFlowable = Flowable.create(new FlowableOnSubscribe<Object>() {

            @Override
            public void subscribe(FlowableEmitter<Object> emitter) throws Exception {

            }
        }, BackpressureStrategy.BUFFER);


        @NonNull Flowable<Object> objectFlowable1 = Flowable.create(new FlowableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Object> emitter) throws Throwable {

            }
        }, BackpressureStrategy.BUFFER);


        //Single 被观察者
        Single.create(new SingleOnSubscribe<Object>() {
            @Override
            public void subscribe(SingleEmitter<Object> emitter) throws Exception {

                emitter.onSuccess("1");
                emitter.onSuccess("2");
                emitter.onSuccess("3");

            }
        }).subscribe(new SingleObserver<Object>() {

            @Override
            public void onSubscribe(Disposable d) {

                System.out.println(d.isDisposed());
            }

            @Override
            public void onSuccess(Object o) {

                System.out.println(o);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

        //Completable 被观察者
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {

            }
        });

        //Maybe 被观察者
        Maybe.create(new MaybeOnSubscribe<Object>() {

            @Override
            public void subscribe(MaybeEmitter<Object> emitter) throws Exception {

                emitter.onSuccess("1");
                emitter.onSuccess("2");
                emitter.onSuccess("1");

            }
        }).subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

                System.out.println(d.isDisposed());
            }

            @Override
            public void onSuccess(@NonNull Object o) {

                System.out.println(o);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        // 观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe====" + d.isDisposed());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext====" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete====");
            }
        };

        //订阅
        objectObservable.subscribe(observer);


        Observable.just("1", 2, 3).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println(d.isDisposed());
            }

            @Override
            public void onNext(Object integer) {
                System.out.println("just===" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    /**
     * 转换操作符
     */
    public void text2() {

        Observable.just(1, 2, 3).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Throwable {

                return integer.toString();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("开始");

            }

            @Override
            public void onNext(@NonNull String o) {

                System.out.println(o);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("完成");


            }
        });

    }

    ;

    /**
     * 组合操作符
     */
    public void text3() {
        Observable.concat(Observable.just(1, 2),
                Observable.just(5, 6),
                Observable.just(3, 4),
                Observable.just(7, 8))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    ;

    /**
     * 功能操作符
     */
    public void text4() {
        Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(20, TimeUnit.SECONDS)
                .repeat(6)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe()");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * 过滤操作符
     */
    public void text5() {
        Observable.just(1, 2, 3).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Throwable {
                return integer < 3;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 条件操作符
     */
    public void text6() {
        Observable.just(1, 2, 3, 4)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 5;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Throwable {

                System.out.println(aBoolean);

            }
        });
    }


    /**
     * 背压
     */
    public void test7() {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {

                int i = 0;
                while (i < 20) {
                    i++;
                    emitter.onNext(i);
                }

            }
        }, BackpressureStrategy.BUFFER)
//                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(10);

                    }

                    @Override
                    public void onNext(Integer integer) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("onNext()===" + integer);
//                        Log.e("====", String.valueOf(integer));
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}