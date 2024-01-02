package com.example.firebasekotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class RetrieveActivity : AppCompatActivity() {
    private lateinit var dbref:DatabaseReference
    var employeelist =  ArrayList<EmployeeModel> ()
    var customAdapter : CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve)
        val recyclerView = findViewById<RecyclerView>(R.id.rcvw)
        recyclerView.layoutManager = LinearLayoutManager(this)


        dbref = FirebaseDatabase.getInstance().getReference("Employee")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               employeelist.clear()

                for (postSnapshot in snapshot.children) {
                    var empmodel : EmployeeModel = postSnapshot.getValue(EmployeeModel::class.java)!!
                     employeelist.add(empmodel)
                    // here you can access to name property like university.name
                }
                customAdapter = CustomAdapter(employeelist)
                recyclerView.adapter = customAdapter
                Toast.makeText(this@RetrieveActivity,employeelist.size.toString(),Toast.LENGTH_LONG).show()


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}