package au.com.subash.calculator

import java.util.*
import java.util.Arrays.asList

class Calculator {

    private val operator = asList("+", "-", "*", "/", "sqrt")
    private val commands = asList("undo", "clear")

    private val operations : Map<Char, Operation> = HashMap()
    private val stack = Stack<Double>()

    fun evaluate(input : String) {
        val chars = input.split(" ")

        chars.forEach {
            when {
                isOperator(it) -> {
                    try {
                        val result : Double = calculate(it.single())
                        stack.push(result)
                    } catch (e : Exception) {
                        println(e.message)
                    }
                }
                isCommand(it) -> {

                }
                else -> stack.push(it.toDouble())
            }
        }
    }

    /**
     * Perform calculation on top 2 items on stack with given operator
     *
     * @param operator Operator to perform calculation with
     *
     * @return Calculated value
     */
    private fun calculate(operator : Char) : Double {

        if (stack.size < 2) {
            // TODO: throw NotEnoughOperandException
            throw Exception("Not enough operators to perform calculation.")
        }

        // TODO: throw UnknownOperationException
        val operation : Operation = operations[operator] ?: throw Exception("Unrecognized operation")

        val leftOperand : Double = stack.pop()
        val rightOperand : Double = stack.pop()

        return operation.calculate(leftOperand, rightOperand)
    }

    private fun isOperator(input : String) : Boolean {
        return operator.contains(input)
    }

    private fun isCommand(input : String) : Boolean {
        return commands.contains(input)
    }
}