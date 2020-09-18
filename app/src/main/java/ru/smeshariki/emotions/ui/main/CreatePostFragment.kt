package ru.smeshariki.emotions.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import ru.smeshariki.emotions.R


class CreatePostFragment : Fragment() {
    lateinit var visibleBtn: Button

    companion object {
        fun newInstance() = CreatePostFragment()
    }

    private lateinit var viewModel: CreatePostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.create_post_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setOnVisibleBtnClickListener()
    }

    private fun setOnVisibleBtnClickListener() {

        val popupMenu = PopupMenu(context, visibleBtn)
        popupMenu.inflate(R.menu.pop_up_menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    Toast.makeText(context, "Вы выбрали PopupMenu 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu2 -> {
                    Toast.makeText(context, "Вы выбрали PopupMenu 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu3 -> {
                    Toast.makeText(context, "Вы выбрали PopupMenu 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        popupMenu.setOnDismissListener {
            Toast.makeText(context, "onDismiss", Toast.LENGTH_SHORT).show()
        }
        visibleBtn.setOnClickListener {
            popupMenu.show()
        }
    }

    private fun initViews(view: View) {
        visibleBtn = view.findViewById(R.id.visible_btn)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = CreatePostViewModel()
        // TODO: Use the ViewModel
    }
}