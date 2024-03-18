package com.githubapp.mvp.ui.base

interface IBasePresenter<V: IBaseView> {
    fun attachView(view: V)
    fun getView(): V?
    fun detachView()
}