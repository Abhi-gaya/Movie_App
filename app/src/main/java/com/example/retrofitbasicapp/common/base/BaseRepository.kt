package com.example.retrofitbasicapp.common.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {//this repo will be used in
                                // all the other child repo of the app and all functions of this
                                //repo will be used in those child repos!!
    suspend fun <T> safeapi(
        apicall :suspend() -> Response<T>
    ) = flow<ApiState<T>>{
        emit(ApiState.Loading)
        val response = apicall()
        if (response.isSuccessful){
            val data = response.body()
            if(data!=null){
                emit(ApiState.Success(data))
            }else{// if data is null
                val error = response.errorBody()
                if(error!=null){
                    emit(ApiState.Failure(IOException(error.toString())))
                }else//if error is also null
                    emit(ApiState.Failure(IOException("Something went wrong...")))
            }
        }else{ //if response is not successfull
            emit(ApiState.Failure(Throwable(response.errorBody().toString())))
        }
    }.catch { e->
        e.printStackTrace()
        emit(ApiState.Failure(Exception(e)))
    }.flowOn(Dispatchers.IO)
}