package com.ibrajix.prime.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.ActivityMainBinding
import com.ibrajix.prime.ui.utility.setNavigationIconColor
import com.mikepenz.materialdrawer.util.setupWithNavController


class MainActivity : AppCompatActivity() {

    //find views using viewBinding
    private lateinit var binding: ActivityMainBinding

    //get navHost fragment
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView(){

        //declare variables/initialize
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()



        handleActionBar()

        buildMiniDrawer()

    }

    private fun buildMiniDrawer(){

        binding.slider.setupWithNavController(navController)

    }


    private fun handleActionBar(){
        setSupportActionBar(binding.toolbar.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }


}