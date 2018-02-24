package au.com.subash.calculator.operation

import au.com.subash.calculator.exception.NoSuchOperatorException
import au.com.subash.calculator.operation.base.Operation

class OperationFactory {

    companion object {

        /**
         * Get instance of Operation
         *
         * @param symbol        Symbol of operation
         *
         * @return Operation
         * @throws NoSuchOperatorException
         */
        fun get(symbol: String): Operation {

            return when (symbol) {
                PLUS -> AddOperation()
                MINUS -> SubtractOperation()
                DIVIDE -> DivideOperation()
                MULTIPLY -> MultiplyOperation()
                POWER -> PowerOperation()
                ROOT -> RootOperation()
                else -> throw NoSuchOperatorException(symbol)
            }
        }
    }

}
