package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class CalculatorSpec : Spek ({

    given ("a calculator") {

        on ("calculate") {

            it ("should perform the calculation from RPN expression") {
                val calculator = Calculator()

                calculator.calculate("5 2")

                calculator.operandStack.toString() `should equal` "[5.0, 2.0]"
            }

            it ("should perform calculation with sqrt and clear operations") {
                val calculator = Calculator()

                calculator.calculate("2 sqrt")

                calculator.operandStack.toString() `should equal` "[1.4142135623730951]"

                calculator.calculate("clear 9 sqrt")

                calculator.operandStack.toString() `should equal` "[3.0]"
            }

            it ("should perform calculation with subtraction and clear operators") {
                val calculator = Calculator()

                calculator.calculate("5 2 -")
                calculator.operandStack.toString() `should equal` "[3.0]"

                calculator.calculate("3 -")
                calculator.operandStack.toString() `should equal` "[0.0]"

                calculator.calculate("clear")
                calculator.operandStack.toString() `should equal` "[]"
            }

            it ("should perform calculation with division and multiplication operators") {
                val calculator = Calculator()

                calculator.calculate("7 12 2 /")
                calculator.operandStack.toString() `should equal` "[7.0, 6.0]"

                calculator.calculate("*")
                calculator.operandStack.toString() `should equal` "[42.0]"

                calculator.calculate("4 /")
                calculator.operandStack.toString() `should equal` "[10.5]"
            }

            it ("should perform calculation with multiplication operators") {
                val calculator = Calculator()

                calculator.calculate("1 2 3 4 5")
                calculator.operandStack.toString() `should equal` "[1.0, 2.0, 3.0, 4.0, 5.0]"

                calculator.calculate("* * * *")
                calculator.operandStack.toString() `should equal` "[120.0]"
            }

            it ("should perform undo operation") {
                val calculator = Calculator()

                calculator.calculate("5 4 3 2")
                calculator.operandStack.toString() `should equal` "[5.0, 4.0, 3.0, 2.0]"

                calculator.calculate("undo undo *")
                calculator.operandStack.toString() `should equal` "[20.0]"

                calculator.calculate("5 *")
                calculator.operandStack.toString() `should equal` "[100.0]"

                calculator.calculate("undo")
                calculator.operandStack.toString() `should equal` "[20.0, 5.0]"
            }

            it ("should throw InvalidOperationException if undo operation performed with no operands") {
                val calculator = Calculator()

                try {
                    calculator.calculate("undo")
                    fail("Should throw InvalidOperationException")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Noting to undo!!"
                }
            }

            it ("should throw exception if not enough operands for operation") {
                val calculator = Calculator()

                try {
                    calculator.calculate("1 2 3 * 5 + * * 6 5")
                    fail("It should throw insufficient operands exception")
                } catch (e : InvalidOperationException) {
                    calculator.operandStack.toString() `should equal` "[11.0]"

                    e.message `should equal` "operator * (position: 8): insufficient parameters"
                }
            }
        }

        on("get result") {

            it ("should return result of previous operation") {
                val calculator = Calculator()

                calculator.calculate("1 2 +")
                calculator.getResult() `should equal` 3.0

                calculator.calculate("2 +")
                calculator.getResult() `should equal` 5.0

                calculator.calculate("5 5 * +")
                calculator.getResult() `should equal` 30.0
            }

            it ("should throw exception if no calculation was performed") {
                try {
                    val calculator = Calculator()
                    calculator.getResult()

                    fail("Should throw InvalidOperationException.")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "No calculation has been performed!!"
                }
            }
        }
    }
})