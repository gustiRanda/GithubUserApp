package com.gmind.githubuserapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun loadData(){
        val user = intent.getParcelableExtra(EXTRA_USER) as User
        val ivDetailAvatar: ImageView = findViewById(R.id.detail_avatar)
        val userAvatar = user.avatar
        Glide.with(this)
            .load(userAvatar)
            .apply(RequestOptions().override(350, 350))
            .into(ivDetailAvatar)

        val tvUsername = findViewById<TextView>(R.id.detail_username)
        val username = user.username
        tvUsername.text = username

        val tvName = findViewById<TextView>(R.id.detail_name)
        val name = user.name
        tvName.text = name

        val tvLocation = findViewById<TextView>(R.id.detail_location)
        val location = user.location
        tvLocation.text = location

        val tvRepository = findViewById<TextView>(R.id.detail_repository)
        val repository = user.repository
        tvRepository.text = repository.toString()

        val tvCompany = findViewById<TextView>(R.id.detail_company)
        val company = user.company
        tvCompany.text = company

        val tvFollowers = findViewById<TextView>(R.id.detail_followers)
        val followers = user.followers
        tvFollowers.text = followers.toString()

        val tvFollowing = findViewById<TextView>(R.id.detail_following)
        val following = user.following
        tvFollowing.text = following.toString()

    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}
