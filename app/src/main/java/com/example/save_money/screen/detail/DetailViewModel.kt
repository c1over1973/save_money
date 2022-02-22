package com.example.save_money.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.save_money.data.repository.Repository
import com.example.save_money.model.Detail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    val readAllDetail = repository.readAllDetail
    val readAllGoals = repository.readAllGoals

    fun UpdateDetail(id: Int, amount: Int, content: String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDetail(id, amount, content)
        }
    }

    fun DeleteDetail(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDetail(id)
        }
    }

    fun UpdateSum(goal: String, sum: Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSum(goal, sum)
        }
    }
}