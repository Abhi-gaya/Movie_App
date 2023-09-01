package com.example.retrofitbasicapp.di

import com.example.retrofitbasicapp.Model.repository.MovieRepositoryImpl
import com.example.retrofitbasicapp.features.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesMovieRepository(
        repo:MovieRepositoryImpl
    ):MovieRepository
}