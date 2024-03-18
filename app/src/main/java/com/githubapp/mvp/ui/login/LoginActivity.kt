package com.githubapp.mvp.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.githubapp.mvp.R
import com.githubapp.mvp.ui.base.BaseActivity
import com.githubapp.mvp.ui.search.SearchActivity
import com.githubapp.mvp.utils.startActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), ILoginView {
    @Inject lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener{ onLoginClick() }

        presenter.attachView(this)
    }

    fun onLoginClick(){
        presenter.login(
                editEmail.text.toString(),
                editPassword.text.toString())
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        content.visibility = View.GONE}


    override fun hideLoading() {
        progress.visibility = View.GONE
        content.visibility = View.VISIBLE
    }

    override fun loginSucceeded() {
        startActivity(this, SearchActivity::class.java, clear = true)
    }

    override fun loginFailed() {
        Toast.makeText(this, getString(R.string.message_wrong_credentials), Toast.LENGTH_LONG).show()
    }
}
