package raju.shingadiya.cabbage.visitors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import raju.shingadiya.cabbage.append
import raju.shingadiya.cabbage.appendNext
import raju.shingadiya.cabbage.nextLine
import java.io.OutputStream

class DSLClassGenVisitor(
    val file:OutputStream,
    val logger: KSPLogger,
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        super.visitClassDeclaration(classDeclaration, data)


        //fun buildHome(block:Home.()->Unit){
        //    return Home().apply(block)
        //}
        val pname=classDeclaration.packageName.asString()
        val cname=classDeclaration.simpleName.asString()

        val classHost= ClassName(pname,cname)

        val functionGeneratedBuid="""
            fun build$cname(block:${classHost.toString()}.()->Unit){
                return ${classHost.toString()}().apply(block)
            }
        """.trimIndent()

        val fun1= FunSpec.builder("build$cname").addParameter("name",String::class).build()
        file.appendNext(functionGeneratedBuid)
        file.nextLine()
        //file.appendNext(fun1.toString())

    }



}