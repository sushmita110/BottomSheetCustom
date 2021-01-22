package com.example.bottomsheet

import android.content.Context

interface InterfaceListener {
    object DEFAULT : InterfaceListener {
        override fun onProfileData(label: String) {}
    }

    fun onProfileData(label: String)
}