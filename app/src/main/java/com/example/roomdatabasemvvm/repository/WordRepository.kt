package com.example.roomdatabasemvvm.repository

import androidx.annotation.WorkerThread
import com.example.roomdatabasemvvm.database.daos.WordDao
import com.example.roomdatabasemvvm.database.models.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}