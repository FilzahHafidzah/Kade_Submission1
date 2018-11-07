package com.filzah.kade_submission1

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

//ini fungsinya dipisah biar dia bisa dipanggil sama adapter lain yang membutuhkan dia, dan kao kayak gini jadi lebih rapih
class ViewHolder (val view : View) : RecyclerView.ViewHolder(view){

    //bindItem ngambil data dari Item dan diset ke yang ada di item_list
    fun bindItem(item: Item, listener : (Item) -> Unit){
        itemView.item_nama.text = item.name
        Glide.with(itemView.context).load(item.image).into(itemView.item_image)

        //when it's clicked
        itemView.setOnClickListener {
            listener(item)
        }
    }

}