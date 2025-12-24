package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	 /**
     * Captures screenshot and returns the saved file path (relative to project root).
     * Example returned path: test-output/screenshots/EmojiFail_2025-12-10_12-40-18.png
     */
    public static String capture(WebDriver driver, String namePrefix) throws IOException {
        // Ensure WebDriver supports screenshots
        if (!(driver instanceof TakesScreenshot)) {
            throw new IllegalArgumentException("Driver does not support screenshots");
        }

        // Create screenshots folder (test-output/screenshots)
        String screenshotsDir = System.getProperty("user.dir") + File.separator + "test-output" 
                                + File.separator + "screenshots";
        Path screenshotsPath = Paths.get(screenshotsDir);
        if (!Files.exists(screenshotsPath)) {
            Files.createDirectories(screenshotsPath);
        }

        // Build file name with timestamp
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(dtf);
        String filename = namePrefix + "_" + timestamp + ".png";
        Path destinationPath = screenshotsPath.resolve(filename);

        // Take screenshot and copy to destination
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(srcFile.toPath(), destinationPath);

        // Return path relative to project root (useful for Extent)
        return "test-output" + File.separator + "screenshots" + File.separator + filename;
    }
	
}
