package com.ibrajix.prime.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView(){

    }

}