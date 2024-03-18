package com.githubapp.mvp.helpers

import io.reactivex.disposables.Disposable

abstract class SimpleCallbackWrapper<T> : SimpleCallback<T>(){
    override fun onNext(t: T) {
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNetworkError() {
    }

    override fun onAccessError() {
    }

    override fun onUnknownError() {
    }
}