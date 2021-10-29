package com.example.fragmentlearning

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentlearning.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {
    private lateinit var binding: FragmentBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)
        // получение ключа ARG_COLOR с данными color из рут фрагмента
        val color = requireArguments().getInt(ARG_COLOR)
        // установка color как цвет фона
        binding.root.setBackgroundColor(color)

        binding.openSecretBtn.setOnClickListener {
            // переход на следующий фрагмент
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding.generateNumBtn.setOnClickListener {
            val random = Random.nextInt(100)
            //fragmentResultApi передача данных в предъидущий фрагмент
            parentFragmentManager.setFragmentResult(
                REQUEST_CODE,
                bundleOf(EXTRA_RANDOM_NUMBER to random)
            )
            //выход на предъидущий фрагмент
            findNavController().popBackStack()

        }
        binding.goBackBtn.setOnClickListener {
            //выход на предъидущий фрагмент
            findNavController().popBackStack()
        }
    }

    companion object {
        const val ARG_COLOR = "color"
        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE" //получаем результат fragmentResultApi
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER" //само значение random
    }
}