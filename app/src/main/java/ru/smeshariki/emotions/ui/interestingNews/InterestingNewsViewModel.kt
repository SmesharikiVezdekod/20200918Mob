package ru.smeshariki.emotions.ui.interestingNews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.smeshariki.emotions.data.Post
import ru.smeshariki.emotions.data.PostsRepository

class InterestingNewsViewModel : ViewModel() {

    private val postsRepository: PostsRepository = PostsRepository()

    private val _posts = MutableLiveData<ArrayList<Post>>()
    val posts: LiveData<ArrayList<Post>> = _posts

    fun getAllPosts() {
        _posts.value = postsRepository.getAllPosts()
    }
}