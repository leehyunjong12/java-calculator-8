package calculator.Service;

import calculator.Model.DelimiterModel;

public class DelimiterService {
    DelimiterModel delimiterModel;


    public DelimiterService(DelimiterModel delimiterModel) {
        this.delimiterModel = delimiterModel;
    }

    public String extractAndAddCustomDelimiter(String str) {
        String customDelimiter = str.substring(2, 3);
        delimiterModel.addCustomDelimiter(customDelimiter);
        return str.substring(5);
    }

}
