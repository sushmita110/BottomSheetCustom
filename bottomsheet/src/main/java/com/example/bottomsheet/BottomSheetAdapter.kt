package com.example.bottomsheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.databinding.BottomSheetCustomViewBinding

class BottomSheetAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<BottomSheetAdapter.RecycleViewHolder>() {

    lateinit var binding: BottomSheetCustomViewBinding
    var items: MutableList<BottomSheetModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        binding =
            BottomSheetCustomViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.apply {
            itemView.apply {
                binding.ivIcon.setImageResource(items[position].image)
                binding.tvLabel.text = items[position].label
                setOnClickListener {
                    listener.onProfileData(
                        items[position]
                    )
                }
            }
        }
    }

    class RecycleViewHolder(binding: BottomSheetCustomViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface OnItemClickListener {
        fun onProfileData(item: BottomSheetModel)
    }
}
