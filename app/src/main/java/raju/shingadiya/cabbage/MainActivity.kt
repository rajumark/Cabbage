package raju.shingadiya.cabbage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog



@Cabbage
class Collage(context: Context,size:Int){
    var name:String?=null

    fun addFullName(fullname:String){

    }
}




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home=Collage(this,10)
        home.name="abnrios"
        home.addFullName("andirud")

        val home1= buildCollage(this,10) {
            name="raju"
            addFullName("Andorid")
        }


    }


}

