package au.com.subash.calculator

class Calculator {

    private val QUIT = "quit"
    private val CLEAR = "clear"

    fun evaluate(input : String) {
        if (input == QUIT) {
            quit()
        }

        println(input)
    }

    /**
     * Stop the calculator application
     */
    private fun quit() {
        System.exit(0)
    }
}