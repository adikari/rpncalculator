package au.com.subash.calculator.operation.base

interface Operation {

    /**
     * Number of operands required to perform operation
     */
    val requiredOperand : Int

    /**
     * Symbol of opposite operation
     */
    val opposite : String

    /**
     * Symbol of operation
     */
    val symbol : String

    /**
     * Perform operation on 2 operands
     *
     * @param firstOperand First operand of operation
     * @param secondOperand Second operand operation
     *
     * @return Result of operation
     */
    fun operate(firstOperand: Double, secondOperand: Double): Double
}