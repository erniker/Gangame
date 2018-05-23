package silmood.com.commons

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadimage(imageView: ImageView, url: String) {
    Glide.with(imageView)
            .load(url)
            .into(imageView)
}