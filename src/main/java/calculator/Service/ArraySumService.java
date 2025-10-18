package calculator.Service;

public class ArraySumService {
    public int addDoubleArray(double[] arr) {
        double sum = 0.0;
        for( double val: arr){
            sum += val;
        }
        return (int) Math.round(sum);
    }
}
