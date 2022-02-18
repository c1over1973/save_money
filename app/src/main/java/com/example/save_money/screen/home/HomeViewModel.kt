package com.example.save_money.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.save_money.data.Detail
import com.example.save_money.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val readAllGoals = repository.readAllGoals

    fun deleteAllGoals() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllGoals()
        }
    }

    fun addDetail(detail: Detail){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDetail(detail)
        }
    }

    fun deleteAllDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllDetails()
        }
    }

    fun updateSum(goal: String, sum: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSum(goal, sum)
        }
    }

}