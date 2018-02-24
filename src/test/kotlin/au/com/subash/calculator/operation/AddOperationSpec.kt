package au.com.subash.calculator.operation

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object AddOperationSpec : Spek({
    given ("add operation") {

        on("operate") {
            val operation = OperationFactory.get("+")

            it("should return result of adding left operand to right operand") {
                operation.operate(2.0, 3.0) `should equal` 5.0
                operation.operate(2.5, 3.5) `should equal` 6.0
                operation.operate(2.5, 4.0) `should equal` 6.5
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

    }
})