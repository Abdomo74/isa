package com.githubapp.mvp.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.githubapp.mvp.R
import com.githubapp.mvp.ui.login.LoginManager
import com.githubapp.mvp.ui.splash.SplashActivity
import com.githubapp.mvp.utils.startActivity
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), IBaseView {
    @Inject
    lateinit var loginManager: LoginManager

    override fun errorNetwork() {
        Toast.makeText(this, getString(R.string.error_network), Toast.LENGTH_LONG).show()
    }

    override fun errorUnknown() {
        Toast.makeText(this, getString(R.string.error_unknown), Toast.LENGTH_LONG).show()
    }

    override fun errorAccess() {
        loginManager.logout()
        startActivity(this, SplashActivity::class.java, clear = true)

        Toast.makeText(this, getString(R.string.error_access), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}