package au.com.subash.calculator.view

import au.com.subash.calculator.Calculator
import java.text.DecimalFormat
import java.util.Stack
import java.util.Observer
import java.util.Observable

/**
 * Implementation of Console View
 */
class ConsoleView : View, Observer {

    /* {@inheritDoc} */
    override fun update(o: Observable, arg: Any?) {
        if (o !is Calculator) return

        if (arg is Exception) displayError(arg)

        displayResult(o.operandStack)
    }

    /* {@inheritDoc} */
    override fun render() {
        println("************ Welcome to RPN calculator ************")
        println("******* Type RPN Expression and press Enter *******")
    }

    /* {@inheritDoc} */
    override fun displayResult(stack: Stack<Double>) {
        println("Stack: " + stack.joinToString(" ") {
            DecimalFormat("#.##########").format(it)
        })
    }

    /* {@inheritDoc} */
    override fun displayError(e: Exception) {
        println("Error: ${e.message ?: "Unknown error"}!!")
    }

    /* {@inheritDoc} */
    override fun dispose() {
        println("Bye Bye!!")
    }
}
