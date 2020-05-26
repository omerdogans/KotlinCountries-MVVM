package com.example.kotlincountries.service

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincountries.model.Country


@Dao
interface CountryDao {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries: Country) : List<Long>

    //Insert -> INSERT INTO
    //suspend -> coroutine, pause & resume
    //vararg -> multiple country objeects
    // List<Long> -> primary keys


    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId: Int) : Country


    @Query ("DELETE FROM country")
    suspend fun deleteAllCountries()

}