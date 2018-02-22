package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import java.util.Scanner

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val calculator = Calculator()

    val quit = "quit"

    while (scanner.hasNextLine()) {
        val input = scanner.nextLine()

        if (input == quit) {
            scanner.close()
            System.exit(0)
        }

        try {
            calculator.evaluate(input)

            println("Stack: " + calculator.operandStack.joinToString(", "))
        } catch (e : InvalidOperationException) {
            println("Operation Error: ${e.message}!!")
        } catch (e : Exception) {
            println("Error: ${e.message ?: "Unknown error"}!!")
        }
    }
}

