import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;

public class ExceptionLogger {
    private static final String LOG_FILE_PATH = "exceptions.log";

    /*
    exceptions to handle:

    MalformedURLException
    IOException
     */

    public static void log(Exception e) {
        String message = createLogMessage(e);
        System.err.println(message);
        writeToLogFile(message);
    }

    private static String createLogMessage(Exception e) {
        StringBuilder message = new StringBuilder();
        message.append("[").append(LocalDateTime.now()).append("] ");
        message.append("Exception: ");

        if (e instanceof MalformedURLException) {
            message.append("IOException - ");
        } else if (e instanceof IOException) { // todo: manage exceptions
            message.append("MalformedURLException - ");
        }
        // todo: add all possibly occurring exceptions

        message.append(e.getMessage());
        return message.toString();
    }

    private static void writeToLogFile(String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println("Could not write to file " + LOG_FILE_PATH + ": " + e.getMessage());
        }
    }
}


