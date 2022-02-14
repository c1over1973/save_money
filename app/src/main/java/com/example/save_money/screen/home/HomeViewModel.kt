package com.example.save_money.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.save_money.data.Detail
import com.example.save_money.data.Goals
import com.example.save_money.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
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

    fun deleteAllDetail() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.readAllDetail
        }
    }

    fun addDetail(detail: Detail) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDetail(detail)
        }
    }

    fun updateGoals(goals: Goals) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateGoals(goals)
        }
    }

    fun updateSum(goal: String, sum: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSum(goal, sum)
        }
    }

//    fun addGoals(){
//        val goals = Goals("a", 1000)
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addGoals(goals)
//        }
//    }
}