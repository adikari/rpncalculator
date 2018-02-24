package au.com.subash.calculator.operation

import au.com.subash.calculator.operation.base.UnaryOperation
import kotlin.math.sqrt

class RootOperation() : UnaryOperation(ROOT, POWER) {

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
}