package com.alexmumo.presentation.bookmarks

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.database.entity.BookMarkEntity
import com.alexmumo.domain.repository.BookMarkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookMarkViewModel constructor(private val bookMarkRepository: BookMarkRepository): ViewModel() {
    val bookMarkedNews = bookMarkRepository.getBookMarks()
    fun saveBookMark(bookMarkEntity: BookMarkEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            bookMarkRepository.saveBookMark(bookMarkEntity)
        }
    }
    fun deleteBookMarkedNews() {
        viewModelScope.launch {
            bookMarkRepository.deleteBookMark()
        }
    }
}