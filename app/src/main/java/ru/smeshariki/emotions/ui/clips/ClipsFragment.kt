package ru.smeshariki.emotions.ui.clips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.smeshariki.emotions.R

class ClipsFragment: Fragment() {
    private lateinit var clipsViewModel: ClipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        clipsViewModel =
            ViewModelProvider(this).get(ClipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_clips, container, false)
        val textView: TextView = root.findViewById(R.id.text_clips)
        clipsViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}