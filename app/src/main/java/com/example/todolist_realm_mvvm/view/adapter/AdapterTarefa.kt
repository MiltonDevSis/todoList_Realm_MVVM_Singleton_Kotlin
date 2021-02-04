package com.example.todolist_realm_mvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_realm_mvvm.R
import com.example.todolist_realm_mvvm.service.model.TarefaModel
import com.example.todolist_realm_mvvm.view.viewholder.TarefaViewHolder

class AdapterTarefa : RecyclerView.Adapter<TarefaViewHolder>() {

    private var mListaTarefa: List<TarefaModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_first, parent, false)
        return TarefaViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mListaTarefa.count()
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        holder.bind(mListaTarefa[position])
    }

    fun listar(lista: List<TarefaModel>) {
        mListaTarefa = lista
        notifyDataSetChanged()
    }
}