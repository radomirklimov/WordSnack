package com.example.wordsnack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class NewWordDatabase : RoomDatabase() {
    abstract fun newWordDao(): WordDao

    companion object {
        @Volatile
        private var INSTANCE: NewWordDatabase? = null

        fun getDatabase(context: Context): NewWordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewWordDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}