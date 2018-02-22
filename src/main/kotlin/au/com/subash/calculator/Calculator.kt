package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.util.Stack

class Calculator {

    var operandStack = Stack<Double>()
        private set

    fun evaluate(input : String) {
        val split = input.split(" ")

        split.forEach { parseInput(it) }
    }

    private fun parseInput(input : String) {
        val operand = input.toDoubleOrNull()

        if (null == operand) processOperator(input) else operandStack.push(operand)
    }

    private fun processOperator(operator : String) {

        if (operandStack.isEmpty()) {
            throw InvalidOperationException("No operands to operate on")
        }

        val operation = Operation.getOperator(operator)

        when (operation) {
            Operation.UNDO -> performUndoOperation()
            Operation.CLEAR -> performClearOperation()
            else -> performOperation(operation)
        }
    }

    private fun performOperation(operation : Operation) {
        val firstOperand = operandStack.pop()
        val secondOperand = if (operation.requiredOperand > 1) operandStack.pop() else 0.0

        val result = operation.operate(firstOperand, secondOperand)
        operandStack.push(result)
    }

    private fun performUndoOperation() {
        TODO("Implement later")
    }

    private fun performClearOperation() = operandStack.clear()
}