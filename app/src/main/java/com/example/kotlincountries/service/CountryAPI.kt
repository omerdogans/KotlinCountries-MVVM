package com.example.kotlincountries.service

import com.example.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //GET,POST

    //https://raw.githubusercontent.com/omerdogans/DataSetCountries/master/countrydataset.json
    //BASE_URL -> https://raw.githubusercontent.com
    //EXT -> omerdogans/DataSetCountries/master/countrydataset.json

    @GET("omerdogans/DataSetCountries/master/countrydataset.json")

    fun getCountries():Single<List<Country>>


}