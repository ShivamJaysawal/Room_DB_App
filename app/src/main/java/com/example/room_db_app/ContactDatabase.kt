package com.example.room_db_app

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 3)
@TypeConverters(Convertors::class)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao() : ContactDao

    companion object{

        val migration_1_2 = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")

            }
        }

        val migration_2_3 = object : Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN DOB TEXT NOT NULL DEFAULT('NA')")

            }

        }

        @Volatile
        private var INSTANCE : ContactDatabase? = null

        fun getDatabase(contex:Context):ContactDatabase{
            if(INSTANCE==null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(contex.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB").addMigrations(migration_1_2,migration_2_3)
                        .build()
                }
            }
            return INSTANCE!! //we know it can not be null
        }
    }

}