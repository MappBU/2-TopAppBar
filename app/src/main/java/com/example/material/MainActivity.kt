package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Показывает Бар
        setSupportActionBar(binding?.topAppBar)

        // Обработка тапов по бару
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem: MenuItem ->

            when (menuItem.itemId) {
                R.id.favoritesTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Favorites()).commit()
                    true
                }

                R.id.settingsTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Settings()).commit()
                    true
                }

                R.id.cloudTopItemId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Cloud()).commit()
                    true
                }

                else -> false
            }

        }

    }

    // Обязательно надуваем Бар
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_menu, menu)

        return true

    }
}