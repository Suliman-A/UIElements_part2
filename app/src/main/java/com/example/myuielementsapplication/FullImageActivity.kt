package com.example.myuielementsapplication

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageView


/**
 * Created by tutlane on 24-08-2017.
 */
class FullImageActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        //val titleTv = findViewById<TextView>(R.id.titleTv)
        val imageView = findViewById<ImageView>(R.id.imageView)

        // Get intent data
        val i = intent
        // Get Selected Image Id
        val position = i.extras!!.getInt("id")
        val imageAdapter = ImageAdapter(this)
        //val imageView = findViewById<View>(R.id.imageView) as ImageView
        imageView.setImageResource(imageAdapter.thumbImages[position])
    }
}



