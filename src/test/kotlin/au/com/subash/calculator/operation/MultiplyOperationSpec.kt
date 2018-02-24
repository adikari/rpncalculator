package au.com.subash.calculator.operation

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object MultiplyOperationSpec : Spek({
    given ("multiply operation") {

        on("operate") {
            val operation = OperationFactory.get("*")

            it("should return result of multiplying first operand with second operand") {
                operation.operate(2.0, 3.0) `should equal` 6.0
                operation.operate(2.12344, 3.123345) `should equal` 6.6322357068
                operation.operate(3.1233, 23.1233) `should equal` 72.22100289
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

    }
})