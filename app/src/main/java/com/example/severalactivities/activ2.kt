package com.example.severalactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.severalactivities.databinding.ActivityActiv2Binding

class activ2 : AppCompatActivity() {
    private lateinit var binding: ActivityActiv2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityActiv2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //получаем список аргументов, присланных из первого активити
        //и если эти аргументы не null, то обрабатываем
        val arguments = intent.extras
        var name: String = "default"
        if(arguments!=null) {
            //метод get позволяет получить значение по ключу
            name = arguments.get("name").toString()
        }
        binding.textView2.text = binding.textView2.text.toString()+", "+name

        val btn_toact1 = binding.buttonToact1
        btn_toact1.setOnClickListener{
            val act1_start = Intent(this, MainActivity::class.java)
            startActivity(act1_start)
        }
    }
}