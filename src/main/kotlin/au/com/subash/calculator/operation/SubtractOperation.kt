package au.com.subash.calculator.operation

import au.com.subash.calculator.operation.base.BinaryOperation

class SubtractOperation : BinaryOperation(MINUS, PLUS) {

    /**
     * Subtraction operation. Subtract first operand from second operand
     *
     * @return Result of subtracting first operand from second
     *
     * {@inheritDoc}
     */
    override fun operate(firstOperand: Double, secondOperand: Double): Double =
        secondOperand - firstOperand
}