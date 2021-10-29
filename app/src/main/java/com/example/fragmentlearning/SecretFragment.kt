package com.example.fragmentlearning

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentlearning.databinding.FragmentSecretBinding

class SecretFragment:Fragment(R.layout.fragment_secret) {
    private lateinit var binding:FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        binding.closeBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.goToFirstBtn.setOnClickListener {
            //переход с последнего на первый фрагмент, хотим ли закрыть этот фрагмент true\false
            findNavController().popBackStack(R.id.rootFragment, false)
        }
    }
}