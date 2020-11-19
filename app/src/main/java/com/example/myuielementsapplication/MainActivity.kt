package com.example.myuielementsapplication

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songArray =  arrayOf(
            "2pac - Dream mama",
            "2pac - only God Can judge me",
            "2Pac - Thugs Get Lonely Too",
            "Bob marley - a la la la la long",
            "Bob Marley - Bend Down Low",
            "Bob marley - Rastaman live up!",
            "50 Cent - So Serious",
            "50 cent- G Unit - Stunt 101",
            "50CENT Outta Control Remix Feat Mobb Deep"
        )
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songArray)
        val songListView = findViewById<ListView>(R.id.songListView)
        songListView.adapter = adapter
        registerForContextMenu(songListView)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.go_to_album -> {
                val albumsIntent = Intent(this, AlbumsActivity::class.java)
                startActivity(albumsIntent)
                true
            }
            R.id.go_to_queue -> {
                val qIntent = Intent(this, QueueActivity::class.java)
               // qIntent.putExtra("dataToPass", onContextItemSelected(item))
                startActivity(qIntent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.queue_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.go_to_queue -> {
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()

                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}