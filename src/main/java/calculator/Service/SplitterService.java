package calculator.Service;

import calculator.Model.DelimiterModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SplitterService {

    DelimiterModel delimiterModel;

    public SplitterService(DelimiterModel delimiterModel) {
        this.delimiterModel = delimiterModel;
    }

    public String[] splitByDelimiters(String str) {
        List<String> delimiters = delimiterModel.getAllDelimiters();
        StringBuilder regexBuilder = new StringBuilder();
        for (int i = 0; i < delimiters.size(); i++) {
            regexBuilder.append(Pattern.quote(delimiters.get(i)));
            if (i != delimiters.size() - 1) {
                regexBuilder.append("|");
            }
        }
        String regex = regexBuilder.toString();
        // "5,5,5,"일 경우 마지막 값 ""도 분리하기 위해 limit 인자 -1 사용
        return str.split(regex, -1);

    }

}