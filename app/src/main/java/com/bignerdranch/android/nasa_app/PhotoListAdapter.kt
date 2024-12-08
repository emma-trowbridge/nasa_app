package com.bignerdranch.android.nasa_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bignerdranch.android.nasa_app.api.GalleryItem
import com.bignerdranch.android.nasa_app.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding,
    private val onItemClick: (GalleryItem) -> Unit
): RecyclerView.ViewHolder(binding.root){

    fun bind(galleryItem: GalleryItem){
        //todo
        //loads image into the ImageView
        binding.itemImageView.load(galleryItem.url)

        //set the click listener for the item
        binding.root.setOnClickListener{
            onItemClick(galleryItem)
        }
    }
}

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>,
    private val onItemClick: (GalleryItem) -> Unit //callback for click events
) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding, onItemClick) //added in onItemClick
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onItemClick(item) } //passes click listener to ViewHolder
    }

    override fun getItemCount() = galleryItems.size
}
