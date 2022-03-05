package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.entity.Isler

@Dao
interface IslerDao {
    @Query("SELECT * FROM yapilacakisler")
    suspend fun tumIsler(): List<Isler>


    @Insert
    suspend fun isiEkle(isi: Isler)

    @Update
    suspend fun isiGuncelle(isi: Isler)

    @Delete
    suspend fun isiSil(isi: Isler)


    @Query("SELECT * FROM yapilacakisler WHERE yapilacak_is_ad like '%'||:aramaKelimesi||'%'")
    suspend fun isiArama(aramaKelimesi: String): List<Isler>


}