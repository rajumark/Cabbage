package raju.shingadiya

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import java.io.OutputStream

fun FileProvider(resolver: Resolver, codeGenerator: CodeGenerator): OutputStream {

// Make sure to associate the generated file with sources to keep/maintain it across incremental builds.
    // Learn more about incremental processing in KSP from the official docs:
    // https://kotlinlang.org/docs/ksp-incremental.html

    val file = codeGenerator.createNewFile(
        dependencies = Dependencies(false, *resolver.getAllFiles().toList().toTypedArray()),
        packageName = "raju.shingadiya",
        fileName = "CabbageFarm"
    )

    file.write("package raju.shingadiya".toByteArray())

    return file
}

