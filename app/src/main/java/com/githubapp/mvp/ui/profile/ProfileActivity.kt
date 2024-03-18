package com.githubapp.mvp.ui.profile

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.githubapp.mvp.R
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.ui.base.BaseActivity
import com.githubapp.mvp.ui.splash.SplashActivity
import com.githubapp.mvp.utils.startActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_profile.*
import javax.inject.Inject

class ProfileActivity : BaseActivity(), IProfileView {
    @Inject lateinit var presenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        presenter.attachView(this)
        presenter.getAuthenticatedUser()
    }

    override fun loadUser(user: User) {
        Glide   .with(applicationContext)
                .load(user.image)
                .apply(RequestOptions.circleCropTransform())
                .into(imageUser)

        textUsername.text = user.username

        buttonLogout.setOnClickListener{
           presenter.logout()
        }

        infoName.text = user.name
        infoBio.text = user.bio
        infoEmail.text = user.email
        infoLocation.text = user.location
        infoCompany.text = user.company
        infoUsername.text = user.username
        infoType.text = user.type
    }

    override fun navigateToSplash() {
        startActivity(this, SplashActivity::class.java, clear = true)
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        content.visibility = View.GONE
    }

    override fun hideLoading() {
        progress.visibility = View.GONE
        content.visibility = View.VISIBLE
    }
}
