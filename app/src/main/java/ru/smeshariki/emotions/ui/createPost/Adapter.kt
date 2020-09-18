package ru.smeshariki.emotions.ui.createPost

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R

class Adapter(itemList: List<BtnInfo>, onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var items: List<BtnInfo> = itemList
    private lateinit var context: Context
    private var listener: OnItemClickListener = onItemClickListener


    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var btn: Button = itemView.findViewById(R.id.btn)
        var listener: OnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.popup_btn_layout,
            parent, false
        )
        return ViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val img: Drawable? =
            ResourcesCompat.getDrawable(context.resources, R.drawable.arrow_down_icon, null)
        holder.btn.text = items[position].getName()
        holder.btn.setCompoundDrawablesWithIntrinsicBounds(
            items[position].getImage(), null, img, null
        )
        holder.btn.setOnClickListener { holder.listener.onClick(position, holder.btn) }
    }
}