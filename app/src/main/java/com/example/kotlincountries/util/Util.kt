package com.example.kotlincountries.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlincountries.R

//Extension
/*fun String.myExtension(myParamater : String){
    println(myParamater)
}*/

 // İmageView extension
fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

//ProgressBAr
fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}
     // xml'de çalıştırmak için
   @BindingAdapter("android:downloadUrl")

    fun downloadImage(view: ImageView, url: String?) {
        view.downloadFromUrl(url, placeholderProgressBar(view.context))
    }

