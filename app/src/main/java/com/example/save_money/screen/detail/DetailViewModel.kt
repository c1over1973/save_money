package com.example.save_money.screen.detail

import androidx.lifecycle.ViewModel
import com.example.save_money.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    repository: Repository
): ViewModel() {
    val readAllDetail = repository.readAllDetail
}