package com.example.todolist_realm_mvvm.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_realm_mvvm.R
import com.example.todolist_realm_mvvm.service.model.TarefaModel

class TarefaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(lista: TarefaModel){
        val txtId = itemView.findViewById<TextView>(R.id.txtId)
        val txtAtividade = itemView.findViewById<TextView>(R.id.txtAtividade)

        txtId.text = lista.id.toString()
        txtAtividade.text = lista.atividade
    }
}