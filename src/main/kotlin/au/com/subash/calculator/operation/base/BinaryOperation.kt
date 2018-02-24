package au.com.subash.calculator.operation.base

abstract class BinaryOperation
protected constructor(override val symbol : String, override val opposite : String) : Operation {
    override val requiredOperand = 2
}

