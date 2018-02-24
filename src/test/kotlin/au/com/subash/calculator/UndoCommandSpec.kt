package au.com.subash.calculator

import au.com.subash.calculator.operation.OperationFactory
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class UndoCommandSpec : Spek({

    given ("an undo command") {

        on ("get reverse expression") {
            it ("should return opposite operator if required operand is 1") {
                val undoCommand = UndoCommand(OperationFactory.get("sqrt"), 3.0)

                undoCommand.reverseExpression() `should equal` "pow"
            }

            it ("should return opposite RPN expression if required operand is 2") {
                val undoCommand = UndoCommand(OperationFactory.get("+"), 3.0)

                undoCommand.reverseExpression() `should equal` "3.0 - 3.0"
            }
        }
    }
})