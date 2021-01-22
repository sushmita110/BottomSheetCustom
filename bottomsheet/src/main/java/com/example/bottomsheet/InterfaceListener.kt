package com.example.bottomsheet

import android.content.Context

interface InterfaceListener {
    object DEFAULT : InterfaceListener {
        override fun onProfileData(label: String) {}
        override fun startActivityTest(context: Context, clazz: Class<*>) {}
    }

    fun onProfileData(label: String)

    fun startActivityTest(context: Context,clazz: Class<*>)
}