package com.ibrajix.prime.ui.utils

import android.content.Context

object Utility {

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.smallestScreenWidthDp >= 600
    }

}