package com.example.photobook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class SavedPostsActivity : AppCompatActivity() {

    private lateinit var recyclerPosts: RecyclerView
    private val posts = ArrayList<Post>();
    private lateinit var postAdapter: PostsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initData()
        initData()

        initViews()

    }

    private fun initViews() {
        recyclerPosts = findViewById(R.id.recyclePosts)
        recyclerPosts.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        postAdapter = PostsAdapter(posts)
        recyclerPosts.adapter = postAdapter

        postAdapter.onPostClickListener = SavePostsOnClickListener()

    }

    inner class SavePostsOnClickListener : PostsAdapter.OnPostClickListener {
        override fun onAccountClick(accountName: String, position: Int) {
            mt("SPA: account at $position name: $accountName clicked")
        }

        override fun onImageClick(imageId: Int, position: Int) {
            mt("SPA: image at $position clicked")
        }

        override fun onLikeClicked(id:Int,position: Int) {
            mt("SPA: post at $position clicked")
        }
    }

    private fun mt(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        posts.add(
            Post(1,"@androidsociety","12-04-2023", R.drawable.image1,"The platform that’s changing what mobile can do", 0,false)
        )
        posts.add(
            Post(1,"@techcircle","22-03-2023", R.drawable.image2, "come here and get engaged with techies", 0,false)
        )
        posts.add(
            Post(1,"@codingmemes","24-03-2023", R.drawable.image3,"Daily life of a coder", 15, false)
        )
        posts.add(
            Post(1,"@python_programmers","26-03-2023",R.drawable.image4, "Get started with Python", 0, false)
        )
        posts.add(
            Post(1,"@androidsociety","12-04-2023", R.drawable.image1,"The platform that’s changing what mobile can do", 10, false)
        )
        posts.add(
            Post(1,"@techcircle","22-03-2023", R.drawable.image2, "come here and get engaged with techies", 12, false)
        )
        posts.add(
            Post(1,"@codingmemes","24-03-2023", R.drawable.image3,"Daily life of a coder", 15,false)
        )
        posts.add(
            Post(1,"@python_programmers","26-03-2023",R.drawable.image4, "Get started with Python", 10,false)
        )
        posts.add(
            Post(1,"@androidsociety","12-04-2023", R.drawable.image1,"The platform that’s changing what mobile can do", 10, false)
        )
        posts.add(
            Post(1,"@techcircle","22-03-2023", R.drawable.image2, "come here and get engaged with techies", 12, false)
        )
        posts.add(
            Post(1,"@codingmemes","24-03-2023", R.drawable.image3,"Daily life of a coder", 15, false)
        )
        posts.add(
            Post(1,"@python_programmers","26-03-2023",R.drawable.image4, "Get started with Python", 10, false)
        )
    }
}