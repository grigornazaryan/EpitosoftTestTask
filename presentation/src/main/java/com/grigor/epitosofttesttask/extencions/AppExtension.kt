package com.grigor.epitosofttesttask.extencions

import android.content.Intent
import com.grigor.epitosofttesttask.R
import com.grigor.epitosofttesttask.baseFeatures.BaseActivity


inline fun <reified activity : BaseActivity<*>> BaseActivity<*>.launchActivity(
    finish: Boolean, putArguments: (intent: Intent) -> Unit
) {
    val intent = Intent(this, activity::class.java)
    putArguments.invoke(intent)
    startActivity(intent)
    overridePendingTransition(R.anim.slide_in_right, R.anim.hold_anim)
    if (finish)
        finish()
}
