package calculator.Service;

import calculator.Model.DelimiterModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterServiceTest {
    DelimiterModel delimiterModel;
    DelimiterService delimiterService;

    @BeforeEach
    void setUp() {
        delimiterModel = new DelimiterModel();
        delimiterService = new DelimiterService(delimiterModel);
    }

    @Test
    @DisplayName("커스텀 구분자가 잘 저장되었는지 확인")
    void addCustomDelimiter() {
        String input = "//;\\n1;2;3";
        delimiterService.extractAndAddCustomDelimiter(input);
        Assertions.assertThat(delimiterModel.getAllDelimiters()).contains(";");
    }

    @Test
    @DisplayName("커스텀 구분자로 기본 구분자가 들어왔을 때 예외 처리")
    void addCustomDelimiter_2() {
        String input = "//,\\n1,2,3"; // ","는 이미 기본 구분자
        Assertions.assertThatThrownBy(() -> delimiterService.extractAndAddCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 구분자 입니다.");
    }
    @Test
    @DisplayName("앞 부분을 제외한 숫자 파트만 잘 리턴하는지 확인")
    void addCustomDelimiter_3() {
        String input = "//;\\n1;2;3";
        Assertions.assertThat(delimiterService.extractAndAddCustomDelimiter(input)).isEqualTo("1;2;3");
    }
}
