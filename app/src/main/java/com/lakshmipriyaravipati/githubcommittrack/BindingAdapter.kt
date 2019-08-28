package com.lakshmipriyaravipati.githubcommittrack

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide



object BindingAdapter {

    @BindingAdapter("layoutManager")
    @JvmStatic
    fun setLayoutManager(view: RecyclerView, orientation: Int) {
        view.layoutManager = LinearLayoutManager(view.context, orientation, false)
    }

    @BindingAdapter("bindImageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        if (url != null) {
            Glide.with(view.getContext()).load(url).into(view)
        }
    }
}