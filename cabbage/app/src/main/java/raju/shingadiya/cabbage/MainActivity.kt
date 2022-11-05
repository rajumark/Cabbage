package raju.shingadiya.cabbage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog


class Home()

@Cabbage
class FullName(
    var name: String,
    val fullName:String,
    ) {

    val listchild= mutableListOf<Pair<String?,Int?>>()
    var age: Int = 0
    var gender: Boolean = false

    fun addChild(childName:String?=null, childAge:Int?=null){
        listchild.add(Pair(childName,childAge))
    }
}

fun FullName.buildAddChild(block:FullName_addChild.()->Unit){
    //handle nullnale and default value also
  val cvlassobje=FullName_addChild().apply(block)
  addChild(cvlassobje.childName,cvlassobje.childAge)
}

class FullName_addChild() {
    var childName:String?=null
    var childAge:Int?=null
}



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildFullName("Raju","Shingadiya") {
             buildAddChild {
                 name="andori"
                 childAge=12
             }
        }

    }
}

