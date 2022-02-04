package com.ibrajix.prime.ui.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.ActivityMainBinding
import com.ibrajix.prime.databinding.ToolbarBinding
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.Nameable
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.util.setupWithNavController
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView


class MainActivity : AppCompatActivity() {

    //find views using viewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding: ToolbarBinding

    //get navHost fragment
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

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

        buildMiniSliderDrawer()

    }

    private fun buildMiniSliderDrawer(){

    }


    private fun handleActionBar(){
        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }


    override fun onBackPressed() {
        /*if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }


}