package raju.shingadiya.cabbage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog




@Cabbage
class Home() {
    var name: String? = null

    fun addWindow(window: Window) {

    }
}

@Cabbage
class Window() {
    var type:String?=null
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create home
        val home=Home()
        home.name="Cabbage Home"

        //create first window
        val window1=Window()
        window1.type="Glass Window"
        home.addWindow(window1)

        //create second window
        val window2=Window()
        window1.type="Wood Window"
        home.addWindow(window2)


        buildHome {
            name="Cabbage Home"

            addWindow(buildWindow {
                type="Glass Window"
            })

            addWindow(buildWindow {
                type="Wood Window"
            })
        }



    }
}

