import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger instance;
    private final SimpleDateFormat dateFormat;
    protected int num = 1;

    private Logger() {
        dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    }

    public void log(String msg) {
        System.out.println("[" + dateFormat.format(new Date()) + " " + num++ + "] " + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
