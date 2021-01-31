package com.example.todolist_realm_mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.todolist_realm_mvvm.R
import com.example.todolist_realm_mvvm.realm.RealmManager
import com.example.todolist_realm_mvvm.viewmodel.AddOrUpdateViewModel
import com.google.android.material.textfield.TextInputEditText
import es.dmoral.toasty.Toasty

class AddOrUpdateActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: AddOrUpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_or_update)

        mViewModel = ViewModelProvider(this).get(AddOrUpdateViewModel::class.java)

        inicializaComponentes()
        observe()

    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnCancelar -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            R.id.btnAdicionar -> {
                val edtNovaAtividade: String = findViewById<TextInputEditText>(R.id.edtNovaAtividade).text.toString()
                mViewModel.save(edtNovaAtividade)
            }
        }
    }

    private fun inicializaComponentes(){
        findViewById<Button>(R.id.btnAdicionar).setOnClickListener(this)
        findViewById<Button>(R.id.btnCancelar).setOnClickListener(this)

    }

    private fun observe(){
        mViewModel.insertTarefa.observe(this, Observer {
            if (it){
                Toasty.success(this, "Sucesso", Toasty.LENGTH_LONG).show()
            }else{
                Toasty.error(this, "Sucesso", Toasty.LENGTH_LONG).show()
            }
        })
    }

}