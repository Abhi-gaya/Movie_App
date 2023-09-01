package com.example.retrofitbasicapp.features.domain.usecase

import com.example.retrofitbasicapp.Model.data.Movies
import com.example.retrofitbasicapp.common.base.ApiState
import com.example.retrofitbasicapp.common.base.map
import com.example.retrofitbasicapp.features.domain.mapper.MovieMapper
import com.example.retrofitbasicapp.features.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val repo:MovieRepository,
    private val mapper:MovieMapper
) {
    suspend fun getMovies() : Flow<ApiState<List<Movies.detail>?>> {
        return repo.getMovies().map { detail->
            detail.map {
                mapper.fromMap(it)
            }
        }
    }

}