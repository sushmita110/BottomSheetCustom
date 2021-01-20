package com.example.bottomsheetcustom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bottom_sheet_custom_view.view.*


class BottomSheetAdapter(private val onItemClick: OnItemClickListener) :
    RecyclerView.Adapter<BottomSheetAdapter.RecycleViewHolder>() {

    var items: MutableList<BottomSheetModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.bottom_sheet_custom_view, parent, false)
        return RecycleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.apply {
            itemView.apply {
                iv_icon.setImageResource(items[position].image)
                tv_label.text = items[position].label
                setOnClickListener {
                    onItemClick.onProfileData(
                        items[position].label)
                }
            }
        }
    }

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onProfileData(label: String)
    }
}