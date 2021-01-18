package com.example.bottomsheetcustom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.bottom_sheet_custom_view.view.*


class BottomSheetAdapter :
    RecyclerView.Adapter<BottomSheetAdapter.RecycleViewHolder>() {

    var items: Array<String> = arrayOf()
    var images: IntArray = intArrayOf()

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
                iv_icon.setImageResource(images[position])
                tv_label.text = items[position]
            }
        }
    }

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}