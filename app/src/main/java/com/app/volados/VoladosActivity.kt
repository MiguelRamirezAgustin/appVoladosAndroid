package com.app.volados

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_volados.*
import java.util.*
import kotlin.concurrent.schedule

class VoladosActivity : AppCompatActivity() {

    private var typeProcess : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volados)
        supportActionBar?.hide()

        typeProcess = intent.getBooleanExtra("process", typeProcess)

        if(typeProcess){

        }else{

        }
        println("Type process---->"+ typeProcess)

        btn_volados.setOnClickListener {
            println("Volado")
            text_view_title.visibility = View.GONE
            btn_volados.visibility = View.GONE
            show_result.visibility = View.GONE
            show_volados.visibility = View.VISIBLE

            Handler().postDelayed({
                val rnds = (1..100).random()
                if(validateNumber(rnds)){
                    showImage()
                }else{
                    showImage()
                }
            }, 4000)


        }

    }

    fun validateNumber(n:Number):Boolean{
        var number : Boolean
        number = ( n.toInt() % 2 ) == 0
        return  number
    }


    fun  showImage(){
        show_result.visibility = View.VISIBLE
        show_volados.visibility = View.GONE
    }

}