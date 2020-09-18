package ru.smeshariki.emotions.ui.createPost

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.smeshariki.emotions.R
import java.util.*


class CreatePostFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageIcon: ImageView
    private lateinit var musicIcon: ImageView
    private lateinit var itemListBtn: List<BtnInfo>
    private var dateAndTime: Calendar = Calendar.getInstance()

    companion object {
        fun newInstance() = CreatePostFragment()
        private const val REQUEST_BROWSE_PICTURE = 666
        private const val REQUEST_BROWSE_AUDIO = 111
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
        initRecycler()
        setOnImageIconClickListener()
        setOnMusicIconClickListener()
    }

    private fun setOnMusicIconClickListener() {
        musicIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "audio/*"
            startActivityForResult(
                Intent.createChooser(intent, "Select audio"), REQUEST_BROWSE_AUDIO
            )
        }
    }

    private fun setOnImageIconClickListener() {
        imageIcon.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"), REQUEST_BROWSE_PICTURE
            )
        }
    }

    private fun initRecycler() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = Adapter(
            itemListBtn,
            object : OnItemClickListener {
                override fun onClick(position: Int, btn: Button) {
                    setOnVisibleBtnClickListener(btn, position)
                }
            })
        recyclerView.adapter = adapter
    }

    private fun setOnVisibleBtnClickListener(btn: Button, position: Int) {

        val popupMenu = PopupMenu(context, btn)

        popupMenu.inflate(R.menu.pop_up_menu)
        when (position) {
            0 -> {
                popupMenu.menu.setGroupVisible(R.id.menuGroupTime, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupMood, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupThematics, false)
            }
            1 -> {
                popupMenu.menu.setGroupVisible(R.id.menuGroupVisible, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupMood, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupThematics, false)
            }
            2 -> {
                popupMenu.menu.setGroupVisible(R.id.menuGroupVisible, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupTime, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupThematics, false)
            }
            3 -> {
                popupMenu.menu.setGroupVisible(R.id.menuGroupVisible, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupTime, false)
                popupMenu.menu.setGroupVisible(R.id.menuGroupMood, false)
            }
        }

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.visible -> {
                    btn.text = getString(R.string.visible_to_all)
                    true
                }
                R.id.friends -> {
                    btn.text = getString(R.string.only_friends)
                    true
                }
                R.id.nobody -> {
                    btn.text = getString(R.string.not_visible_to_anyone)
                    true
                }
                R.id.now -> {
                    btn.text = getString(R.string.now)
                    true
                }
                R.id.tomorrow -> {
                    btn.text = getString(R.string.tomorrow)
                    true
                }
                R.id.chooseData -> {
                    setData()
                    btn.text = DateUtils.formatDateTime(
                        context, dateAndTime.timeInMillis, DateUtils.FORMAT_SHOW_DATE
                    )
                    true
                }
                R.id.fire -> {
                    btn.text = getString(R.string.mood_fire)
                    true
                }
                R.id.boring -> {
                    btn.text = getString(R.string.mood_boring)
                    true
                }
                R.id.good -> {
                    btn.text = getString(R.string.mood_good)
                    true
                }
                R.id.it -> {
                    btn.text = getString(R.string.thematics_it)
                    true
                }
                R.id.art -> {
                    btn.text = getString(R.string.thematics_art)
                    true
                }
                R.id.photo -> {
                    btn.text = getString(R.string.thematic_photo)
                    true
                }
                else -> false
            }
        }

        btn.setOnClickListener {
            popupMenu.show()
        }
    }

    private fun setData() {
        context?.let {
            DatePickerDialog(
                it, OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    dateAndTime[Calendar.YEAR] = year
                    dateAndTime[Calendar.MONTH] = monthOfYear
                    dateAndTime[Calendar.DAY_OF_MONTH] = dayOfMonth
                },
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.list_of_btn)
        imageIcon = view.findViewById(R.id.image_icon)
        musicIcon = view.findViewById(R.id.music_icon)

        val img1: Drawable? =
            ResourcesCompat.getDrawable(resources, R.drawable.visible_btn_icon, null)

        val btn1 =
            BtnInfo(img1, getString(R.string.visible_to_all))

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