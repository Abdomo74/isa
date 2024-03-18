package com.githubapp.mvp.data.models

enum class Sort(val id: Int, val value: String) {
    STARS(0, "stars"),
    FORKS(1, "forks"),
    UPDATED(2, "updated");

    companion object {
        fun findByID(id: Int): Sort?{
            if(id == Sort.FORKS.id){
                return Sort.FORKS
            }
            if(id == Sort.STARS.id){
                return Sort.STARS
            }
            if(id == Sort.UPDATED.id){
                return Sort.UPDATED
            }
            return null
        }
    }
}