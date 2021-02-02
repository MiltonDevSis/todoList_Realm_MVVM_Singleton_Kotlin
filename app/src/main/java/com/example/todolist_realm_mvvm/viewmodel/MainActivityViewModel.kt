package com.example.todolist_realm_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolist_realm_mvvm.service.model.TarefaModel
import com.example.todolist_realm_mvvm.service.repository.TarefaRepository

class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    private val mcontext = application.applicationContext
    private val mTarefaRepository: TarefaRepository = TarefaRepository.getInstance(mcontext)

    private val mListaTarefa = MutableLiveData<List<TarefaModel>>()
    var listaTarefa: LiveData<List<TarefaModel>> = mListaTarefa

    fun list(){
        mListaTarefa.value = mTarefaRepository.list()
    }
}