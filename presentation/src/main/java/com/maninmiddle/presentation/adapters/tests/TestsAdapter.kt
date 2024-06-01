package com.maninmiddle.presentation.adapters.tests

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maninmiddle.domain.model.Test
import com.maninmiddle.presentation.databinding.TestItemBinding

class TestsAdapter(val context: Context) : ListAdapter<Test, TestsViewHolder>(
    TestsDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestsViewHolder {
        val view = TestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestsViewHolder(view)
    }

    override fun onBindViewHolder(holder: TestsViewHolder, position: Int) {
        val test = getItem(position)

        holder.bind(test, context)
    }
}