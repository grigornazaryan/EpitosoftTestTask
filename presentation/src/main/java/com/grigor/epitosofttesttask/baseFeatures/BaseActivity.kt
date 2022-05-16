package com.grigor.epitosofttesttask.baseFeatures

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.grigor.epitosofttesttask.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected abstract val inflater: (LayoutInflater) -> VB

    private lateinit var _mBinding: VB
    private val mBinding get() = _mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initViews()
        initViewModel()

    }

    private fun initDataBinding() {
        _mBinding = inflater.invoke(layoutInflater).also {
            setContentView(it.root)
        }
    }

    protected abstract fun initViews()
    protected open fun initViewModel() {}
    protected open fun <T> chooseState(state: T) {}


    protected open fun onError(message: String?, retry: () -> Unit) {
        if (message != null) {
            Snackbar.make(mBinding.root, message, Snackbar.LENGTH_INDEFINITE).apply {
                setActionTextColor(Color.WHITE)
                setAction(R.string.retry) { retry.invoke() }
                dismiss()
                show()
            }
        }
    }

    protected open fun onLoading() {

    }
}