package com.example.todolist_realm_mvvm.service.repository

import android.content.Context
import android.database.Cursor
import com.example.todolist_realm_mvvm.realm.RealmManager
import com.example.todolist_realm_mvvm.service.model.TarefaModel
import es.dmoral.toasty.Toasty

class TarefaRepository private constructor(context: Context) {

    //singleton
    companion object{
        private lateinit var repository: TarefaRepository

        fun getInstance(context: Context): TarefaRepository {
            if (!Companion::repository.isInitialized){
                repository = TarefaRepository(context)
            }
            return repository
        }
    }

    val realm: RealmManager = RealmManager()

    fun save(tarefa: String, context: Context) {
        realm.insert(tarefa)
        Toasty.success(context, "Sucesso", Toasty.LENGTH_LONG).show()
        realm.findAll()
    }

    fun list(): List<TarefaModel>{
        var list: MutableList<TarefaModel> = ArrayList()
        list = realm.findAll() as MutableList<TarefaModel>
        return list
    }
}