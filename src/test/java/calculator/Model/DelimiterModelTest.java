package calculator.Model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DelimiterModelTest {

    private DelimiterModel model;

    @BeforeEach
    void setUp() {
        model = new DelimiterModel();
    }

    @Test
    @DisplayName("기본 구분자가 포함되어 있는지 확인")
    void testDefaultDelimiters() {
        Assertions.assertThat(model.getAllDelimiters()).contains(",", ":");
    }
    
    @Test
    @DisplayName("커스텀 구분자 추가")
    void testAddCustomDelimiter() {
        model.addCustomDelimiter(";");
        Assertions.assertThat(model.getAllDelimiters()).contains(";");
    }

    @Test
    @DisplayName("중복된 커스텀 구분자 추가 시 예외 발생")
    void testAddDuplicateDelimiter() {
        Assertions.assertThatThrownBy(() -> model.addCustomDelimiter(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 구분자 입니다.");
    }
}
