package au.com.subash.calculator.operation

import au.com.subash.calculator.InvalidOperationException
import java.util.HashMap
import kotlin.math.sqrt

enum class Operator(private val symbol : String) {

    ADD("+") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand + firstOperand
    },

    SUBTRACT("-") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand - firstOperand
    },

    DIVIDE("/") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double {
            if (firstOperand == 0.0) {
                throw InvalidOperationException("Cannot divide operand by 0")
            }

            return secondOperand / firstOperand
        }
    },

    MULTIPLY("*") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                secondOperand * firstOperand
    },

    SQUARE_ROOT("sqrt") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double = sqrt(firstOperand)
    },

    UNDO("undo") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException()
    },

    CLEAR("clear") {
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException()
    };

    private val operators = HashMap<String, Operator>()

    init {
        values().forEach { operators[it.symbol] = it }
    }

    abstract fun operate(firstOperand: Double, secondOperand: Double): Double
}