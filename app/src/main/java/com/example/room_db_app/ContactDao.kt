package com.example.room_db_app

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDao {
    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

    @Query(" select * from contact")
    fun getContact() : LiveData<List<Contact>>
}