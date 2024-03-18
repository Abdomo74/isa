package com.githubapp.mvp.ui.user

import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.ui.base.IBaseView

interface IUserView : IBaseView {
    fun loadUser(user: User)
}