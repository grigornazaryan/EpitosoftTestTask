package com.grigor.epitosofttesttask.views.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import com.grigor.epitosofttesttask.R
import com.grigor.epitosofttesttask.baseFeatures.BaseActivity
import com.grigor.epitosofttesttask.databinding.ActivitySplashBinding
import com.grigor.epitosofttesttask.views.wellsList.WellsListActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override val inflater: (LayoutInflater) -> ActivitySplashBinding
        get() = ActivitySplashBinding::inflate

    override fun initViews() {
        mBinding.splashImage.postDelayed({ transferToWellsListActivity() }, 300)
    }

    private fun transferToWellsListActivity() {
        val intent = Intent(this, WellsListActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.hold_anim)
        finish()
    }
}