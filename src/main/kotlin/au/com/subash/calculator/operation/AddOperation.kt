package au.com.subash.calculator.operation

import au.com.subash.calculator.operation.base.BinaryOperation

class AddOperation : BinaryOperation(PLUS, MINUS) {

    /**
     * Addition operation. Add secondOperand with firstOperand
     *
     * @return Sum of first and second operand
     *
     * {@inheritDoc}
     */
    override fun operate(firstOperand: Double, secondOperand: Double): Double =
            secondOperand + firstOperand
}