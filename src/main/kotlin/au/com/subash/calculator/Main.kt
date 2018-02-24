package au.com.subash.calculator

import au.com.subash.calculator.view.ConsoleView

/**
 * Application entry point
 *
 * @param args Arguments passed to application
 */
fun main(args: Array<String>) {
    val view = ConsoleView()

    val calculator = Calculator()
    calculator.addObserver(view)

    Thread(CalculatorApp(calculator, view)).start()
}

