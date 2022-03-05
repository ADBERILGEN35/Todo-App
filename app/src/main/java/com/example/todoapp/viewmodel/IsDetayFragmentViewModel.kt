package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.repo.IslerRepository

class IsDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val irepo = IslerRepository(application)

    fun guncelle(yapilacak_is_id: Int, yapilacak_is_ad: String) {

        irepo.isiGuncelle(yapilacak_is_id, yapilacak_is_ad)

    }

}