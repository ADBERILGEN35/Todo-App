package com.example.todoapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.Isler
import com.example.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IslerRepository (var application: Application) {
    var islerListesi: MutableLiveData<List<Isler>>

    var vt: Veritabani

    init {
        islerListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun isleriGetir(): MutableLiveData<List<Isler>> {

        return islerListesi

    }

    fun isKayit(yapilacak_is_ad: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniIs = Isler(0, yapilacak_is_ad)
            vt.islerDao().isiEkle(yeniIs)
        }
    }


    fun isiGuncelle(yapilacak_is_id: Int, yapilacak_is_ad: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Isler(yapilacak_is_id, yapilacak_is_ad)
            vt.islerDao().isiGuncelle(guncellenenIs)
        }
    }

    fun isiAra(aramaKelimesi: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().isiArama(aramaKelimesi)
        }
    }

    fun isiSil(yapilacak_is_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Isler(yapilacak_is_id, "")
            vt.islerDao().isiSil(silinenIs)
            tumIsleriAl()
        }
    }

    fun tumIsleriAl() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            islerListesi.value = vt.islerDao().tumIsler()
        }

    }
}