package ru.smeshariki.emotions.ui.interestingNews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class InterestingNewsRvAdapter : RecyclerView.Adapter<InterestingNewsItemViewHolder>() {
    private var posts: ArrayList<Post> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InterestingNewsItemViewHolder =
        InterestingNewsItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.interesting_news_item, parent, false) as CardView
        )


    override fun onBindViewHolder(holder: InterestingNewsItemViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }
}