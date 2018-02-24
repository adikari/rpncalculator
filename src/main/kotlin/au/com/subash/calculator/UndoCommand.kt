package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException

/**
 * Undo command. Used to perform undo operation
 *
 * @property operator Operation to undo
 * @property operand  Operand used in undo operation
 *
 * @constructor Default constructor
 */
class UndoCommand(private val operator: Operation, private val operand : Double) {

    /**
     * Get reverse RPN expression from current operation and operand
     *
     * @return Reverse RPN expression
     */
    fun reverseExpression(): String {
        if (operator.requiredOperand < 1) {
            throw InvalidOperationException("Not enough operands for ${operator.symbol}!!")
        }

        if (operator.requiredOperand < 2) return operator.opposite

        return "$operand ${operator.opposite} $operand"
    }
}