package calculator.Service;

public class NumberConverterService {
    
    public double[] convertToNumberArray(String[] arr) {
        double[] numberArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numberArr[i] = Double.parseDouble(arr[i]);
        }
        return numberArr;

    }
}
