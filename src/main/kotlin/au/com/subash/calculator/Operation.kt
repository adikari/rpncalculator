package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.util.HashMap
import kotlin.math.sqrt

enum class Operation(private val symbol : String, val requiredOperand : Int) {

    ADD("+", 2) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand + firstOperand
    },

    SUBTRACT("-", 2) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand - firstOperand
    },

    DIVIDE("/", 2) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double {
            if (firstOperand == 0.0) {
                throw InvalidOperationException("Cannot divide operand by 0")
            }

            return secondOperand / firstOperand
        }
    },

    MULTIPLY("*", 2) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                secondOperand * firstOperand
    },

    SQUARE_ROOT("sqrt", 1) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                sqrt(firstOperand)
    },

    UNDO("undo", 0) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException()
    },

    CLEAR("clear", 0) {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException()
    };

    companion object {
        private val operators = HashMap<String, Operation>()

        fun getOperator(symbol : String) : Operation =
            operators[symbol] ?: throw InvalidOperationException("Invalid operator")

        init {
            values().forEach { operators[it.symbol] = it }
        }

    }

    abstract fun operate(firstOperand: Double, secondOperand: Double): Double
}
