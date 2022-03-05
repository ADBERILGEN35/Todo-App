package com.example.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacakisler")

data class Isler (@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "yapilacak_is_id") @NotNull var yapilacak_is_id: Int,
                  @ColumnInfo(name = "yapilacak_is_ad") @NotNull var yapilacak_is_ad: String,
) : Serializable {


}