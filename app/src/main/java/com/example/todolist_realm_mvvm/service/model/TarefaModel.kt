package com.example.todolist_realm_mvvm.service.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TarefaModel(
    @PrimaryKey
     var id: Long = 0,
     var atividade: String = ""
): RealmObject() {
}