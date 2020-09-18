package ru.smeshariki.emotions.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ru.smeshariki.emotions.R
import ru.smeshariki.emotions.ui.createPost.CreatePostFragment

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel
    lateinit var createPostBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        createPostBtn = root.findViewById(R.id.create_post_btn)
        profileViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setOnCreatePostBtnClickListener()
    }

    private fun setOnCreatePostBtnClickListener() {

        createPostBtn.setOnClickListener {
            createPostBtn.visibility = View.GONE
            val createPostFragment = CreatePostFragment()

            val fragmentTransaction: FragmentTransaction =
                activity?.supportFragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, createPostFragment)
            fragmentTransaction.commit()
        }
    }
}