package calculator.Controller;

import calculator.Service.CalculatorService;
import calculator.View.UserView;

public class CalculatorController {
    UserView userView;
    CalculatorService calculatorService;

    public CalculatorController(UserView userView, CalculatorService calculatorService) {
        this.userView = userView;
        this.calculatorService = calculatorService;
    }


    public void run() {
        String InStr = userView.readUserInput();
        int result = calculatorService.calculate(InStr);
        userView.displayResult(result);
    }
}