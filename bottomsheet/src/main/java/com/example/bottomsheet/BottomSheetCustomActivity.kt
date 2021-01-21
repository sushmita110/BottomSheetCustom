package com.example.bottomsheet

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object BottomSheetCustomActivity {
    lateinit var bottomSheetAdapter: BottomSheetAdapter
    var context: Context? = null
    var clazz: Class<*>? = null

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
        Toast.makeText(context, "$item", Toast.LENGTH_LONG).show()
        context.startActivity(Intent(context, clazz))
    }

    fun onProfileData(label: String) {
        object : InterfaceListener {
            override fun onItemClicked() {
                Log.e("Tag", "$label")
            }

        }
    }
}