package com.example.retrofitbasicapp.features.domain.mapper

import com.example.retrofitbasicapp.Model.data.Movies
import com.example.retrofitbasicapp.common.base.Mapper
import javax.inject.Inject


class MovieMapper @Inject constructor() :Mapper<Movies?,List<Movies.detail>>{

    override fun fromMap(from: Movies?): List<Movies.detail>? {
        return from?.Movie?.map {
            Movies.detail(
                id = it.id,
                original_title = it.original_title,
                overview = it.overview,
                poster_path = it.poster_path,
                vote_average = it.vote_average
            )
        }
    }

}