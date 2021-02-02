package com.example.todolist_realm_mvvm.realm

import com.example.todolist_realm_mvvm.service.model.TarefaModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RealmManager {

    val realm: Realm = Realm.getDefaultInstance()

    fun find(id: Long): TarefaModel? {
        return realm.where(TarefaModel::class.java).equalTo("id", id).findFirst()
    }

    fun findAll() : List<TarefaModel>{
        //return realm.where(TarefaModel::class.java).findAll()
        val resultado: RealmResults<TarefaModel> = realm.where(
            TarefaModel::class.java).findAll()
        println(resultado)
        return resultado
    }

    fun insert(novaAtividade: String) {
        realm.beginTransaction()
        var newId: Long = 1
        // insert id auto
        if (realm.where(TarefaModel::class.java).max("id") != null) {
            newId = realm.where(TarefaModel::class.java).max("id") as Long + 1
        }
        val atividade = realm.createObject(TarefaModel::class.java, newId)
        atividade.atividade = novaAtividade
        realm.commitTransaction()
    }

    fun update(id: Long, atividade: String) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val note = find(id)
        note?.atividade = atividade
        realm.commitTransaction()
    }

    fun deleteById(id: Long) {
        realm.beginTransaction()
        val results = realm.where(TarefaModel::class.java).equalTo("id", id).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }

    fun deleteAll(){
        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()
    }
    
}