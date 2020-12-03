package com.gmind.githubuserapp

import UserData
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.recycler_view_user)
        rvUser.setHasFixedSize(true)

        list.addAll(UserData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(user: User) {
                val detailPage = Intent(this@MainActivity, DetailActivity::class.java)
                detailPage.putExtra(DetailActivity.EXTRA_USER, user)
                startActivity(detailPage)
            }
        })
    }
}
