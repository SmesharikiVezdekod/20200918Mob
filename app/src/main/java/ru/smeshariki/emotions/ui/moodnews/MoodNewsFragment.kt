package ru.smeshariki.emotions.ui.moodnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class MoodNewsFragment : Fragment() {

    private lateinit var moodNewsViewModel: MoodNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moodNewsViewModel =
            ViewModelProvider(this).get(MoodNewsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_mood_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.mood_news_list)
        val adapter = NewsRvAdapter()
        moodNewsViewModel.posts.observe(viewLifecycleOwner,
            Observer<ArrayList<Post>> {posts ->
                adapter.setPosts(posts)
            })
        recyclerView.adapter = adapter

        moodNewsViewModel.getAllPosts()
    }
}