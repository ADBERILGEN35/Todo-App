package com.example.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentIsDetayBinding
import com.example.todoapp.viewmodel.IsDetayFragmentViewModel
import com.example.todoapp.viewmodel.IsDetayVMF


class IsDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentIsDetayBinding
    private lateinit var viewModel: IsDetayFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_is_detay, container, false)
        tasarim.isDetayFragment = this

        tasarim.isDetayToolbarBaslik = "İş Detay"


        val bundle: IsDetayFragmentArgs by navArgs()
        val gelenIs = bundle.isi

        tasarim.isNesnesi = gelenIs



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: IsDetayFragmentViewModel by viewModels() {
            IsDetayVMF(requireActivity().application)

        }
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(yapilacak_is_id: Int, yapilacak_is_ad: String) {
        viewModel.guncelle(yapilacak_is_id, yapilacak_is_ad)
    }

}