package com.maninmiddle.presentation.adapters.tests

import androidx.recyclerview.widget.DiffUtil
import com.maninmiddle.domain.model.Test

class TestsDiffCallback: DiffUtil.ItemCallback<Test>() {
    override fun areItemsTheSame(oldItem: Test, newItem: Test): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Test, newItem: Test): Boolean {
        return oldItem == newItem
    }
}