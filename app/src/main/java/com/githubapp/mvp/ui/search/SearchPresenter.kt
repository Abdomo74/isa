package com.githubapp.mvp.ui.search

import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.data.models.Sort
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.source.DataSource
import com.githubapp.mvp.helpers.SimpleCallbackWrapper
import com.githubapp.mvp.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchPresenter() : BasePresenter<ISearchView>(), ISearchPresenter {
    private lateinit var dataSource: DataSource

    @Inject
    constructor(dataSource: DataSource) : this() {
        this.dataSource = dataSource
    }

    override fun loadRepos(page: Int, query: String, sort: Int, clear: Boolean) {
        var query: String = query
        if(query.isBlank())
            query = "a"

        getView()?.showLoading()
        dataSource.getRepos(page,query, Sort.findByID(sort)!!.value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: SimpleCallbackWrapper<List<Repo>>(){
                    override fun onNext(t: List<Repo>) {
                        if(clear)
                            getView()?.clearRepos()
                        getView()?.addRepos(t)
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

    override fun onProfileClick() {
        getView()?.navigateToProfile()
    }

    override fun onRepoClick(repo: Repo) {
        getView()?.navigateToRepo(repo.user.username, repo.name)
    }

    override fun onUserClick(user: User) {
        getView()?.navigateToUser(user.username)
    }

}