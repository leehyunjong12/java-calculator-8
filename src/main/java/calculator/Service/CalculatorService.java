package calculator.Service;


// 전체 흐름 조합 (Facade 역할)
public class CalculatorService {
    ValidatorService validatorService;

    public CalculatorService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public String calculate(String str) {
        if (str.isEmpty()) {
            return "0";
        }
        if (str.startsWith("//") && str.contains("\n")) {
            validatorService.validate(str, true);
        }
        validatorService.validate(str, false);
        return null;
    }
}
