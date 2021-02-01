package com.example.filingcabinet.data.locale

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.filingcabinet.data.locale.entity.EmployeeLocaleEntity
import com.example.filingcabinet.data.locale.entity.SpecialtyLocaleEntity

@Database(
    entities = [SpecialtyLocaleEntity::class, EmployeeLocaleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun employeesDao(): EmployeesDao

    companion object {

        private const val DB_NAME = "filling_cabinet"

        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

}