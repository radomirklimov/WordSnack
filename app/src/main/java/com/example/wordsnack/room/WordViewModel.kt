package com.example.wordsnack.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val newWordDao = NewWordDatabase.getDatabase(application).newWordDao()

    //Insert a new word
    fun insertNewWord(word: String) {
        val newWord = WordEntity(
            word = word
        )
        viewModelScope.launch {
            newWordDao.insert(newWord)
        }
    }

    suspend fun getWordById(id: Int): WordEntity? {
        return newWordDao.getWordById(id)
    }


    //private val _allWords = MutableStateFlow<List<WordEntity>>(emptyList())
    //val allWords: StateFlow<List<WordEntity>> = _allWords

    suspend fun fetchAllWords(): List<WordEntity>{
        return newWordDao.getAllWords()
    }
}