package com.githubapp.mvp.ui.base

open class BasePresenter<V: IBaseView> : IBasePresenter<V> {
    var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun getView(): V? {
        return mView
    }

    override fun detachView() {
        mView = null
    }
}