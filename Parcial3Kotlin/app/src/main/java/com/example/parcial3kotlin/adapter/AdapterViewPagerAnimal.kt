package com.example.parcial3kotlin.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.parcial3kotlin.FragmentAnimals
import com.example.parcial3kotlin.models.Animals

class AdapterViewPagerAnimal(fragment:FragmentActivity,
                             var animalData:ArrayList<Animals>)
    :FragmentStateAdapter(fragment) {

    companion object{
        private const val ARG_OBJECT = "object";
    }

    override fun getItemCount(): Int = 3

    /**
     * Provide a new Fragment associated with the specified position.
     *
     *
     * The adapter will be responsible for the Fragment lifecycle:
     *
     *  * The Fragment will be used to display an item.
     *  * The Fragment will be destroyed when it gets too far from the viewport, and its state
     * will be saved. When the item is close to the viewport again, a new Fragment will be
     * requested, and a previously saved state will be used to initialize it.
     *
     * @see ViewPager2.setOffscreenPageLimit
     */
    override fun createFragment(position: Int): Fragment {
        val fragment = FragmentAnimals(animalData[position])
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}