package com.maninmiddle.presentation.adapters.tests

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.maninmiddle.domain.model.Test
import com.maninmiddle.presentation.databinding.TestItemBinding
import com.maninmiddle.presentation.main.MainActivity
import com.maninmiddle.presentation.test_solve.TestSolveFragment

class TestsViewHolder(val binding: TestItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(test: Test, context: Context) {
        binding.tvTestName.text = test.name
        binding.tvTestSubject.text = test.subject
        binding.tvCompleteTime.text = test.completeTime.toString()
        binding.tvPasswordRequire.text =
            if (test.password.isNotEmpty()) "Требуется пароль" else "Пароль не требуется"
        binding.root.setOnClickListener {
            val mainActivity = context as MainActivity
            mainActivity.addFragment(TestSolveFragment())
        }
    }
}