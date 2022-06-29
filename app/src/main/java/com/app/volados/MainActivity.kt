package com.app.volados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.circularreveal.cardview.CircularRevealCardView
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var listCurrency = ArrayList<ModelCurrency>()
        listCurrency.add(ModelCurrency(R.drawable.imagen1,"1 Peso", 1))
        listCurrency.add(ModelCurrency(R.drawable.imagen2,"2 Pesos", 2))
        listCurrency.add(ModelCurrency(R.drawable.imagen5,"5 Pesos", 5 ))
        listCurrency.add(ModelCurrency(R.drawable.imagen10,"10 Pesos", 10 ))


        println("List objet-->"+ listCurrency)
        val adapter = AdapterCurrency(this, listCurrency)
        val carouselRecyclerview = findViewById<CarouselRecyclerview>(R.id.recycler_view_currency)
        carouselRecyclerview.adapter = adapter
        carouselRecyclerview.set3DItem(true)
        carouselRecyclerview.setInfinite(true)
        carouselRecyclerview.setIsScrollingEnabled(true)

    }



}