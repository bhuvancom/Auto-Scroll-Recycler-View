package com.bhuvancom.testingforsivangi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rv: AutoScrollRecyclerView = findViewById<AutoScrollRecyclerView>(R.id.rv)
        val imgList = listOf(
            "https://images.pexels.com/photos/302899/pexels-photo-302899.jpeg?auto=compress&cs=tinysrgb&w=400",
            "https://images.pexels.com/photos/7340936/pexels-photo-7340936.jpeg?auto=compress&cs=tinysrgb&w=400",
            "https://images.pexels.com/photos/674574/pexels-photo-674574.jpeg?auto=compress&cs=tinysrgb&w=400",
            "https://images.pexels.com/photos/4551973/pexels-photo-4551973.jpeg?auto=compress&cs=tinysrgb&w=400"
        )

        rv.apply {
            addItemDecoration(Spacer(10)) // space bt items
            adapter = MyAdapter(imgList)
            setCanTouch(true) // false to disable user touch
            val gridLayoutManager = GridLayoutManager(
                this@MainActivity,
                3, RecyclerView.HORIZONTAL, false
            )
            layoutManager = gridLayoutManager
            isLoopEnabled = true // enable infinite scroll
            openAutoScroll(5,true) // first param to control speed, second wether to scroll backward
        }
    }
}

class MyAdapter(private val items: List<String>) : RecyclerView.Adapter<MyAdapter.MyVH>() {

    inner class MyVH(view: View) : RecyclerView.ViewHolder(view) {
        val imgView: ImageView = view.findViewById(R.id.iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        return MyVH(LayoutInflater.from(parent.context).inflate(R.layout.item_img, parent, false))
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        val img = items[position]
        Picasso.get().load(img).into(holder.imgView)
    }

    override fun getItemCount(): Int = items.size
}
