package au.com.subash.calculator

import java.util.*

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

        calculator.evaluate(input)

        println(calculator.operandStack.peek().toString())
    }
}

