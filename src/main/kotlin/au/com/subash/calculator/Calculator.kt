package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.util.Stack

/**
 * RPN calculator
 * Perform operation using Reverse Polish Notation
 */
class Calculator {

    /**
     * Stack to store operands
     */
    var operandStack = Stack<Double>()
        private set

    /**
     * Stack to restore previous operation
     */
    private val undoStack = Stack<Double>()

    /**
     * Evaluate RPN expression
     *
     * @param input RPN expression
     */
    fun evaluate(input : String) {
        val expression = input.split(" ")

        expression.forEach {
            val operand = it.toDoubleOrNull()

            if (null == operand) parseSymbol(it) else operandStack.push(operand)
        }
    }

    /**
     * Parse operation symbol and perform operation accordingly
     *
     * @param symbol Operation symbol
     */
    private fun parseSymbol(symbol: String) {
        val operation = Operation.getOperator(symbol)

        when (operation) {
            Operation.UNDO -> performUndoOperation()
            Operation.CLEAR -> performClearOperation()
            else -> performOperation(operation)
        }
    }

    /**
     * Perform calculate operation
     *
     * @param operation Operation to perform
     *
     * @throws InvalidOperationException There are not enough operands to perform operation
     */
    private fun performOperation(operation : Operation) {

        if (operandStack.isEmpty()) {
            throw InvalidOperationException("No operands to operate on!!")
        }

        val firstOperand = operandStack.pop()
        val secondOperand = if (operation.requiredOperand > 1) operandStack.pop() else 0.0

        operandStack.push(operation.operate(firstOperand, secondOperand))

        undoStack.push(firstOperand)
        undoStack.push(secondOperand)
    }

    /**
     * Perform undo operation. Reset operandStack to state before last operation
     *
     * @throws InvalidOperationException There is not enough operands for undo operation
     */
    private fun performUndoOperation() {
        if (undoStack.size < 2) {
            throw InvalidOperationException("Noting to undo!!")
        }

        operandStack.pop()
        operandStack.push(undoStack.pop())
        operandStack.push(undoStack.pop())
    }

    /**
     * Clear both undo and operand stack
     */
    private fun performClearOperation() {
        operandStack.clear()
        undoStack.clear()
    }
}