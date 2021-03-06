package com.example.tome.component_base.base.mvp;

import android.content.Context;
import android.support.annotation.CallSuper;

import com.example.tome.component_base.base.mvp.inter.IModel;
import com.example.tome.component_base.base.mvp.inter.IPresenter;
import com.example.tome.component_base.base.mvp.inter.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Created by TOME .
 * @时间 2018/5/3 12:40
 * v泛型p,实现v,就是v,构造p调用p层方法;p泛型v,v调用v的方法,
 * @描述 ${管理事件流订阅的生命周期CompositeDisposable}
 */

public abstract class BasePresenter<V extends IView,M extends IModel> {

    protected V mView;
    protected M mModel;


    @CallSuper
    public void attachView(V view) {
        this.mView = view;
        if (mModel == null) {
            mModel = createModel();
        }
    }

    @CallSuper
    public void detachView() {
        if (mModel != null) {
            mModel.clearPool();
        }
        mModel = null;
        mView = null;
    }


    public Context getContext() {
        return mView.getContext();
    }
    public M getModel(){
        return  mModel;
    }

    protected abstract M createModel();

}
