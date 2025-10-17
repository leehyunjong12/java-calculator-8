package calculator.Service;

public class ValidatorService {
    public Boolean validate(String str){
        validateBlank(str);

        return null;
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

}
