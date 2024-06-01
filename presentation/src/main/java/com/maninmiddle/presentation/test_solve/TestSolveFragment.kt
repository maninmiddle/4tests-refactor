package com.maninmiddle.presentation.test_solve

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maninmiddle.presentation.R
import com.maninmiddle.presentation.databinding.FragmentTestSolveBinding


class TestSolveFragment : Fragment() {
    private var _binding: FragmentTestSolveBinding? = null
    private val binding: FragmentTestSolveBinding
        get() = _binding ?: throw RuntimeException("FragmentTestSolveBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestSolveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}