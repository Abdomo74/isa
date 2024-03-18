package com.githubapp.mvp.ui.profile

import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.ui.base.IBaseView

interface IProfileView : IBaseView {
    fun loadUser(user: User)
    fun navigateToSplash()
}