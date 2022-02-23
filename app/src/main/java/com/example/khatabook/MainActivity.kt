package com.example.khatabook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        loadFragment(HomeFrag())
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment
            when (item.itemId) {
                R.id.one -> {
                    fragment = HomeFrag()
                    Toast.makeText(this,"1 clicked",Toast.LENGTH_SHORT).show()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.two -> {
                    fragment = Money()
                    Toast.makeText(this,"2 clicked",Toast.LENGTH_SHORT).show()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.three -> {
                    fragment = MoreFrag()
                    Toast.makeText(this,"3 clicked",Toast.LENGTH_SHORT).show()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container,fragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}