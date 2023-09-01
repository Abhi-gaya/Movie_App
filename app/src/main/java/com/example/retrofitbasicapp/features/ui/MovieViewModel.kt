package com.example.retrofitbasicapp.features.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitbasicapp.Model.data.Movies
import com.example.retrofitbasicapp.common.base.doOnFailure
import com.example.retrofitbasicapp.common.base.doOnLoading
import com.example.retrofitbasicapp.common.base.doOnSuccess
import com.example.retrofitbasicapp.features.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val useCase: MovieUseCase
) :ViewModel(){
    private val _res: MutableState<MovieState> = mutableStateOf(MovieState())
    val res: State<MovieState> = _res

    init {
        viewModelScope.launch {
            useCase.getMovies()
                .doOnSuccess {
                    _res.value = MovieState(
                        data = it!!
                    )
                }
                .doOnFailure {
                    _res.value = MovieState(
                        error = it?.message!!
                    )
                }
                .doOnLoading {
                    _res.value = MovieState(
                        isLoading = true
                    )
                }
        }
    }
}

data class MovieState(
    val data :List<Movies.detail> = emptyList(),
    val error :String ="",
    val isLoading: Boolean = false
)