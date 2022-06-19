package com.saxenasachin.redditpics.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.saxenasachin.presentation.base.BaseViewModel
import com.saxenasachin.presentation.viewmodel.RedditDataState
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
Created by Sachin Saxena on 19/06/22.
 */
abstract class BaseBindingActivity<VM : BaseViewModel<RedditDataState>, VB : ViewBinding>
    : AppCompatActivity(), HasAndroidInjector {

    lateinit var viewModel: VM

    lateinit var binding: VB

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        binding = provideViewBinding()
        setContentView(binding.root)
        setupObservers()
        setupView(savedInstanceState)
    }

    protected open fun setupObservers() {}

    fun openKeyboard() {
        currentFocus?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(currentFocus, InputMethodManager.SHOW_IMPLICIT)
            imm.showSoftInput(currentFocus, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun closeKeyboard() {
        currentFocus?.let {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            super.onBackPressed()
        }
    }

    protected abstract fun provideViewBinding(): VB

    protected abstract fun providePageName(): String

    protected abstract fun provideViewModel(): VM

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected fun enforceLtrLayout() {
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
    }
}