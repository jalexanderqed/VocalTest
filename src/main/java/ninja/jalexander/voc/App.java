package ninja.jalexander.voc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import static spark.Spark.*;

import com.machinepublishers.jbrowserdriver.Timezone;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;

public class App {
    public static void main(String[] args) {
        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.AMERICA_NEWYORK).build());

        driver.get("http://jalexander.ninja");

        System.out.println(driver.getPageSource());
        System.out.println(driver.getStatusCode());
        System.out.println(driver.getTitle());

        driver.quit();

        if(true) return;

        URL testUrl = App.class.getResource("/data/test.txt");
        if (testUrl == null) {
            System.err.println("Could not read from test.txt");
            System.exit(1);
        }

        File testFile = new File(testUrl.getFile());

        try {
            Files.lines(testFile.toPath()).forEach((String str) -> {
                System.err.println(str);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        port(8080);
        get("/hello", (req, res) -> "Hello World");
    }
}
