package com.example.todoapp.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.entity.Isler
import com.example.todoapp.repo.IslerRepository

class AnasayfaFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val irepo = IslerRepository(application)
    var islerListesi = MutableLiveData<List<Isler>>()

    init {
        isleriYukle()
        islerListesi = irepo.isleriGetir()
    }

    fun ara(aramaKelimesi: String) {
        irepo.isiAra(aramaKelimesi)
    }

    fun sil(yapilacak_is_id: Int) {
        irepo.isiSil(yapilacak_is_id)
    }

    fun isleriYukle() {
        irepo.tumIsleriAl()
    }


}