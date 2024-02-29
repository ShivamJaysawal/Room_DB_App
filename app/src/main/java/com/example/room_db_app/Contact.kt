package com.example.room_db_app

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val phone : String,
    val createDate : Date,
    val isActive:Int, //0 inactive, 1 active
    val DOB:String

        )

