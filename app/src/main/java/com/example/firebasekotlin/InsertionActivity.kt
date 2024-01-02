package com.example.firebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.System.err

class InsertionActivity : AppCompatActivity() {
    private lateinit var etEmpname:EditText
    private lateinit var etEmpage:EditText
    private lateinit var etEmpsalary:EditText
    private lateinit var btnSave:Button

    private lateinit var dbref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

        etEmpname = findViewById(R.id.edt_name)
        etEmpage = findViewById(R.id.edt_age)
        etEmpsalary = findViewById(R.id.edt_salary)
        btnSave = findViewById(R.id.btn_save)
        dbref = FirebaseDatabase.getInstance().getReference("Employee")
        btnSave.setOnClickListener(View.OnClickListener {
            saveEmployeeData()
        })
    }

    private fun saveEmployeeData() {
        val empname = etEmpname.text.toString()
        val empage = etEmpage.text.toString()
        val empsalary = etEmpsalary.text.toString()

        if (empname.isEmpty()){
            etEmpname.error = "Please enter name"
        }
        if (empage.isEmpty()){
            etEmpage.error = "Please enter age"
        }
        if (empsalary.isEmpty()){
            etEmpsalary.error = "Please enter salary"
        }
        val empid = dbref.push().key!!
        val employee = EmployeeModel(empid, empname, empage, empsalary)
        dbref.child(empid).setValue(employee).addOnCanceledListener {
            Toast.makeText(this,"Data inserted successfully",Toast.LENGTH_LONG).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Error ${it.message}",Toast.LENGTH_LONG).show()
        }
    }
}