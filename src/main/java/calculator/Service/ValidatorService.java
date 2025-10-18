package calculator.Service;

public class ValidatorService {
    public void validate(String str,Boolean hasCustomDelimiter){
        validateBlank(str);
        if(hasCustomDelimiter){
            validateWithCustomDelimiter(str);
        }else{
            validateWithoutCustomDelimiter(str);
        }
    }
    public void validateBlank(String str){
        if(!str.strip().equals(str)){
            throw new IllegalArgumentException("공백을 포함하고 있습니다.");
        }
        String[] tokens = str.split(" ");
        if(tokens.length != 1){
            throw new IllegalArgumentException("공백을 포함하고 있습니다.");
        }
    }
    public void validateWithCustomDelimiter(String str){
        int suffixIndex = str.indexOf("\n");
        String customDelimiter = str.substring(2, suffixIndex);
        if(customDelimiter.length() != 1){
            throw new IllegalArgumentException("커스텀 구분자 크기가 1이 아닙니다.");
        }else if(customDelimiter.equals(".")){
            throw new IllegalArgumentException("\".\"은 커스텀 구분자로 사용할 수 없습니다.");
        }
        if(Character.isDigit(customDelimiter.charAt(0))){
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }
    public void validateWithoutCustomDelimiter(String str){
        if(!Character.isDigit(str.charAt(0))){
            throw new IllegalArgumentException("입력은 숫자로 시작해야 합니다.");
        }
    }


}
