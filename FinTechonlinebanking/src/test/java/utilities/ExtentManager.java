package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static void startExtent() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static void endExtent() {
        if (extent != null) {
            extent.flush();
        }
    }

}
