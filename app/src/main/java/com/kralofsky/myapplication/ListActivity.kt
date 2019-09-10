package com.kralofsky.myapplication

import android.os.Bundle
import android.os.Parcelable
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listactivitylayout)

        val rawItems = intent.extras?.getParcelableArray("list") ?: arrayOf<Parcelable>()
        val items: MutableList<ListItem> = ArrayList()

        for (i in rawItems)
            if (i is ListItem)
                items.add(i)

        findViewById<ListView>(R.id.listView).adapter = ListAdapter(this, items)
    }
}