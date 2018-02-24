package au.com.subash.calculator.view

import java.util.Stack

interface View {

    /**
     * Render the view and its components
     */
    fun render()

    /**
     * Display error in view
     *
     * @param e Exception
     */
    fun displayError(e : Exception)

    /**
     * Display result of calculation
     *
     * @param stack Stack of current operands
     */
    fun displayResult(stack : Stack<Double>)

    /**
     * Dispose view
     */
    fun dispose()
}