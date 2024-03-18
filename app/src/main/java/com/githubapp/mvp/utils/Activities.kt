package com.githubapp.mvp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle

fun startActivity(context: Context, activity: Class<*>, extras: Bundle = Bundle(),
                  clear: Boolean = false){
    val intent = Intent()
    intent.setClass(context, activity)
    intent.putExtras(extras)
    if(clear)
        intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK)

    context.startActivity(intent)
}

fun startBrowser(context: Context, link: String){
    val intent = Intent()
    intent.action = Intent.ACTION_VIEW
    intent.data = Uri.parse(link)

    context.startActivity(intent)
}