package calculator;

import calculator.Controller.CalculatorController;
import calculator.Service.CalculatorService;
import calculator.Service.ValidatorService;
import calculator.View.UserView;

public class config {

    public CalculatorController calculatorController(){
        return new CalculatorController(userview(),calculatorService());
    }
    public UserView userview(){
        return new UserView();
    }
    public CalculatorService calculatorService(){
        return new CalculatorService(validatorService());
    }
    public ValidatorService validatorService(){
        return new ValidatorService();
    }
}
