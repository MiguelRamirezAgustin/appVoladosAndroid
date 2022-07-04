package com.app.volados

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_volados.*


class VoladosActivity : AppCompatActivity() {

    private var processImg : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volados)
        supportActionBar?.hide()
        processImg = intent.getIntExtra("processImg", processImg)


        showmoney(processImg)

        btn_volados.setOnClickListener {
            text_view_title.visibility = View.GONE
            btn_volados.visibility = View.GONE
            show_result.visibility = View.GONE
            show_volados.visibility = View.VISIBLE

            Handler().postDelayed({
                val rnds = (1..500).random()
                if(validateNumber(rnds)){
                    text_view_result.setText("Sol")
                    showImage()
                    showImagenResultSun(processImg)
                }else{
                    text_view_result.setText("Aguila")
                    showImage()
                    showImagenResultEagle(processImg)
                }
            }, 5000)
        }

        btn_new_flown.setOnClickListener {
            show_result.visibility = View.GONE
            text_view_title.visibility = View.VISIBLE
            btn_volados.visibility = View.VISIBLE
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

    fun showmoney(processImg:Int){
        when (processImg) {
            1 -> {
                img_sol.setImageResource(R.drawable.imagen1)
                img_aguila.setImageResource(R.drawable.img1)
            }
            2 -> {
                img_sol.setImageResource(R.drawable.imagen2)
                img_aguila.setImageResource(R.drawable.img2)
            }
            5 -> {
                img_sol.setImageResource(R.drawable.imagen5)
                img_aguila.setImageResource(R.drawable.img5)
            }
            10 -> {
                img_sol.setImageResource(R.drawable.imagen10)
                img_aguila.setImageResource(R.drawable.img10)
            }
            else -> {}
        }
    }

    fun showImagenResultSun(processImg:Int) {
        when (processImg) {
            1 -> {
                img_show_result.setImageResource(R.drawable.imagen1)
                animateImage()
            }
            2 -> {
                img_show_result.setImageResource(R.drawable.imagen2)
                animateImage()
            }
            5 -> {
                img_show_result.setImageResource(R.drawable.imagen5)
                animateImage()
            }
            10 -> {
                img_show_result.setImageResource(R.drawable.imagen10)
                animateImage()
            }
            else -> {}
        }
    }

    fun showImagenResultEagle(processImg:Int) {
        when (processImg) {
            1 -> {
                img_show_result.setImageResource(R.drawable.img1)
                animateImage()
            }
            2 -> {
                img_show_result.setImageResource(R.drawable.img2)
                animateImage()
            }
            5 -> {
                img_show_result.setImageResource(R.drawable.img5)
                animateImage()
            }
            10 -> {
                img_show_result.setImageResource(R.drawable.img10)
                animateImage()
            }
            else -> {}
        }
    }


    fun animateImage(){
        img_show_result.animate().apply {
            duration = 1000
            alpha(1F)
            scaleXBy(.5F)
            scaleYBy(.5F)
            rotationXBy(360F)
            translationYBy(200F)
        }.withEndAction {
            img_show_result.animate().apply {
                duration = 1000
                alpha(1F)
                scaleXBy(-.5F)
                scaleYBy(-.5F)
                rotationXBy(360F)
                translationYBy(-200F)
            }
        }.start()
    }

}