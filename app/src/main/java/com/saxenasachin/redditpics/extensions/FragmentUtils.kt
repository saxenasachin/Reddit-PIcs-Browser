package com.saxenasachin.redditpics.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
Created by Sachin Saxena on 19/06/22.
 */
fun Fragment.addFragment(layoutId: Int, fragment: Fragment) {
    this.requireFragmentManager().beginTransaction().add(layoutId, fragment).commit()
}

fun Fragment.addChildFragment(layoutId: Int, fragment: Fragment) {
    this.childFragmentManager.beginTransaction().add(layoutId, fragment).commit()
}


fun Fragment.addFragmentBackStack(layoutId: Int, fragment: Fragment, tag: String) {
    this.fragmentManager?.beginTransaction()?.add(layoutId, fragment)?.addToBackStack(tag)
        ?.commit()
}

fun Fragment.replaceFragment(layoutId: Int, fragment: Fragment) {
    this.requireFragmentManager().beginTransaction().replace(layoutId, fragment).commit()
}

fun Fragment.replaceChildFragment(layoutId: Int, fragment: Fragment) {
    if (isAdded) {
        this.childFragmentManager.beginTransaction().replace(layoutId, fragment)
            .commitAllowingStateLoss()
    }
}

fun Fragment.replaceFragmentBackStack(layoutId: Int, fragment: Fragment, tag: String) {
    this.requireFragmentManager().beginTransaction().replace(layoutId, fragment).addToBackStack(tag)
        .commit()
}

fun Fragment.toast(message: String) {
    Toast.makeText(this.activity, message, Toast.LENGTH_SHORT).show()
}
