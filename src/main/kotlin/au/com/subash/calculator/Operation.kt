package au.com.subash.calculator

interface Operation {
    fun calculate(leftOperand : Double, rightOperand : Double) : Double
}