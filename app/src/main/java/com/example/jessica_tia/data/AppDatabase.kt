package com.example.jessica_tia.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.jessica_tia.data.dao.NoteDao
import com.example.jessica_tia.data.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE notes ADD COLUMN isPinned INTEGER NOT NULL DEFAULT 0")
            }
        }
        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                .addMigrations(MIGRATION_1_2)
                .build().also { INSTANCE = it }
        }
    }
}
