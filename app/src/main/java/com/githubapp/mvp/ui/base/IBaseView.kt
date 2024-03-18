package com.githubapp.mvp.ui.base

interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun errorNetwork()
    fun errorAccess()
    fun errorUnknown()
}