package com.example.myuielementsapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView


/**
 * Created by tutlane on 24-08-2017.
 */
class ImageAdapter(private val mContext: Context) : BaseAdapter() {
    override fun getCount(): Int {
        return thumbImages.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView = ImageView(mContext)
        imageView.layoutParams = AbsListView.LayoutParams(200, 200)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setPadding(8, 8, 8, 8)
        imageView.setImageResource(thumbImages[position])
        return imageView
    }

    // Add all our images to arraylist
    var thumbImages = arrayOf<Int>(
        R.drawable.bob,
        R.drawable.cent,
        R.drawable.pac
    )

}