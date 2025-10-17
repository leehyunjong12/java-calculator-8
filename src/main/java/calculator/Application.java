package calculator;

import calculator.Controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        config config = new config();
        CalculatorController calculatorController = config.calculatorController();
        calculatorController.run();
    }
}
