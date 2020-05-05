package springxiaobo.aop.serviveImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import springxiaobo.aop.service.IArithmeticCalculatorService;

@Service
public class ArithmeticCalculatorServiceImpl implements IArithmeticCalculatorService {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }

    @SpringBootApplication
    public static class DemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
        }

    }
}
