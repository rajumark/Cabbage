package raju.shingadiya
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
public class FunProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): FunctionProcessor {
        return FunctionProcessor(
            options=environment.options,
            logger=environment.logger,
            codeGenerator=environment.codeGenerator
        )
    }

}