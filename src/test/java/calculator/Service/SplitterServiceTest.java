package calculator.Service;

import calculator.Model.DelimiterModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitterServiceTest {
    SplitterService splitterService;
    DelimiterModel delimiterModel;

    @BeforeEach
    void setUp() {
        delimiterModel = new DelimiterModel();
        splitterService = new SplitterService(delimiterModel);
    }

    @Test
    @DisplayName("기본 구분자들과 특수 구분자로 잘 나누어지는지 확인")
    void splitByDelimiters() {
        delimiterModel.addCustomDelimiter(")");
        String input = "4:6,8)10)4";
        String[] splitInput = {"4", "6", "8", "10", "4"};
        Assertions.assertThat(splitterService.splitByDelimiters(input)).isEqualTo(splitInput);
    }
}
