package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class UndoCommandSpec : Spek({

    given ("an undo command") {

        on ("init") {

            it ("should have operation with at least 1 operand") {
                try {
                    UndoCommand(Operation.getOperator("clear"), 2.0)
                    fail("Should throw Invalid operation exception")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Operation must have at least 1 required operand!!"
                }
            }
        }

        on ("get reverse expression") {
            it ("should return opposite operator if required operand is 1") {
                val undoCommand = UndoCommand(Operation.getOperator("sqrt"), 3.0)

                undoCommand.reverseExpression() `should equal` "pow"
            }

            it ("should return opposite RPN expression if required operand is 2") {
                val undoCommand = UndoCommand(Operation.getOperator("+"), 3.0)

                undoCommand.reverseExpression() `should equal` "3.0 - 3.0"
            }
        }
    }


})