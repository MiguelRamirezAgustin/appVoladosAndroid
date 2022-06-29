package com.app.volados

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.itemcurrency.view.*

class AdapterCurrency(val context: Context,private var listCurrency:List<ModelCurrency>):RecyclerView.Adapter<AdapterCurrency.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.itemcurrency,parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currency = listCurrency[position]
        Glide.with(holder.img).load(currency.id).into(holder.img);
        holder.nombre.text = currency.name

        holder.img.setOnClickListener{
            val  intent  = Intent(context,VoladosActivity::class.java)
            intent.putExtra("processImg", currency.idObject)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listCurrency.size


    class ViewHolder ( bindingView : View):RecyclerView.ViewHolder(bindingView){
        val img = bindingView.img_currency
        val nombre = bindingView.text_viewTitle
    }
}