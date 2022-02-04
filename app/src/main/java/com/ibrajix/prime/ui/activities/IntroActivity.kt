package com.ibrajix.prime.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrajix.prime.R
import com.ibrajix.prime.databinding.ActivityIntroBinding
import com.ibrajix.prime.utils.Constants.DELAY_ACTIVITY
import com.ibrajix.prime.utils.delayWithCoroutines
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
       setUpIntroAnimation()
    }

    private fun setUpIntroAnimation(){

        //delay for 3 seconds just to show the cute little law animation
        binding.root.delayWithCoroutines(DELAY_ACTIVITY){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}