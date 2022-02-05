package com.ibrajix.prime.utils

import android.content.Context


object Utility {

    fun isTablet(context: Context): Boolean {
        return context.resources.configuration.smallestScreenWidthDp >= 600
    }

    fun calculateNoOfColumns(
        context: Context,
        columnWidthDp: Int
    ): Int {
        // For example columnWidthdp=180
        val displayMetrics = context.resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / columnWidthDp + 0.5).toInt()
    }

}