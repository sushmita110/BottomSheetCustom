package com.example.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.BottomSheetCustomViewBinding

open class BottomSheetAdapter :
    RecyclerView.Adapter<BottomSheetAdapter.RecycleViewHolder>() {
    lateinit var binding: BottomSheetCustomViewBinding
    var items: String = ""
    var images: IntArray = intArrayOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        binding =
            BottomSheetCustomViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.apply {
            itemView.apply {
                binding.ivIcon.setImageResource(images[position])
                binding.tvLabel.text = items
            }
        }
    }

    class RecycleViewHolder(binding: BottomSheetCustomViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}