package raju.shingadiya

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.validate

class FunctionProcessor(
   val options: Map<String, String>,
   val logger: KSPLogger,
   val codeGenerator: CodeGenerator
) :SymbolProcessor{
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols=resolver.getSymbolsWithAnnotation(Cabbage::class.qualifiedName!!)

        

        val unableToProcess =symbols.filterNot { it.validate() }.toList()
        return unableToProcess
    }
}