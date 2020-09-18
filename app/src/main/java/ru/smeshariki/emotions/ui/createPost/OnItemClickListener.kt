package ru.smeshariki.emotions.ui.createPost

import android.widget.Button

interface OnItemClickListener {
    fun onClick(position: Int, btn: Button)
}