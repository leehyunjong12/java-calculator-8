
package calculator.View;
import camp.nextstep.edu.missionutils.Console;
public class UserView {
    public String readUserInput() {
        System.out.print("덧셈할 문자열을 입력하세요: ");
        return Console.readLine();
    }
    public void displayResult(int result){
        System.out.println("결과 : "+result);
    }
}
