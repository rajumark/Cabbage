package raju.shingadiya.cabbage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* val linkaddresss = "https://www.instagram.com/reel/Cip21PqjUen/?igshid=ZTA1ZTQyMGU="

        openInstaLink(linkaddresss)
*/

        /*  Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply {
                   setPackage("com.instagram.android")
               }.let {intent->
                   runCatching {

                   }
               }*/

    }

  /*  fun Context.openInstaLink(link: String) {
        val likeIng = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        likeIng.setPackage("com.instagram.android")
        try {
            startActivity(likeIng)
        } catch (e: ActivityNotFoundException) {
            Log.e("AndroidError:", e.message.toString())
        }
    }*/


}

