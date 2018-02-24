package au.com.subash.calculator.operation

import au.com.subash.calculator.operation.base.UnaryOperation

class PowerOperation : UnaryOperation(POWER, ROOT) {

    /**
     * Square operation. Perform square of first operand
     * Second operand is ignored
     *
     * @return Result of square of first operand
     *
     * {@inheritDoc}
     */
    override fun operate(firstOperand: Double, secondOperand: Double): Double =
        Math.pow(firstOperand, 2.0)
}