package com.example.islamiapp.UI.MainActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.Data.Quraanlist
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge(
            SystemBarStyle.dark(0), SystemBarStyle.dark(0)
        )
        Quraanlist.fillQuraanList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        replaceFragment(QuraanFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            replaceFragmentByID(it)
            true
        }

    }

    private fun replaceFragmentByID(it: MenuItem) {
        when (it.itemId) {
            R.id.quraan -> replaceFragment(QuraanFragment())
            R.id.ahadeeth -> replaceFragment(AhadeethFragment())
            R.id.radio -> replaceFragment(RadioFragment())
            R.id.sebha -> replaceFragment(SebhaFragment())

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}