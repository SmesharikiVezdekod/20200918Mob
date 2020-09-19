package ru.smeshariki.emotions.ui.interestingNews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.data.Post

class InterestingNewsFragment : Fragment() {

    private lateinit var interestingNewsViewModel: InterestingNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        interestingNewsViewModel =
            ViewModelProvider(this).get(InterestingNewsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_interesting_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.mood_news_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = InterestingNewsRvAdapter()
        interestingNewsViewModel.posts.observe(viewLifecycleOwner,
            Observer<ArrayList<Post>> { posts ->
                adapter.setPosts(posts)
            })
        recyclerView.adapter = adapter

        interestingNewsViewModel.getAllPosts()
    }
}