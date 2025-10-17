package calculator.Controller;

import calculator.Service.CalculatorService;
import calculator.View.UserView;

public class CalculatorController {
    UserView userView;

    public CalculatorController(UserView userView) {
        this.userView = userView;
    }
    public void run(){
        try{
        String InStr = userView.readUserInput();

    }  catch (Exception e){
            userView.printError(e.getMessage());
        }
    }
}
