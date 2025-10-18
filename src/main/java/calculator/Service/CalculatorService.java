package calculator.Service;


// 전체 흐름 조합 (Facade 역할)
public class CalculatorService {
    ValidatorService validatorService;
    DelimiterService delimiterService;

    public CalculatorService(ValidatorService validatorService, DelimiterService delimiterService) {
        this.validatorService = validatorService;
        this.delimiterService = delimiterService;
    }

    public String calculate(String str) {
        if (str.isEmpty()) {
            return "0";
        }
        String numbersPart;
        if (str.startsWith("//") && str.contains("\\n")) {
            validatorService.validate(str, true);
            numbersPart = delimiterService.extractAndAddCustomDelimiter(str);
        } else {
            validatorService.validate(str, false);
            numbersPart = str;
        }
        return null;
    }
}
