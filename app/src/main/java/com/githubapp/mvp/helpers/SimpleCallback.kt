package com.githubapp.mvp.helpers

import io.reactivex.Observer
import retrofit2.HttpException
import java.io.IOException

abstract class SimpleCallback<T> : Observer<T> {
    override fun onError(exception: Throwable) {
        when(exception){
            is HttpException -> {
                val httpException: HttpException = exception
                when(httpException.code()){
                    401 -> { onAccessError() }
                }
            }
            is IOException -> {
                onNetworkError()
            }
            else -> {
                onUnknownError()
            }
        }
    }

    abstract fun onNetworkError()

    abstract fun onAccessError()

    abstract fun onUnknownError()
}