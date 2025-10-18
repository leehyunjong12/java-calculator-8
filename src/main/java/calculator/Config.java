package calculator;

import calculator.Controller.CalculatorController;
import calculator.Model.DelimiterModel;
import calculator.Service.*;
import calculator.View.UserView;

public class Config {

    private final DelimiterModel delimiterModel = new DelimiterModel();

    public CalculatorController calculatorController() {
        return new CalculatorController(userview(), calculatorService());
    }

    public UserView userview() {
        return new UserView();
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(validatorService(), delimiterService()
                , splitterService(),numberConverterService());
    }

    public ValidatorService validatorService() {
        return new ValidatorService();
    }

    public DelimiterService delimiterService() {
        return new DelimiterService(delimiterModel);
    }

    public SplitterService splitterService() {
        return new SplitterService(delimiterModel);
    }
    public NumberConverterService numberConverterService() {
        return new NumberConverterService();
    }
}
