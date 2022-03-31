package com.example.severalactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.severalactivities.databinding.ActivityActiv2Binding
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.graphics.drawable.AnimationDrawable;
// import android.os.CountDownTimer
// import kotlin.concurrent.timer


class activ2 : AppCompatActivity() {
    private lateinit var binding: ActivityActiv2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityActiv2Binding.inflate(layoutInflater)
        val view = binding.root
        var names: Array<String> = arrayOf("Люси","Кевин","Юля","Гармоникс","Yarik Slave","Максимка")
        setContentView(view)
        //получаем список аргументов, присланных из первого активити
        //и если эти аргументы не null, то обрабатываем
        val arguments = intent.extras
        var name: String = names.random()
        var age: Int = 1

        var hunger: Int = (200..300).random()
        var maxhunger: Int = 500
        var minhunger: Int = 150

        if(arguments!=null) {
            //метод get позволяет получить значение по ключу
            name = arguments.get("name").toString()
            age = arguments.get("age").toString()

            if(name.toString()==""){
                name=names.random();
            }

            if(age.toString()==""){
                age="1"
            }

            age.toString().toInt()
        }

        binding.textView2.text = binding.textView2.text.toString()+" "+name
        binding.textView6.text=binding.textView6.text.toString()+"Возраст "+age+" лет"

        // Анимация 
        var image: ImageView = binding.me
        image.setBackgroundResource(R.drawable.blink)
        var animation: AnimationDrawable = image.getBackground() as AnimationDrawable
        animation.start()
        //




        


        val btn_toact1 = binding.buttonToact1
        btn_toact1.setOnClickListener{
            val act1_start = Intent(this, MainActivity::class.java)
            startActivity(act1_start)
        }

        val btn_feed = binding.buttonFeed
        btn_feed.setOnClickListener{
            binding.textView5.text=""
            binding.textView5.text=binding.textView5.text.toString()+"Вы покормили "+name
            if(hunger>maxhunger){
                binding.textView5.text=binding.textView5.text.toString()+"\n"+"Он наелся"
                
            }else{
                binding.textView5.text=binding.textView5.text.toString()+"\n"+"Он покушал"
                hunger+=20
            }
        }

        val btn_go=binding.buttonGo
        btn_go.setOnClickListener {
            binding.textView5.text=""
            binding.textView5.text=binding.textView5.text.toString()+"Вы погуляли с "+name
            if(hunger<minhunger){
                binding.textView5.text=binding.textView5.text.toString()+"\n"+"Он голоден"
                
            }else{
                binding.textView5.text=binding.textView5.text.toString()+"\n"+"Освежился"
                hunger-=50
            }
        }



    }


}
