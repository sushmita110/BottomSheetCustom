package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    var clazz: Class<*>? = null
    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(object : BottomSheetAdapter.OnItemClickListener {
            override fun onProfileData(item: String) {
                clazz?.let { test(context, it) }
            }
        })
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bottomSheetAdapter
        }

        bottomSheetAdapter.items = profileData
    }

    fun test(context: Context,clazz: Class<*>) {
        val intent = Intent(context, clazz)
        context.startActivity(intent)
    }
}