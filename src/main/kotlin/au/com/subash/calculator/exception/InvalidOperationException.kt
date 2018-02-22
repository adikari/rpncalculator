package au.com.subash.calculator.exception

class InvalidOperationException(message : String) : Exception(message) {
    constructor() : this("Invalid operation!!")
}
