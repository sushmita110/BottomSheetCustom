package com.example.bottomsheet

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(object : BottomSheetAdapter.OnItemClickListener {
            override fun onProfileData(item: String) {
                test(item)
            }
        })
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    fun test(item: String) {
        Log.e("Tag", "$item")
    }

    fun onProfileData(label: String) {
        object : InterfaceListener {
            override fun onItemClicked() {
                Log.e("Tag", "$label")
            }

        }
    }
}