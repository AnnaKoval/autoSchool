package logging;

import org.apache.log4j.Logger;

public class Demo {
    private static final Logger logger = Logger.getLogger(Demo.class);

    public static void main(String[] args) {
        LogicClass logicClass=new LogicClass();
        logicClass.methodPublic();

        logger.info("Try-catch block of code");
        try {
            int zero = 5 / 0;
        } catch (ArithmeticException ex) {
            logger.error("Exception message");
        }
    }
}
