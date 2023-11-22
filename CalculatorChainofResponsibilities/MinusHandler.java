public class MinusHandler extends OperationHandler {

    @Override
    public void calculate(double a, char operator, double b) {
        if(operator=='-'){
            double result = a-b;
            System.out.println(result + " - calculated in MinusHandler");
        }
        else{
            operationHandler.calculate(a, operator, b);
        }
    }
}