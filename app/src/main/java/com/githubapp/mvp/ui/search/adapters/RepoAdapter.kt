package com.githubapp.mvp.ui.search.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.githubapp.mvp.R
import com.githubapp.mvp.data.models.User
import com.githubapp.mvp.data.models.Repo
import com.githubapp.mvp.ui.base.BaseAdapter

class RepoAdapter() : BaseAdapter<Repo, RepoViewHolder>() {
    interface ClickListener{
        fun onRepoClick(repo: Repo);
        fun onOwnerClick(user: User);
    }

    var clickListener: ClickListener = object: ClickListener{
        override fun onOwnerClick(user: User) {
        }

        override fun onRepoClick(repo: Repo) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repo, parent, false))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }

    override fun getItemCount(): Int {
        return items.count();
    }
}