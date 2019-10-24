package com.example.nearbyapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.R
import com.example.nearbyapp.api.ApiInterface
import com.example.nearbyapp.model.Item
import com.example.nearbyapp.model.PhotoResponse
import com.example.nearbyapp.model.Venue
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

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
        holder.bindView(nearbyPlace[position].venue)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mCompositeDisposable = CompositeDisposable()
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_place_name) as TextView
        private val addressTextView: TextView = itemView.findViewById(R.id.tv_place_address) as TextView
        private val placePhotoIV: ImageView = itemView.findViewById(R.id.iv_place_image) as ImageView

        fun bindView(venue: Venue) {

            nameTextView.text = venue.name
            addressTextView.text = venue.location.address
            fetchPhoto(venue.id, placePhotoIV)
        }

        private fun fetchPhoto(venueId: String, imageView: ImageView) {

            mCompositeDisposable.add(
                ApiInterface.create().getPhoto(
                    venueId, "OYOAJQXZDNYHPTYPDDXN3GH4CC4Z35PLWESXDEUCJIZVWCON"
                    , "TAQJQZAJPSSG2DLBTZMBZRNHKJFKWRR0JGYAGWRBQA20GM4E",
                    "20191024", "cairo")
                    .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<PhotoResponse>() {
                        override fun onNext(t: PhotoResponse) {
                            Picasso.get().load(t.response.venue.tips.groups[0].items[0].photourl).into(imageView)
                        }
                        override fun onError(e: Throwable) {
                        }
                        override fun onComplete() {
                        }
                    })
            )
        }
    }
}