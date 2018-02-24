package au.com.subash.calculator.operation

import au.com.subash.calculator.exception.InvalidOperationException
import au.com.subash.calculator.operation.base.BinaryOperation

class DivideOperation : BinaryOperation(DIVIDE, MULTIPLY) {

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
        if (firstOperand == 0.0) throw InvalidOperationException("Cannot divide operand by 0!!")

        return secondOperand / firstOperand
    }
}