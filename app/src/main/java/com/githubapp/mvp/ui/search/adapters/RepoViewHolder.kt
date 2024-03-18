package com.githubapp.mvp.ui.search.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.githubapp.mvp.data.models.Repo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(repo: Repo, clickListener: RepoAdapter.ClickListener){
        itemView.textUser.text = repo.user.username
        itemView.textName.text = repo.name
        itemView.textWatchers.text = repo.watchers.toString()
        itemView.textForks.text = repo.forks.toString()
        itemView.textIssues.text = repo.issues.toString()

        itemView.setOnClickListener { clickListener.onRepoClick(repo) }
        itemView.imageThumbnail.setOnClickListener { clickListener.onOwnerClick(repo.user) }

        Glide   .with(itemView.context)
                .load(repo.user.image)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.imageThumbnail)
    }
}