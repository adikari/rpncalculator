package au.com.subash.calculator

import au.com.subash.calculator.operation.EXIT
import au.com.subash.calculator.view.View
import java.util.Scanner

/**
 * Calculator Application
 *
 * @property calculator Instance of Calculator
 * @property view       Instance of View
 * @constructor Default constructor
 */
class CalculatorApp(private val calculator : Calculator, private val view : View) : Runnable {

    /**
     * Scanner for user input
     */
    private val scanner = Scanner(System.`in`)

    /**
     * Flag to indicate runnable is running
     */
    private var running = false

    /**
     * Run the application until user exits
     *
     * {@inheritDoc}
     */
    override fun run() {
        running = true
        view.render()

        while (running) {
            val input = scanner.nextLine()

            if (input == EXIT) {
                stop(); continue
            }

            try {
                calculator.calculate(input)
                calculator.notifyObservers()
            } catch (e : Exception) {
                calculator.notifyObservers(e)
            }

        }
    }

    /**
     * Stop the runnable. Dispose resources
     */
    private fun stop() {
        scanner.close()
        running = false
        view.dispose()
    }
}
