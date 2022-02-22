package com.example.save_money.screen.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.save_money.model.Goals
import com.example.save_money.data.repository.Repository
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