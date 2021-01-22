package com.example.bottomsheet

import android.content.Context

interface InterfaceListener {
    object DEFAULT : InterfaceListener {
        override fun onProfileData(context: Context, label: String) {}
    }

    fun onProfileData(context: Context, label: String)
}