package raju.shingadiya.cabbage
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

  class FunProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): FunctionProcessor {
        return FunctionProcessor(
            options=environment.options,
            logger=environment.logger,
            codeGenerator=environment.codeGenerator
        )
    }

}