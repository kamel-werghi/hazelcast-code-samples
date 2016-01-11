import java.io.Serializable;
import java.util.concurrent.Callable;

class FibonacciCallable implements Callable<Long>, Serializable {

    private final int input;

    FibonacciCallable(int input) {
        this.input = input;
    }

    @Override
    public Long call() {
        return calculate(input);
    }

    private long calculate(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}
