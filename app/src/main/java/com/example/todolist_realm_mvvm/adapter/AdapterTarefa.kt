package com.example.todolist_realm_mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_realm_mvvm.R
import com.example.todolist_realm_mvvm.service.model.TarefaModel
import kotlinx.android.synthetic.main.fragment_first.view.*

class AdapterTarefa : RecyclerView.Adapter<AdapterTarefa.TarefaViewHolder>() {

    var mGuestList: List<TarefaModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_first, parent, false)
        return TarefaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mGuestList.size
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {


    }

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: Int? = 0
        var atividade: String? = ""
    }

        fun listar(lista: List<TarefaModel>) {
            mGuestList = lista

    }
}