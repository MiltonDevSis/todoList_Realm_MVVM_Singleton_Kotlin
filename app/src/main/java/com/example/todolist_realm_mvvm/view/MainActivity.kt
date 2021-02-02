package com.example.todolist_realm_mvvm.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_realm_mvvm.R
import com.example.todolist_realm_mvvm.adapter.AdapterTarefa
import com.example.todolist_realm_mvvm.service.model.TarefaModel
import com.example.todolist_realm_mvvm.viewmodel.AddOrUpdateViewModel
import com.example.todolist_realm_mvvm.viewmodel.MainActivityViewModel
import es.dmoral.toasty.Toasty
import io.realm.Realm

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: MainActivityViewModel
    private val mAdapter: AdapterTarefa = AdapterTarefa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        Realm.init(this)

        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter

        mViewModel.list()

        observer()

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

    private fun observer(){
        mViewModel.listaTarefa.observe(this, Observer {
           if (it.isNotEmpty()) {
               Toasty.success(this, "tamanho: ${it.size}", Toasty.LENGTH_LONG).show()
               mAdapter.listar(it)
           }else{
               Toasty.error(this, "Vazio", Toasty.LENGTH_LONG).show()
           }
        })
    }
}