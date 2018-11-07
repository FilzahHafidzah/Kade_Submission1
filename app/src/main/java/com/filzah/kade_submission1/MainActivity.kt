package com.filzah.kade_submission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.filzah.kade_submission1.R.array.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call rv id use android extentions
        rv_football_club.layoutManager = LinearLayoutManager(this)
        rv_football_club.adapter = AdapterFootball(this, items){itemClicked(it)}

        //call func
        dataRv()
    }

    //when it's clicked intent by bringing datas from Item
    private fun itemClicked(items : Item) {
        startActivity<DetailFootball>(DetailFootball.TITLE to items.name, DetailFootball.IMAGE to items.image, DetailFootball.DESCRIPTION to items.description)
    }

    private fun dataRv(){
        //call array
        val name = resources.getStringArray(football_name)
        val pic = resources.obtainTypedArray(football_pic)
        val desc = resources.getStringArray(football_desc)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                           pic.getResourceId(i, 0),
                           desc[i]))
        }

        //Recycle the typed array
        pic.recycle()
    }
}
