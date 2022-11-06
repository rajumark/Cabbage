package raju.shingadiya.cabbage
import com.google.auto.service.AutoService
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.validate
import com.squareup.kotlinpoet.FunSpec
import raju.shingadiya.cabbage.Cabbage

import raju.shingadiya.cabbage.visitors.DSLClassGenVisitor


class FunctionProcessor(
   val options: Map<String, String>,
   val logger: KSPLogger,
   val codeGenerator: CodeGenerator
) :SymbolProcessor{
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols=resolver.getSymbolsWithAnnotation(Cabbage::class.qualifiedName!!)
      //  logger.error("FileCreated:Run",null)

        //exit with processor in case nothing founds annotated with @Cabbage
        if (symbols.iterator().hasNext().not()) return emptyList()

        val file = FileProvider(resolver,codeGenerator)

        symbols.forEach { it.accept(DSLClassGenVisitor(file,logger),Unit) }


        //logger.error("FileCreated:",null)







        file.close()

        val unableToProcess =symbols.filterNot { it.validate() }.toList()
        return unableToProcess
    }
}