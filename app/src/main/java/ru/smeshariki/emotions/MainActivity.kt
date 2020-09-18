package ru.smeshariki.emotions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.smeshariki.emotions.ui.main.CreatePostFragment
import ru.smeshariki.emotions.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CreatePostFragment.newInstance())
                .commitNow()
        }
    }
}