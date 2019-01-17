package parameter;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class maintest {
    public static void main(String[] args) {
        TestListenerAdapter listener=new TestListenerAdapter();
        TestNG testng=new TestNG();
        testng.setTestClasses(new Class[]{TestService.class});
        testng.addListener(listener);
        testng.run();
    }
}
