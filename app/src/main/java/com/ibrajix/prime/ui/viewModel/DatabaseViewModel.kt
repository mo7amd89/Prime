package com.ibrajix.prime.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrajix.prime.room.Case
import com.ibrajix.prime.ui.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DatabaseViewModel @Inject constructor(private val databaseRepository: DatabaseRepository) : ViewModel() {

    private val _getAllCases = MutableSharedFlow<List<Case>>()
    val getAllCases : SharedFlow<List<Case>> = _getAllCases


    fun createCases(){
        viewModelScope.launch {
           databaseRepository.insertCases()
        }
    }


    fun getAllListCases(){
        viewModelScope.launch {
            databaseRepository.getAllCases
                .catch {e->
                    //log error
                }
                .collect {
                    _getAllCases.emit(it)
                }
        }
    }

}