package com.kralofsky.cipherbox.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kralofsky.cipherbox.R

class AddActivity : AppCompatActivity() {
    private val itemList : MutableList<ListItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lab1addactivitylayout)

        val titleField = findViewById<EditText>(R.id.lab1addActivity_title)!!
        val descriptionField = findViewById<EditText>(R.id.lab1addActivity_description)!!

        findViewById<Button>(R.id.lab1addActivity_button).setOnClickListener {
            val element = ListItem(
                titleField.text.toString(),
                R.mipmap.ic_launcher,
                descriptionField.text.toString()
            )

            titleField.text.clear()
            descriptionField.text.clear()

            itemList.add(element)
        }

        findViewById<Button>(R.id.lab1AddActivity_show_list_button).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("list", itemList.toTypedArray())
            startActivity(intent)
        }
    }
}