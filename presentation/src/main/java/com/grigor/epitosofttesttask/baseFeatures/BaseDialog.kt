package com.grigor.epitosofttesttask.baseFeatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<VB : ViewBinding> : DialogFragment() {
    protected abstract val inflater: (LayoutInflater) -> VB

    private lateinit var _mBinding: VB
    private val mBinding get() = _mBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initDataBinding()
        initViews()
        return _mBinding.root
    }

    private fun initDataBinding() {
        _mBinding = inflater.invoke(layoutInflater)
    }

    protected abstract fun initViews()
}