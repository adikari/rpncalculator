package au.com.subash.calculator.operation.base

import au.com.subash.calculator.operation.base.Operation

abstract class UnaryOperation
protected constructor(override val symbol : String, override val opposite : String) : Operation {
    override val requiredOperand = 1
}


