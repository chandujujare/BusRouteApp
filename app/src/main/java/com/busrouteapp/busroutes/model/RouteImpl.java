package com.busrouteapp.busroutes.model;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chandrasekharrao.j on 02-11-2017.
 */

public class RouteImpl {
    private RouteListener listener;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public RouteImpl(RouteListener listener) {
        this.listener = listener;
    }

    public void getRoutes() {
        RouteService service = RestClient.createService(RouteService.class);
        mCompositeDisposable.add(service.getRoutes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Routes>() {

                    @Override
                    public void onSuccess(Routes routes) {
                        listener.showRoutes(routes.getRoutes());
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e);
                    }
                }));
    }


}
