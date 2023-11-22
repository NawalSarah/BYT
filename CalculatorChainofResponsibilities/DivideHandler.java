public class DivideHandler extends OperationHandler {

    @Override
    public void calculate(double a, char operator, double b) {
        if(operator=='/'){
            if(b!=0) {
                double result = a / b;
                System.out.println(result  + " - calculated in DivideHandler");
            }
            else {
                System.out.println("The denominator is equal to 0, impossible to calculate");
            }
        }
    }
}