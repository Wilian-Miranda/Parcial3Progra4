package com.example.parcial3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.parcial3kotlin.adapter.AdapterViewPagerAnimal
import com.example.parcial3kotlin.models.Animals

class MainActivity : AppCompatActivity() {
    private lateinit var vpViewPager: ViewPager2

    private var animalData = ArrayList<Animals>()

    //creamos el adaptador que se inicie solamente cuando se necesite
    private val adapterViewPager by lazy{
//clase que tiene el adaptador
        //con dis le decimos que se ejecutará aqui (un fragment activity)
        AdapterViewPagerAnimal(this,animalData);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vpViewPager = findViewById(R.id.main_vp_animals)

        //agregamos los datos al array "animalData" que funcionara como la base de datos
        animalData.add(Animals(R.drawable.ciervo,"Ciervo","Mamífero","Macho","Bosques cálidos"))
        animalData.add(Animals(R.drawable.lobo,"Lobo","Mamífero","Macho","Bosques"))
        animalData.add(Animals(R.drawable.llama,"Llama","Mamífero","Macho","LLanuras"))


        vpViewPager.adapter = adapterViewPager

    }
}