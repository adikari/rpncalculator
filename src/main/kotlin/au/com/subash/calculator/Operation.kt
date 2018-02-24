package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.lang.Math.pow
import java.util.HashMap
import kotlin.math.sqrt

/**
 * Perform operation on given operands
 *
 * @property symbol Symbol of operation
 * @property requiredOperand Number of operation given operation requires
 *
 * @constructor Default constructor
 */
enum class Operation(val symbol : String, val requiredOperand : Int, val opposite : String) {

    ADD("+", 2, "-") {

        /**
         * Addition operation. Add secondOperand with firstOperand
         *
         * @return Sum of first and second operand
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand + firstOperand
    },

    SUBTRACT("-", 2, "+") {

        /**
         * Subtraction operation. Subtract first operand from second operand
         *
         * @return Result of subtracting first operand from second
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double
                = secondOperand - firstOperand
    },

    DIVIDE("/", 2, "*") {

        /**
         * Division operation. Divide second operand by first operand
         *
         * @throws InvalidOperationException Division by 0.0
         *
         * @return Result of second operand divided by first
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double {
            if (firstOperand == 0.0) {
                throw InvalidOperationException("Cannot divide operand by 0!!")
            }

            return secondOperand / firstOperand
        }
    },

    MULTIPLY("*", 2, "/") {

        /**
         * Multiplication operation. Multiplication of two operands
         *
         * @return Result of multiplication of 2 operands
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                secondOperand * firstOperand
    },

    SQUARE_ROOT("sqrt", 1, "pow") {

        /**
         * Square root operation. Perform square root of first operand
         * Second operand is ignored
         *
         * @return Result of square root of first operand
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                sqrt(firstOperand)
    },

    POWER("pow", 1, "sqrt") {

        /**
         * Square operation. Perform square of first operand
         * Second operand is ignored
         *
         * @return Result of square of first operand
         *
         * {@inheritDoc}
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                pow(firstOperand, 2.0)
    },

    UNDO("undo", 0, "") {

        /**
         * Undo operation. Undo the last operation.
         * This operation is not meant to be called directly
         *
         * @throws InvalidOperationException
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException("Undo operation cannot be performed directly")
    },

    CLEAR("clear", 0, "") {

        /**
         * Clear operation. Clear the stack
         * This operation is not meant to be called directly
         *
         * @throws InvalidOperationException
         */
        override fun operate(firstOperand: Double, secondOperand: Double): Double =
                throw InvalidOperationException("Clear operation cannot be performed directly")
    };

    companion object {

        /**
         * Map of operators
         */
        private val operators = HashMap<String, Operation>()

        /**
         * Get Operator from the operation symbol
         *
         * @param symbol Operation symbol
         * @throws InvalidOperationException
         *
         * @return Operator
         */
        fun getOperator(symbol : String) : Operation =
            operators[symbol] ?: throw InvalidOperationException("Invalid operator!!")

        /**
         * Initialize all operations
         */
        init {
            values().forEach { operators[it.symbol] = it }
        }
    }

    /**
     * Perform operation on 2 operands
     *
     * @param firstOperand First operand of operation
     * @param secondOperand Second operand operation
     *
     * @return Result of operation
     */
    abstract fun operate(firstOperand: Double, secondOperand: Double): Double
}
