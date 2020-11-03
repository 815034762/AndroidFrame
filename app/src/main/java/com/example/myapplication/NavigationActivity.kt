package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.utils.DateUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

class NavigationActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val intent = Intent(context, NavigationActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }
}