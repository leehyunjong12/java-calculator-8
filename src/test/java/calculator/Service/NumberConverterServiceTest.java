package calculator.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberConverterServiceTest {

    NumberConverterService numberConverterService;

    @BeforeEach
    void setUp(){
        numberConverterService = new NumberConverterService();
    }

    @Test
    @DisplayName("문자열 배열을 double 배열로 변환 확인")
    void convertToNumberArray(){
        String[] input = {"1.2", "3.4", "5.6"};
        double[] expected = {1.2, 3.4, 5.6};
        Assertions.assertThat(numberConverterService.convertToNumberArray(input)).isEqualTo(expected);
    }
}
