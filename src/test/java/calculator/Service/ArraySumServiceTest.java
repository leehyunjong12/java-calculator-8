package calculator.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArraySumServiceTest {
    ArraySumService arraySumService;

    @BeforeEach
    void setUp() {
        arraySumService = new ArraySumService();
    }

    @Test
    @DisplayName("일반 정수값이 들어왔을 때")
    void addDoubleArray() {
        double[] input = {1.0, 3.0, 5.0};
        Assertions.assertThat(arraySumService.addDoubleArray(input)).isEqualTo(9);
    }
    
    @Test
    @DisplayName("일반 정수값이 들어왔을 때 반올림 확인(올림처리)")
    void addDoubleArray_2() {
        double[] input = {1.0, 3.3, 5.5};
        Assertions.assertThat(arraySumService.addDoubleArray(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("실수값이 들어왔을 때 반올림 확인(내림처리)")
    void addDoubleArray_3() {
        double[] input = {1.0, 3.1, 5.3};
        Assertions.assertThat(arraySumService.addDoubleArray(input)).isEqualTo(9);
    }

}
