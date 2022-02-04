package com.ibrajix.prime.utils

import android.content.Context

object Utility {

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.smallestScreenWidthDp >= 600
    }

}