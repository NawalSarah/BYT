
public class Calculator {
    public static PlusHandler plusHandler = new PlusHandler();
    public static MinusHandler minusHandler = new MinusHandler();
    public static MultiplyHandler multiplyHandler = new MultiplyHandler();
    public static DivideHandler divideHandler = new DivideHandler();

    static {
        plusHandler.nextHandler(minusHandler);
        minusHandler.nextHandler(multiplyHandler);
        multiplyHandler.nextHandler(divideHandler);
    }

    public void calculate (double a, char operator, double b){
        plusHandler.calculate(a, operator, b);
    }
}

