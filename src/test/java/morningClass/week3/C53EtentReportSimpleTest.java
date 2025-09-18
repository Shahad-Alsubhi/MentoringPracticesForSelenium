package morningClass.week3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class C53EtentReportSimpleTest {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    @BeforeAll
    static void reportSetup() {
        // Step 1: Specify where the report file will be created
        sparkReporter = new ExtentSparkReporter("./test-output/extentReport.html");

        // Step 2: Set report title and document name
        sparkReporter.config().setReportName("My First Report");
        sparkReporter.config().setDocumentTitle("My First Document");

        // Step 3: Create ExtentReports object and attach the reporter

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);


        // Step 4: Add system information (optional)
        extent.setSystemInfo("Tester", "user.name");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterAll
    static void tearDown() {
        // Step 5: Write the report to the specified file
        extent.flush();
    }

    @Test
    void test() {
        test = extent.createTest("My First Test", "This is my first test with extent report");
        test.info("This is info message");
        test.pass("This is passed message");
        test.fail("This is failed message");
        test.skip("This is skipped message");


    }


}
