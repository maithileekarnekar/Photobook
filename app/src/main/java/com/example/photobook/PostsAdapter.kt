package com.example.photobook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PostsAdapter (
    private val posts : ArrayList<Post>
    ) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    interface OnPostClickListener {
        fun onAccountClick(accountName: String, position: Int)
        fun onImageClick(imageId: Int, position: Int)
        fun onLikeClicked(id: Int, position: Int)
    }

    var onPostClickListener: OnPostClickListener? = null


    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtAccountName: TextView
        val txtPostedOn: TextView
        val imgPost: ImageView
        val imgLike: ImageView
        val txtLikes: TextView
        val txtCaption: TextView

        init {
            txtAccountName = view.findViewById(R.id.txtAccountName)
            txtPostedOn = view.findViewById(R.id.txtPostedOn)
            imgPost = view.findViewById(R.id.imgPost)
            imgLike = view.findViewById(R.id.imgLike)
            txtLikes = view.findViewById(R.id.txtLikes)
            txtCaption = view.findViewById(R.id.txtCaption)

            imgLike.setOnClickListener {

                val post = posts[adapterPosition]
                post.likes += 1
                txtLikes.text = "${post.likes}"
                post.isLiked = !post.isLiked
                imgLike.setImageResource(
                    if (post.isLiked) {
                        R.drawable.heart_filled
                    } else {
                        R.drawable.heart_outline
                    }

                )
            }

            imgPost.setOnClickListener {
                onPostClickListener?.onImageClick(
                    posts[adapterPosition].imageId!!,
                    adapterPosition
                )
            }

            txtAccountName.setOnClickListener {
                onPostClickListener?.onAccountClick(
                    posts[adapterPosition].accountName,
                    adapterPosition
                )
            }
        }
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        //create view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_view, null)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.txtAccountName.text = post.accountName
        holder.txtPostedOn.text = post.postedOn
        if (post.imageId != null) {
            holder.imgPost.setImageResource(post.imageId)

        }
        holder.txtLikes.text = "${post.likes}"
        if (post.caption != null) {
            holder.txtCaption.text = post.caption
            holder.txtCaption.visibility = View.VISIBLE
        } else {
            holder.txtCaption.visibility = View.GONE
        }
    }

    private fun mt(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}