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
    private val undoStack = Stack<UndoCommand>()

    /**
     * Position of current operation
     */
    private var index = 0

    /**
     * Perform calculation on RPN expression
     *
     * @param input RPN expression
     */
    fun calculate(input : String) {
        calculate(input, false)
    }

    /**
     * Get result from previous operation
     *
     * @return Result of previous operation
     * @throws InvalidOperationException No operation has been performed
     */
    fun getResult(): Double {
        if (undoStack.isEmpty()) {
            throw InvalidOperationException("No calculation has been performed!!")
        }

        return operandStack.peek()
    }

    /**
     * Perform calculation on RPN expression
     *
     * @param input  RPN expression
     * @param isUndo Flag if its undo operation
     */
    private fun calculate(input : String, isUndo : Boolean) {
        val expression = input.split(" ")

        expression.forEach {
            index ++
            val operand = it.toDoubleOrNull()

            if (null == operand) evaluate(it, isUndo)
            else {
                operandStack.push(operand)
                if (!isUndo) undoStack.push(null)
            }
        }
    }

    /**
     * Evaluate symbol and perform operation accordingly
     *
     * @param symbol Operation symbol
     * @param isUndo Flag if its undo operation
     */
    private fun evaluate(symbol: String, isUndo: Boolean) {
        val operation = Operation.getOperator(symbol)

        when (operation) {
            Operation.UNDO -> performUndoOperation()
            Operation.CLEAR -> performClearOperation()
            else -> performOperation(operation, isUndo)
        }
    }

    /**
     * Perform calculate operation
     *
     * @param operation Operation to perform
     * @param isUndo    Flag if its undo operation
     *
     * @throws InvalidOperationException There are not enough operands to perform operation
     */
    private fun performOperation(operation : Operation, isUndo: Boolean) {
        if (operandStack.isEmpty() || operandStack.size < operation.requiredOperand) {
            val msg = "operator ${operation.symbol} (position: $index): insufficient parameters"
            throw InvalidOperationException(msg)
        }

        val firstOperand = operandStack.pop()
        val secondOperand = if (operation.requiredOperand > 1) operandStack.pop() else 0.0

        operandStack.push(operation.operate(firstOperand, secondOperand))

        if (!isUndo) undoStack.push(UndoCommand(operation, firstOperand))
    }

    /**
     * Perform undo operation. Reset operandStack to state before last operation
     *
     * @throws InvalidOperationException There is not enough operands for undo operation
     */
    private fun performUndoOperation() {
        if (undoStack.isEmpty()) {
            throw InvalidOperationException("Noting to undo!!")
        }

        val undoCommand = undoStack.pop()

        if (null == undoCommand) operandStack.pop()
        else calculate(undoCommand.reverseExpression(), true)
    }

    /**
     * Clear both undo and operand stack
     */
    private fun performClearOperation() {
        operandStack.clear()
        undoStack.clear()
    }
}