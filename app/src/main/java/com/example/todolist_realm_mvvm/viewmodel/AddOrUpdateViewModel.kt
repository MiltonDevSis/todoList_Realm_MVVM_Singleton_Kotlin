package com.example.todolist_realm_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolist_realm_mvvm.service.repository.TarefaRepository

class AddOrUpdateViewModel(application: Application) : AndroidViewModel(application) {

    private val mcontext = application.applicationContext
    private val mTarefaRepository: TarefaRepository = TarefaRepository.getInstance(mcontext)

    private var mInsertTarefa = MutableLiveData<Boolean>()
    val insertTarefa: LiveData<Boolean> = mInsertTarefa

    fun save(tarefa: String) {
        mTarefaRepository.save(tarefa, getApplication())
    }
}