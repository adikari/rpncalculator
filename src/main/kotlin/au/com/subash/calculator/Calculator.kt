package au.com.subash.calculator

import java.util.Stack

class Calculator {

    private val operandStack = Stack<Double>()

    fun evaluate(input : String) {
        val split = input.split("\\s")

        split.forEach { parseInput(it) }
    }

    private fun parseInput(input : String) {
        val operand = input.toDoubleOrNull()

        if (null == operand) {
            processOperator(input)
        } else {
           operandStack.push(operand)
        }
    }

    private fun processOperator(operator : String) {

        if (operandStack.isEmpty()) {
            // TODO: throw stack empty exception
            throw Exception("No operands to operate on")
        }

        // TODO: throw No such operator exception
        // val operation = operations[operator] ?: throw Exception("No such operator")

    }
}