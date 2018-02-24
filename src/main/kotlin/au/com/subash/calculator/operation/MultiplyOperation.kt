package au.com.subash.calculator.operation

import au.com.subash.calculator.operation.base.BinaryOperation

class MultiplyOperation() : BinaryOperation(MULTIPLY, DIVIDE) {

    /**
     * Multiplication operation. Multiplication of two operands
     *
     * @return Result of multiplication of 2 operands
     *
     * {@inheritDoc}
     */
    override fun operate(firstOperand: Double, secondOperand: Double): Double =
            secondOperand * firstOperand
}