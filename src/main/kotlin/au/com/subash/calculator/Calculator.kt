package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.util.Stack

class Calculator {

    var operandStack = Stack<Double>()
        private set

    private val undoStack = Stack<Double>()

    fun evaluate(input : String) {
        val split = input.split(" ")

        split.forEach { parseInput(it) }
    }

    private fun parseInput(input : String) {
        val operand = input.toDoubleOrNull()

        if (null == operand) processOperator(input) else operandStack.push(operand)
    }

    private fun processOperator(operator : String) {

        val operation = Operation.getOperator(operator)

        when (operation) {
            Operation.UNDO -> performUndoOperation()
            Operation.CLEAR -> performClearOperation()
            else -> performOperation(operation)
        }
    }

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

    private fun performUndoOperation() {
        if (undoStack.size < 2) {
            throw InvalidOperationException("Noting to undo!!")
        }

        operandStack.pop()
        operandStack.push(undoStack.pop())
        operandStack.push(undoStack.pop())
    }

    private fun performClearOperation() {
        operandStack.clear()
        undoStack.clear()
    }
}