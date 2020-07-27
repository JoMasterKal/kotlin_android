package com.our_world_tkpl.materialdesign

import androidx.fragment.app.Fragment

interface NavigationHost {

    fun navigateTo(fragment: Fragment, addToBackStack: Boolean)
}