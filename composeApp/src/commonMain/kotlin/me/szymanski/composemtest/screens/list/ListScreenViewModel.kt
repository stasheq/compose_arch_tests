package me.szymanski.composemtest.screens.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListScreenViewModel : ViewModel() {

    val list: StateFlow<List<String>?> = MutableStateFlow<List<String>?>(listOf("a", "b"))
}
