package raju.shingadiya.cabbage

import java.io.OutputStream


fun OutputStream.nextLine(){
    this.write("\n".toByteArray())
}

fun OutputStream.append(text:String){
    this.write(text.toByteArray())
}

fun OutputStream.appendNext(text:String){
    nextLine()
    this.write(text.toByteArray())
}