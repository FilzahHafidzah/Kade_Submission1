package com.filzah.kade_submission1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailFootball : AppCompatActivity() {

    //give the sub variable
    companion object {
        const val DESCRIPTION = "description"
        const val TITLE = "title"
        const val IMAGE = "image"
    }

    //give the receiver variable
    private var title: String = ""
    private var image: Int = 0
    private var description: String = ""

    //give variable for each view
    lateinit var titleTV: TextView
    lateinit var imageIV: ImageView
    lateinit var descriptionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //pakek anko layouts :v
        verticalLayout {
            padding = (16)

            //imagenya
            imageIV = imageView().lparams(width = matchParent, height = dip(100)){
                gravity = Gravity.CENTER
                topMargin = dip(10)
            }
            //judulnya
            titleTV = textView().lparams(width = wrapContent, height = wrapContent){
                gravity = Gravity.CENTER
                margin = dip(10)
            }

            //deskripsinya
            descriptionTV = textView().lparams(width = wrapContent, height = wrapContent){
               gravity = Gravity.CENTER
            }
        }

        //get intent from MainActivity
        image = intent.getIntExtra(IMAGE, 0)
        title = intent.getStringExtra(TITLE)
        description = intent.getStringExtra(DESCRIPTION)


        //set to each view
        Glide.with(imageIV).load(image).into(imageIV)
        titleTV.text = title
        descriptionTV.text = description
    }
}
