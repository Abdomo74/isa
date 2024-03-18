package com.githubapp.mvp.ui.profile

import com.githubapp.mvp.ui.base.IBasePresenter

interface IProfilePresenter : IBasePresenter<IProfileView> {
    fun getAuthenticatedUser()
    fun logout()
}