package com.ibrajix.prime.ui.activities

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.ActivityMainBinding
import com.ibrajix.prime.databinding.ToolbarBinding
import com.ibrajix.prime.ui.utils.Constants.COMPRESSED_WIDTH_MOBILE
import com.ibrajix.prime.ui.utils.Constants.COMPRESSED_WIDTH_TABLET
import com.ibrajix.prime.ui.utils.Constants.EXPANDED_WIDTH_MOBILE
import com.ibrajix.prime.ui.utils.Constants.EXPANDED_WIDTH_TABLET
import com.ibrajix.prime.ui.utils.Utility
import kotlin.math.exp


class MainActivity : AppCompatActivity() {

    //find views using viewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding: ToolbarBinding

    //get navHost fragment
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    private var expandedWidth: Int = EXPANDED_WIDTH_MOBILE
    var compressedWidth: Int = COMPRESSED_WIDTH_MOBILE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        toolbarBinding = binding.includedToolbar
        setContentView(binding.root)

        initView()
    }

    private fun initView(){

        //declare variables/initialize
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        handleActionBar()
    }


    private fun handleActionBar(){

        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_master)
        val fragmentParams: ViewGroup.LayoutParams? = fragment?.view?.layoutParams

        if(Utility.isTablet(this)){
            expandedWidth = EXPANDED_WIDTH_TABLET
            compressedWidth = COMPRESSED_WIDTH_TABLET
        }
        else {
            expandedWidth = EXPANDED_WIDTH_MOBILE
            compressedWidth = COMPRESSED_WIDTH_MOBILE
        }


        binding.includedToolbar.toolbar.setNavigationOnClickListener {

            if (fragmentParams?.width!! >= expandedWidth){
                fragmentParams.width = compressedWidth
                fragment.view?.layoutParams = fragmentParams
            }
            else{
                fragmentParams.width = expandedWidth
                fragment.view?.layoutParams = fragmentParams
            }

        }

    }


   override fun onBackPressed() {

       val fragment = supportFragmentManager.findFragmentById(R.id.fragment_master)
       val fragmentParams: ViewGroup.LayoutParams? = fragment?.view?.layoutParams

        if (fragmentParams?.width!! >= expandedWidth){
            fragmentParams.width = compressedWidth
            fragment.view?.layoutParams = fragmentParams
        }
        else{
            super.onBackPressed()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }


}