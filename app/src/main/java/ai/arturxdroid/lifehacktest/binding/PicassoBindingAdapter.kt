package ai.arturxdroid.lifehacktest.binding

import ai.arturxdroid.lifehacktest.network.ApiFactory
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object PicassoBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    public fun loadImage(imageView: ImageView, urlImage: String?) {
        if (urlImage != null)
            Picasso.get().load(ApiFactory.BASE_URL + urlImage).into(imageView)
    }
}