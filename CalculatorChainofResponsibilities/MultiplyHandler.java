public class MultiplyHandler extends OperationHandler {

    @Override
    public void calculate(double a, char operator, double b) {
        if(operator=='*'){
            double result = a*b;
            System.out.println(result + " - calculated in MultiplyHandler");
        }
        else{
            operationHandler.calculate(a, operator, b);
        }
    }
}

