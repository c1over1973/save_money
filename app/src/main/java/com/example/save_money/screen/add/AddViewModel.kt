package com.example.save_money.screen.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.save_money.data.Detail
import com.example.save_money.data.Goals
import com.example.save_money.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    fun addGoals(goals: Goals){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGoals(goals)
        }
    }
}