package com.example.firebasekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var btnInsertData:Button
    private lateinit var btnFetchData:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()
        btnInsertData = findViewById(R.id.btn_insert)
        btnFetchData = findViewById(R.id.btn_fetch)

        btnInsertData.setOnClickListener(View.OnClickListener {
            val insertactivity = Intent(this, InsertionActivity :: class.java)
            startActivity(insertactivity)
        })

        btnFetchData.setOnClickListener(View.OnClickListener {
            val fetchingactivity = Intent(this, RetrieveActivity :: class.java)
            startActivity(fetchingactivity)
        })
    }
}