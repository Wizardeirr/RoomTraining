package com.volkankelleci.sharephotosbasicly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    auth= Firebase.auth
    }
    fun log(view: View){
        val email=editText.text.toString()
        val sifre=passwordText.text.toString()
        auth.createUserWithEmailAndPassword(email,sifre).addOnCompleteListener { task->

            if (task.isSuccessful){

                val intent= Intent(this,RecyclerActivitiy::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception->
            Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG)
        }
    }
}