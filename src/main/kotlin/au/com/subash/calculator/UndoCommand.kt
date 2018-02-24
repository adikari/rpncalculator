package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import au.com.subash.calculator.operation.base.Operation

/**
 * Undo command. Used to perform undo operation
 *
 * @property operator Operation to undo
 * @property operand  Operand used in undo operation
 *
 * @constructor Default constructor
 */
class UndoCommand(private val operator: Operation, private val operand : Double) {

    init {
        if (operator.requiredOperand < 1)
            throw InvalidOperationException("Operation must have at least 1 required operand!!")
    }

    /**
     * Get reverse RPN expression from current operation and operand
     *
     * @return Reverse RPN expression
     */
    fun reverseExpression(): String {
        if (operator.requiredOperand < 2) return operator.opposite

        return "$operand ${operator.opposite} $operand"
    }
}