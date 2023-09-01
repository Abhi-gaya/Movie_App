package com.example.retrofitbasicapp.features.domain.repository

import com.example.retrofitbasicapp.Model.data.Movies
import com.example.retrofitbasicapp.common.base.ApiState
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<ApiState<Movies>>

}