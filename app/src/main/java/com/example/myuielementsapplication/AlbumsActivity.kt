package com.example.myuielementsapplication

//import android.support.v7.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class AlbumsActivity : AppCompatActivity() {


    var mTitle = arrayOf("BoB-Marley-Album", "50CENT-Album", "2PAC-Album",)
    var thumbImages = arrayOf<Int>(
        R.drawable.bob,
        R.drawable.cent,
        R.drawable.pac
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)
        val albumGv = findViewById<GridView>(R.id.albumGv)
        albumGv.adapter = ImageAdapter(this)


        albumGv.onItemClickListener =
            OnItemClickListener { parent, v, position, id ->


                val i = Intent(applicationContext, FullImageActivity::class.java)
                // passing array index
                // passing array index
                i.putExtra("id", position)
                startActivity(i)




                }
            }
    class  ImageAdapter(private val mContext: Context) : BaseAdapter() {
        override fun getCount(): Int {
            return thumbImages.size
        }

        override fun getItem(position: Int): Any {
            return  thumbImages[position]
        }

        override fun getItemId(position: Int): Long {
          return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
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
}
