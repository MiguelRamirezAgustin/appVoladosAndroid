package com.app.volados

import android.content.Context
import android.content.SharedPreferences
import com.airbnb.lottie.model.content.ShapeTrimPath

class SharedPreference (val contex :Context) {
   val PREFERENCE_NAME = "volados_app"
   private val sharedFre :SharedPreferences = contex.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)


    fun saveString (KEY_NAME:String, values:String){
      val editor : SharedPreferences.Editor = sharedFre.edit()
          editor.putString(KEY_NAME,values)
          editor.commit()
    }

    fun getValueString(KEY_NAME: String?): String? {
        return sharedFre.getString(KEY_NAME, "")
    }

}