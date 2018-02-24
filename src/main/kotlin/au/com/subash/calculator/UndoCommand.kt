package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException

class UndoCommand(private val operator: Operation, private val value : Double) {

    fun getExpression(): String {
        if (operator.requiredOperand < 1)
            throw InvalidOperationException("invalid operation for operator ${operator.symbol}!!")

        return if (operator.requiredOperand < 2) operator.opposite else "$value ${operator.opposite} $value"
    }
}