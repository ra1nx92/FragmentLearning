package com.example.fragmentlearning

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentlearning.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {
    private lateinit var binding: FragmentRootBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)

        binding.greenBtn.setOnClickListener {
            openBox(Color.rgb(200, 255, 200))

        }
        binding.yellowBtn.setOnClickListener {
            openBox(Color.rgb(255, 255, 200))
        }
        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE, viewLifecycleOwner){ _, data -> // 1 парамер игнор если он используется для одного результата
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(),"Generated number :$number", Toast.LENGTH_SHORT).show()


        }
    }

    private fun openBox(color: Int) {
        findNavController().navigate(
            R.id.action_rootFragment_to_boxFragment,
            bundleOf(BoxFragment.ARG_COLOR to color)
        )
    }
}