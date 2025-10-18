package calculator.Model;

import java.util.ArrayList;
import java.util.List;

public class DelimiterModel {
    private final List<String> delimiters;

    public DelimiterModel() {
        this.delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");
    }
    public List<String> getAllDelimiters() {
        return delimiters;
    }
    public void addCustomDelimiter(String delimiter) {
        if (!delimiters.contains(delimiter)) {
            delimiters.add(delimiter);
        } else {
            throw new IllegalArgumentException("이미 존재하는 구분자 입니다.");
        }
    }
}
