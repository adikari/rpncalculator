package au.com.subash.calculator.view

import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.util.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ConsoleViewSpec : Spek ({
    given ("console view") {
        val outContent = ByteArrayOutputStream()
        val view = ConsoleView()

        beforeEachTest { System.setOut(PrintStream(outContent)) }

        afterEachTest { System.setOut(System.out) }

        on ("display result") {

            it ("should display the stack with correctly formatted output") {
                val stack = Stack<Double>()
                stack.push(2.0)
                stack.push(3.0)

                view.displayResult(stack)

                outContent.toString() `should equal` "Stack: 2 3\n"
                outContent.reset()
            }

            it ("should display number formatted up to 10 decimal points") {
                val stack = Stack<Double>()
                stack.push(2.111111111111)
                stack.push(3.11111111111111111)

                view.displayResult(stack)

                outContent.toString() `should equal` "Stack: 2.1111111111 3.1111111111\n"
                outContent.reset()
            }
        }

        on ("dispose") {
            it ("should print bye on screen") {
                view.dispose()
                outContent.toString() `should equal` "Bye Bye!!\n"
                outContent.reset()
            }
        }

        on ("display error") {
            it ("should display error message") {
                view.displayError(Exception("Exception occurred"))

                outContent.toString() `should equal` "Error: Exception occurred!!\n"
                outContent.reset()

                view.displayError(Exception())

                outContent.toString() `should equal` "Error: Unknown error!!\n"
                outContent.reset()
            }
        }
    }
})