package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.repo.IslerRepository

class IsKayitFragmentViewModel (application: Application) : AndroidViewModel(application) {

    val irepo = IslerRepository(application)

    fun kayit(yapilacak_is_ad: String) {
        irepo.isKayit(yapilacak_is_ad)
    }

}