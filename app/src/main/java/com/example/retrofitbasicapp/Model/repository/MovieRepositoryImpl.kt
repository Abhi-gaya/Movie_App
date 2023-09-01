package com.example.retrofitbasicapp.Model.repository

import com.example.retrofitbasicapp.Model.data.Movies
import com.example.retrofitbasicapp.Model.network.ApiService
import com.example.retrofitbasicapp.common.base.ApiState
import com.example.retrofitbasicapp.common.base.BaseRepository
import com.example.retrofitbasicapp.features.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): MovieRepository, BaseRepository() {

    override suspend fun getMovies(): Flow<ApiState<Movies>> =safeapi {
        apiService.getMovies()
    }
}