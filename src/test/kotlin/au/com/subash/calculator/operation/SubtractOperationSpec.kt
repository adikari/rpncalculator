package au.com.subash.calculator.operation

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object SubtractOperationSpec : Spek({
    given ("subtract operation") {

        on("operate") {
            val operation = OperationFactory.get("-")

            it("should return result of subtracting first operand from second operand") {
                operation.operate(1.0, 2.0) `should equal` 1.0
                operation.operate(2.11111111111, 4.0) `should equal` 1.88888888889
                operation.operate(2.11111111111, 4.1233393) `should equal` 2.0122281888899995
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

    }
})