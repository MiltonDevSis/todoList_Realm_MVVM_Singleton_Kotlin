package com.example.todolist_realm_mvvm.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.todolist_realm_mvvm.R
import io.realm.Realm

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        Realm.init(this)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.fab -> {
                startActivity(Intent(this, AddOrUpdateActivity::class.java))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}