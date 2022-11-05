package raju.shingadiya.cabbage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


@Cabbage
class Home()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val home  =  buildHome {

        }


    }
}

