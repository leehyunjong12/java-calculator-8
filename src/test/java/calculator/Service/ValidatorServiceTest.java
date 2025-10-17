package calculator.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorServiceTest {

    private ValidatorService validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
    }

    @Test
    @DisplayName("앞뒤 공백 테스트")
    void validateBlank_1() {
        String input = " 123,456 ";
        Assertions.assertThatThrownBy(() -> validatorService.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 포함하고 있습니다.");
    }

    @Test
    @DisplayName("가운데 공백 테스트")
    void validateBlank_2() {
        String input = "123 456";
        Assertions.assertThatThrownBy(() -> validatorService.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 포함하고 있습니다.");
    }
}
