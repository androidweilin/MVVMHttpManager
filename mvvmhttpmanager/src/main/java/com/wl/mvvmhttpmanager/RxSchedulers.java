package com.wl.mvvmhttpmanager;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Freak
 * @date 2019/5/15.
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> observableIoMain() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> flowableIoMain() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
