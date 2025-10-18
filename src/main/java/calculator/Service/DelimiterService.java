package calculator.Service;

import calculator.Model.DelimiterModel;

public class DelimiterService {
    DelimiterModel delimiterModel;


    public DelimiterService(DelimiterModel delimiterModel) {
        this.delimiterModel = delimiterModel;
    }

    public String extractAndAddCustomDelimiter(String str) {
        String CustomDelimiter = str.substring(2, 3);
        delimiterModel.addCustomDelimiter(CustomDelimiter);
        return str.substring(4);
    }

}
