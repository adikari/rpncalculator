package au.com.subash.calculator.operation

import au.com.subash.calculator.exception.NoSuchOperatorException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


object OperationFactorySpec : Spek({

    given("operation factory") {
        on("get operator") {
            it("should return add operator") {
                (OperationFactory.get("+") is AddOperation) `should be` true
            }

            it("should return subtract operator") {
                (OperationFactory.get("-") is SubtractOperation) `should be` true
            }

            it("should return division operator") {
                (OperationFactory.get("/") is DivideOperation) `should be` true
            }

            it("should return multiply operator") {
                (OperationFactory.get("*") is MultiplyOperation) `should be` true
            }

            it("should return square root operator") {
                (OperationFactory.get("sqrt") is RootOperation) `should be` true
            }

            it("should return power operator") {
                (OperationFactory.get("pow") is PowerOperation) `should be` true
            }

            it("should throw InvalidOperationFactoryException") {
                try {
                    OperationFactory.get(")")
                    fail("Should throw NoSuchOperatorException")
                } catch (e: NoSuchOperatorException) {
                    e.message `should equal` "No such operator )!!"
                }
            }
        }
    }
})