package au.com.subash.calculator

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val calculator = Calculator()

    while (scanner.hasNextLine()) {
        val input = scanner.nextLine()
        calculator.evaluate(input)
    }
}

