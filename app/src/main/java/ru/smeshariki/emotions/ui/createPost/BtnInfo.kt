package ru.smeshariki.emotions.ui.createPost

import android.graphics.drawable.Drawable

class BtnInfo(private var image: Drawable?, private var name: String) {
    fun getImage() = image
    fun getName() = name
}