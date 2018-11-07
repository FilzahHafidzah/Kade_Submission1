package com.filzah.kade_submission1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.text.FieldPosition

class AdapterFootball (private val context : Context, private val items : List<Item>,
                       private val listener : (Item) -> Unit) : RecyclerView.Adapter<ViewHolder> (){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    //kurung kurawal dihapus krn dia sesama class jadinya pake () yang mendeklarasiakan dalam itutuh ada layout inflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent,false))


    override fun getItemCount(): Int {
       return items.size
    }

//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        //knp merah? krn bind item ini dari view holder dia sebagai variable
//        holder.bindItem(items[position], listener)
//    }

    //kalo nggak muncul implement members, klik kanan implement method
}