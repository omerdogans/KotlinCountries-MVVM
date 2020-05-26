package com.example.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountries.R
import com.example.kotlincountries.databinding.ItemCountryBinding
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.util.downloadFromUrl
import com.example.kotlincountries.util.placeholderProgressBar
import com.example.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener{



    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    //item_country ile adapteri birbirine bağlamak için
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
       // val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    //kaç tane row oluşturacağını söylüyor
    override fun getItemCount(): Int {
        return countryList.size
    }

    // item_contry içindeki elemanlara ulaşmak için
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {


        holder.view.country = countryList[position] // tek satırla Databinding kullanarak country daki elemanlara ulaştık

        holder.view.listener = this

      /*  holder.view.name.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion


        holder.view.setOnClickListener{
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadFromUrl(countryList[position].flag, placeholderProgressBar(holder.view.context))


       */
    }
    //SwipeRefresh yapmak için
    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidtext.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        //action.countryUuid
        Navigation.findNavController(v).navigate(action)

    }

}