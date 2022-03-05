package com.example.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.entity.Isler
import com.example.todoapp.fragment.AnasayfaFragmentDirections
import com.example.todoapp.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class IslerAdapter (
    var mContext: Context,
    var islerListesi: List<Isler>,
    var viewModel: AnasayfaFragmentViewModel
) :
    RecyclerView.Adapter<IslerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val isi = islerListesi.get(position)
        val t = holder.tasarim
        t.isNesnesi = isi

        t.satirCard.setOnClickListener {

            val gecis = AnasayfaFragmentDirections.isDetayGecis(isi = isi)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it, "${isi.yapilacak_is_ad} silinsin mi ?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(isi.yapilacak_is_id)
                }.show()
        }

    }


    override fun getItemCount(): Int {
        return islerListesi.size
    }


}