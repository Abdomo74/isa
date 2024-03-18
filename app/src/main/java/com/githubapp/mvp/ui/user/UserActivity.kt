package com.githubapp.mvp.ui.user

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.githubapp.mvp.R
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.ui.base.BaseActivity
import com.githubapp.mvp.ui.search.SearchActivity
import com.githubapp.mvp.utils.startBrowser
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : BaseActivity(), IUserView {
    @Inject lateinit var presenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        presenter.attachView(this)
        presenter.getUser(intent.extras?.getString(SearchActivity.EXTRA_USER)!!)
    }

    override fun loadUser(user: User) {
        Glide   .with(this)
                .load(user.image)
                .apply(RequestOptions.circleCropTransform())
                .into(imageUser)

        textUsername.text = user.username

        buttonView.setOnClickListener{
            startBrowser(this, user.url)
        }

        infoName.text = user.name
        infoBio.text = user.bio
        infoEmail.text = user.email
        infoLocation.text = user.location
        infoCompany.text = user.company
        infoUsername.text = user.username
        infoType.text = user.type
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
