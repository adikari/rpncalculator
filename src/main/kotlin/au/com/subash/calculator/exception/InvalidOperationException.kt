package au.com.subash.calculator.exception

/**
 * Expression thrown when invalid operation is performed
 *
 * @property message Error message
 * @constructor Default constructor
 */
class InvalidOperationException(message : String) : Exception(message)
