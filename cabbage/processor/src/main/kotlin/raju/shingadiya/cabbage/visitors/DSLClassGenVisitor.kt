package raju.shingadiya.cabbage.visitors

import com.google.devtools.ksp.getDeclaredFunctions
import com.google.devtools.ksp.isInternal
import com.google.devtools.ksp.isLocal
import com.google.devtools.ksp.isPublic
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSValueParameter
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ksp.toTypeName
import raju.shingadiya.cabbage.append
import raju.shingadiya.cabbage.appendNext
import raju.shingadiya.cabbage.appendTest
import raju.shingadiya.cabbage.nextLine
import java.io.OutputStream

class DSLClassGenVisitor(
    val file: OutputStream,
    val logger: KSPLogger,
) : KSVisitorVoid() {

    override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        super.visitClassDeclaration(classDeclaration, data)


        //fun buildHome(block:Home.()->Unit){
        //    return Home().apply(block)
        //}
        val pname = classDeclaration.packageName.asString()
        val cname = classDeclaration.simpleName.asString()

        val classHost: ClassName = ClassName(pname, cname)

        val functionGeneratedBuid = """
            fun build$cname(block:${classHost.toString()}.()->Unit):${classHost.toString()}{
                return ${classHost.toString()}().apply(block)
            }   
        """.trimIndent()

        //file.appendNext(functionGeneratedBuid)
        //block:Home.()->Unit
       // val classSDl=ClassName("","$classHost.()->Unit")

        try {

            //sub method dsl generator with nullble and default value
            //goal is to generate below code
           /* fun FullName.buildAddChild(block:FullName_addChild.()->Unit){
                //handle nullnale and default value also
                val cvlassobje=FullName_addChild().apply(block)
                addChild(cvlassobje.childName,cvlassobje.childAge)
            }

            class FullName_addChild() {
                var childName:String?=null
                var childAge:Int?=null
            }*/
            val methods=classDeclaration.getDeclaredFunctions()
            val methods1=classDeclaration.getAllFunctions().toList().filter { it.isPublic() &&  it.findOverridee()==null}



            methods1.forEachIndexed { index, ksFunctionDeclaration ->
                val functionNme=ksFunctionDeclaration.simpleName.asString()


                val subclassGen=TypeSpec.classBuilder("${cname}_$functionNme")
                ksFunctionDeclaration.parameters.forEachIndexed { index1, ksValueParameter ->
                    val propertySpec=PropertySpec.builder(ksValueParameter.name?.asString()?:"",ksValueParameter.type.toTypeName()).

                    subclassGen.addProperty(ksValueParameter.name?.asString()?:"",ksValueParameter.type.toTypeName())
                   // file.append(ksValueParameter.name?.asString()+" , ")
                }
                file.append(subclassGen.build().toString())
            }

            //constructor params setup
            val params = classDeclaration.primaryConstructor?.parameters.orEmpty()
            val paramsNames=params.map { it.name?.asString() }.filterNotNull()
            val paramsPass=paramsNames.reduce{ a,b ->"$a,$b" }

            //file.appendNext(params.name!!.asString())
            //file.appendNext(params.type.toString())



            file.nextLine()
            //file.appendNext( paramConstructor.toString())

            file.nextLine()

            val recived=  LambdaTypeName.get(receiver = classHost, returnType = ClassName("","Unit"))
           // val lambdaTypeName = LambdaTypeName.get(returnType = classHost)
            val parambuild=ParameterSpec.builder("block",recived).build()


            // val funlembda= FunSpec.builder("block").addParameter(parambuild).build()

            //file.appendNext(funlembda.toString())

            val fun1 = FunSpec
                .builder("build$cname").apply {
                    params.forEachIndexed { index, ksValueParameter ->
                        ksValueParameter.name?.asString()?.let { nameParam->
                            addParameter(nameParam,ksValueParameter.type.resolve().toTypeName())
                        }
                    }
                }
                 .addParameter(parambuild)
                 .addStatement("return %T($paramsPass).apply(block)",classHost)
                 .returns(returnType = classHost)
                .build()

            file.nextLine()
            file.appendNext(fun1.toString())
        }catch (e:Exception){
            file.nextLine()
            file.appendNext(e.message.toString())
            file.nextLine()
        }


    }


}