package com.githubapp.mvp.ui.splash

import android.os.Bundle
import android.os.Handler
import com.githubapp.mvp.R
import com.githubapp.mvp.ui.base.BaseActivity
import com.githubapp.mvp.ui.login.LoginActivity
import com.githubapp.mvp.ui.search.SearchActivity
import com.githubapp.mvp.utils.startActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : BaseActivity(), ISplashView {
    @Inject lateinit var presenter: SplashPresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.attachView(this)

        Handler().postDelayed({
            presenter.checkLogin()
        },3000)
    }

    override fun navigateToMain() {
        startActivity(this, SearchActivity::class.java, clear = true)
    }

    override fun navigateToLogin() {
        startActivity(this, LoginActivity::class.java, clear = true)
    }
}
