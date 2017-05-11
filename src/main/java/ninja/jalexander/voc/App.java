package ninja.jalexander.voc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        URL testUrl = App.class.getResource("/data/test.txt");
        if(testUrl == null){
            System.out.println("Could not read from test.txt");
            System.exit(1);
        }

        File testFile = new File(testUrl.getFile());

        try{
            Files.lines(testFile.toPath()).forEach((String str) ->{
                System.out.println(str);
            });
        }
        catch(IOException e){
            e.printStackTrace();
        }

        port(8080);
        get("/hello", (req, res) -> "Hello World");
    }
}
