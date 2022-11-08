package com.example.parcial3kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.parcial3kotlin.models.Animals


class FragmentAnimals(
    var animal:Animals
) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf {it.containsKey(ARG_OBJECT).apply {
            //llamamos a los elementos de cada item del view pager
            val imgId:ImageView = view.findViewById(R.id.item_animal_id_img)
            val name:TextView = view.findViewById(R.id.item_animal_name)
            val specie:TextView = view.findViewById(R.id.item_animal_specie)
            val sex:TextView = view.findViewById(R.id.item_animal_sex)
            val habitad:TextView = view.findViewById(R.id.item_animal_habitad)

            //agregamos los datos segun el la posicion del arreglo
            imgId.setImageResource(animal.img_id)
            name.text = "Nombre: "+animal.name
            specie.text = "Especie: "+animal.specie
            sex.text = "Sexo: "+animal.sex
            habitad.text ="Hábitad: "+ animal.habitad
        } }
    }


    companion object{
        private const val ARG_OBJECT = "object";
    }
}