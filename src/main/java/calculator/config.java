package calculator;

import calculator.Controller.CalculatorController;
import calculator.Service.CalculatorService;
import calculator.Service.ValidatorService;
import calculator.View.UserView;

public class config {

    public CalculatorController calculatorController(){
        return new CalculatorController(userview());
    }
    public UserView userview(){
        return new UserView();
    }

}
