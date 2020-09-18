package ru.smeshariki.emotions.ui.moodnews

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var ownerImageCiv: CircleImageView =
        itemView.findViewById(R.id.owner_image)
    private var ownerNameTv: TextView =
        itemView.findViewById(R.id.owner_name)
    private var timeTv: TextView =
        itemView.findViewById(R.id.post_time)
    private var textTv: TextView =
        itemView.findViewById(R.id.post_text)
    private var likesNumberTv: TextView =
        itemView.findViewById(R.id.likes_number)
    private var commentsNumberTv: TextView =
        itemView.findViewById(R.id.comment_number)
    private var repostsNumberTv: TextView =
        itemView.findViewById(R.id.reposts_number)
    private var viewsNumberTv: TextView =
        itemView.findViewById(R.id.views_number)

    fun bind(post: Post){
        //ownerImageCiv.setImageIcon()
        ownerNameTv.text = post.ownerName
        timeTv.text = post.time
        textTv.text = post.text
        likesNumberTv.text = post.likesNumber.toString()
        commentsNumberTv.text = post.commentsNumber.toString()
        repostsNumberTv.text = post.repostsNumber.toString()
        viewsNumberTv.text = post.viewsNumber.toString()
    }
}