package calculator.Service;

import calculator.Model.DelimiterModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;
    ValidatorService validatorService;
    DelimiterService delimiterService;
    SplitterService splitterService;
    DelimiterModel delimiterModel;
    NumberConverterService numberConverterService;
    ArraySumService adderService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
        delimiterModel = new DelimiterModel();
        delimiterService = new DelimiterService(delimiterModel);
        splitterService = new SplitterService(delimiterModel);
        numberConverterService = new NumberConverterService();
        adderService = new ArraySumService();
        calculatorService = new CalculatorService(validatorService, delimiterService
                , splitterService, numberConverterService, adderService);
    }

    @Test
    @DisplayName("입력값이 없을때 0 반환")
    void Calculate_zero_return() {
        String input = ""; // 빈 문자열
        int result = calculatorService.calculate(input);
        Assertions.assertThat(result).isEqualTo(0);
    }
}
