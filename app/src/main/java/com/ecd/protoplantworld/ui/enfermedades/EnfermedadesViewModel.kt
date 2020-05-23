package com.ecd.protoplantworld.ui.enfermedades

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EnfermedadesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Enfermedades"
    }
    val text: LiveData<String> = _text
}