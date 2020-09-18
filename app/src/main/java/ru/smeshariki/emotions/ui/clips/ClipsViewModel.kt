package ru.smeshariki.emotions.ui.clips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClipsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is clps Fragment"
    }
    val text: LiveData<String> = _text
}