package au.com.subash.calculator

class Calculator : Runnable {

    private val QUIT = "quit"
    private val CLEAR = "clear"

    private var running : Boolean = false;
    private var count : Int = 0;

    /**
     * Run the calculator application
     */
    override fun run() {
        running = true

        while(running) {
            println("running..")
            count++

            if (count >= 10) {
                stop()
            }
        }
    }

    /**
     * Stop the calculator application
     */
    private fun stop() {
        running = false
    }
}