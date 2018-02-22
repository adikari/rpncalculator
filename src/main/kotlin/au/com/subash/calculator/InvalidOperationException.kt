package au.com.subash.calculator

class InvalidOperationException(message : String) : Exception(message) {
    constructor() : this("Invalid operation!!")
}
