package calculator;

import calculator.Controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        CalculatorController calculatorController = config.calculatorController();
        calculatorController.run();
    }
}
