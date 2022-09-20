package com.ebac.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ebac.jokenpo.databinding.ActivityPlayerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class PlayerActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityPlayerBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar2

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root

        navDrawer = binding.navView
        bottomNav = binding.bottomNav

        setupToolBar()
        setupDrawer()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener {
                menuItem -> when(menuItem.itemId){
            R.id.bottom_option_1 -> {
                carregaPlayer(PlayerActivity::class.java)
                true
            }
            R.id.bottom_option_2 -> {
               carregaResult(ResultActivity::class.java)
                true
            }
            else -> false
        }
        }
    }

    private fun setupDrawer(){
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                R.id.drawer_player -> {
                    carregaPlayer(PlayerActivity::class.java)
                    true
                }
                R.id.drawer_result -> {
                    carregaResult(ResultActivity::class.java)
                    true
                }
                else -> false
            }

        }
    }

    private fun carregaPlayer(activity: Class<PlayerActivity>) {
        val activityIntent = Intent(this, activity)
        startActivity(activityIntent)
    }

    private fun carregaResult(activity: Class<ResultActivity>) {
        val activityIntent = Intent(this, activity)
        startActivity(activityIntent)
    }

    private fun setupToolBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    //Abre a drawer navigation essa opção é para AppCompatActivity
    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_settings -> {
                val  mainActivityIntent = Intent(this, MainActivity::class.java)
                startActivity(mainActivityIntent)
                true
            }
            else -> false
        }
    }
}