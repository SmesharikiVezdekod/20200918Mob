package ru.smeshariki.emotions.ui.interestingNews

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class InterestingNewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var ownerImageCiv: CircleImageView =
        itemView.findViewById(R.id.owner_image)
    private var ownerNameTv: TextView =
        itemView.findViewById(R.id.owner_name)

    fun bind(post: Post) {
        ownerNameTv.text = post.ownerName
    }
}