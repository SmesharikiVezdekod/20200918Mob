package ru.smeshariki.emotions.ui.moodnews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class NewsRvAdapter : RecyclerView.Adapter<NewsItemViewHolder>() {
    private var posts: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder =
        NewsItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.news_item, parent, false) as LinearLayout
        )


    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: ArrayList<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }
}