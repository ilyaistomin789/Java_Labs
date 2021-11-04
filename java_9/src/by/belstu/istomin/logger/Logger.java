package by.belstu.istomin.logger;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    public static void info(String message) {
        try (FileWriter writer = new FileWriter("src/logs/stdout/log.txt", true)) {
            writer
                    .append(formatter.format(new Date()))
                    .append(" ")
                    .append(message)
                    .append(String.valueOf('\n'));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}