package ru.smeshariki.emotions.ui.main

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R


class CreatePostFragment : Fragment() {
    lateinit var visibleBtn: Button
    lateinit var recyclerView: RecyclerView
    lateinit var itemListBtn: List<BtnInfo>


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
        //  setOnVisibleBtnClickListener()
        initRecycler()
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = Adapter(itemListBtn, object : OnItemClickListener {
            override fun onClick(position: Int) {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = adapter
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
        //visibleBtn = view.findViewById(R.id.visible_btn)
        recyclerView = view.findViewById(R.id.list_of_btn)

        val img1: Drawable? =
            ResourcesCompat.getDrawable(resources, R.drawable.visible_btn_icon, null)

        val btn1 = BtnInfo(img1, "Visible to all")

        val img2: Drawable? =
            ResourcesCompat.getDrawable(resources, R.drawable.time_icon, null)

        val btn2 = BtnInfo(img2, getString(R.string.now))


        val btn3 = BtnInfo(null, getString(R.string.mood))

        val btn4 = BtnInfo(null, getString(R.string.thematics))
        itemListBtn = listOf(btn1, btn2, btn3, btn4)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = CreatePostViewModel()
        // TODO: Use the ViewModel
    }
}