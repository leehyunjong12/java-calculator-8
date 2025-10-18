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
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 포함하고 있습니다.");
    }

    @Test
    @DisplayName("가운데 공백 테스트")
    void validateBlank_2() {
        String input = "123 456";
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 포함하고 있습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자 크기가 1이 아닐 때 예외")
    void validateWithCustomDelimiter_1() {
        String input = "//$%\\n3$4$5";
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자 크기가 1이 아닙니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 .일 때 예외")
    void validateWithCustomDelimiter_2() {
        String input = "//.\\n3.4.5";
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("\".\"은 커스텀 구분자로 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자일 때 예외")
    void validateWithCustomDelimiter_3() {
        String input = "//8\\n3$4$5$";
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 숫자가 될 수 없습니다.");
    }

    @Test
    @DisplayName("커스텀 구분자가 없을때, 숫자로 시작하지 않으면 예외")
    void validateWithoutCustomDelimiter() {
        String input = "$3$4$5$";
        Assertions.assertThatThrownBy(() -> validatorService.validateInput(input,false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 숫자로 시작해야 합니다.");
    }
    @Test
    @DisplayName("분리한 문자열에 비어있는게 있으면 예외")
    void validateBlankInArray(){
        String[] splitInput = {"4", "6", "8","", "10", "4"};
        Assertions.assertThatThrownBy(() -> validatorService.validateArray(splitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비어있는 문자열이 있습니다.");
    }
}
