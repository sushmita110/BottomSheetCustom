package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter

    private lateinit var clazz: Class<*>
    fun showEditDialog(
        context: Context,
        view: RecyclerView,
        profileData: MutableList<BottomSheetModel>
    ) {
        bottomSheetAdapter = BottomSheetAdapter(object : BottomSheetAdapter.OnItemClickListener {
            override fun onProfileData(item: String) {
                test(context, clazz)
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