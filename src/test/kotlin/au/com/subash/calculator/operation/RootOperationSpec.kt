package au.com.subash.calculator.operation

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object RootOperationSpec : Spek({
    given ("square root operation") {

        on("operate") {
            val operation = OperationFactory.get("sqrt")

            it("should return result of square root of operand") {
                operation.operate(2.0, 0.0) `should equal` 1.4142135623730951
                operation.operate(4.0, 0.0) `should equal` 2.0
            }

            it("should have 1 required operand") {
                operation.requiredOperand `should equal` 1
            }

            it("should return result ignoring second operand") {
                operation.operate(4.0, 3.0) `should equal` 2.0
                operation.operate(4.0, 4.0) `should equal` 2.0
            }
        }
    }
})