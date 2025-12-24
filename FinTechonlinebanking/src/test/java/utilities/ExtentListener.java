package utilities;

import base.BaseTest;
import org.testng.*;

public class ExtentListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentManager.startExtent();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentManager.endExtent();
    }

    @Override
    public void onTestStart(ITestResult result) {
        BaseTest.test = ExtentManager.getExtent()
                .createTest(result.getMethod().getMethodName());
        System.out.println("===== STARTING TEST: "
                + result.getMethod().getMethodName() + " =====");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest.test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseTest.test.skip("Test Skipped");
    }
    

}
