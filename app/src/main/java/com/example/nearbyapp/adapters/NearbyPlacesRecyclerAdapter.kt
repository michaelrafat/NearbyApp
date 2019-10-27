package com.example.nearbyapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.R
import com.example.nearbyapp.model.Item
import com.example.nearbyapp.model.Venue
import com.squareup.picasso.Picasso


class NearbyPlacesRecyclerAdapter(
    private val context: Context,
    private val nearbyPlace: ArrayList<Item>
) : RecyclerView.Adapter<NearbyPlacesRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.place_item, parent, false))
    }

    override fun getItemCount(): Int {
        return nearbyPlace.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(nearbyPlace[position].venue, context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.tv_place_name) as TextView
        private val addressTextView: TextView =
            itemView.findViewById(R.id.tv_place_address) as TextView
        private val placePhotoIV: ImageView =
            itemView.findViewById(R.id.iv_place_image) as ImageView

        fun bindView(venue: Venue, context: Context) {

            nameTextView.text = venue.name
            addressTextView.text = venue.location.address

            Picasso.get().load(
                venue?.categories[0].icon.prefix + 512 + venue?.categories[0].icon.suffix
            ).into(placePhotoIV)
        }

    }

}