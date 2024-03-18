package com.githubapp.mvp.ui.user

import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.helpers.SimpleCallbackWrapper
import com.githubapp.mvp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserPresenter() : BasePresenter<IUserView>(), IUserPresenter {
    private lateinit var dataSource: DataSource

    @Inject
    constructor(dataSource: DataSource) : this() {
        this.dataSource = dataSource
    }

    override fun getUser(username: String) {
        getView()?.showLoading()
        dataSource.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: SimpleCallbackWrapper<User>(){
                    override fun onNext(t: User) {
                        getView()?.loadUser(t)
                        getView()?.hideLoading()
                    }

                    override fun onNetworkError() {
                        getView()?.errorNetwork()
                        getView()?.hideLoading()
                    }

                    override fun onAccessError() {
                        getView()?.errorAccess()
                        getView()?.hideLoading()
                    }

                    override fun onUnknownError() {
                        getView()?.errorUnknown()
                        getView()?.hideLoading()
                    }
                })
    }
}