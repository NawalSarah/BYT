public abstract class OperationHandler {
    OperationHandler operationHandler;

    public void nextHandler(OperationHandler operationHandler){
        this.operationHandler = operationHandler;
    }

    public abstract void calculate(double a, char operator, double b);
}

