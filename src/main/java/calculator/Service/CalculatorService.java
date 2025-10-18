package calculator.Service;


// 전체 흐름 조합 (Facade 역할)
public class CalculatorService {
    ValidatorService validatorService;
    DelimiterService delimiterService;
    SplitterService splitterService;
    NumberConverterService numberConverterService;
    ArraySumService arraySumService;

    public CalculatorService(ValidatorService validatorService, DelimiterService delimiterService
            , SplitterService splitterService, NumberConverterService numberConverterService, ArraySumService arraySumService) {
        this.validatorService = validatorService;
        this.delimiterService = delimiterService;
        this.splitterService = splitterService;
        this.numberConverterService = numberConverterService;
        this.arraySumService = arraySumService;
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
        validatorService.validateStringArray(splitString);
        double[] splitDouble = numberConverterService.convertToNumberArray(splitString);
        validatorService.validateNumArray(splitDouble);
        int sumResult = arraySumService.addDoubleArray(splitDouble);
        return null;

    }
}
