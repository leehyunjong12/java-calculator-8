package calculator.Service;


import java.util.List;

// 전체 흐름 조합 (Facade 역할)
public class CalculatorService {
    ValidatorService validatorService;
    DelimiterService delimiterService;
    SplitterService splitterService;

    public CalculatorService(ValidatorService validatorService, DelimiterService delimiterService, SplitterService splitterService) {
        this.validatorService = validatorService;
        this.delimiterService = delimiterService;
        this.splitterService = splitterService;
    }

    public String calculate(String str) {
        if (str.isEmpty()) {
            return "0";
        }
        String numbersPart;
        if (str.startsWith("//") && str.contains("\\n")) {
            validatorService.validateInput(str, true);
            numbersPart = delimiterService.extractAndAddCustomDelimiter(str);
        } else {
            validatorService.validateInput(str, false);
            numbersPart = str;
        }
        String[] splitString = splitterService.splitByDelimiters(numbersPart);
        return null;
    }
}
