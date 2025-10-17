package calculator.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService;
    ValidatorService validatorService;
    @BeforeEach
    void setUp(){
        validatorService = new ValidatorService();
        calculatorService = new CalculatorService(validatorService);
    }
    @Test
    @DisplayName("입력값이 없을때 0 반환")
    void Calculate_zero_return(){
        String input = ""; // 빈 문자열
        String result = calculatorService.calculate(input);
        Assertions.assertThat(result).isEqualTo("0");
    }
}
