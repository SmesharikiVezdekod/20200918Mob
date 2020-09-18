package ru.smeshariki.emotions.data

data class Post constructor(
    val ownerName: String,
    val ownerImageURI: String,
    val time: String,
    val text: String,
    val likesNumber: Int,
    val commentsNumber: Int,
    val repostsNumber: Int,
    val viewsNumber: Int
)