package finalproject;

import java.time.LocalDateTime;

public class Logger
{
    private static enum LogLevel
    {
        TRACE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        CRIT,
    };
    
    private static void log(LogLevel level, String message)
    {
        String col;
        switch (level)
        {
            case TRACE -> col = "\033[37m";
            case DEBUG -> col = "\033[34m";
            case INFO  -> col = "\033[32m";
            case WARN  -> col = "\033[33m";
            case ERROR -> col = "\033[31m";
            case CRIT  -> col = "\033[35m";
            default    -> col = "\033[0m";
        }
        
        System.out.println(col + "[" + LocalDateTime.now() + "][" + level.name() + "]:\033[0m " + message);
    }
    
    public static void trace(String message)
    {
        log(LogLevel.TRACE, message);
    }
    
    public static void debug(String message)
    {
        log(LogLevel.DEBUG, message);
    }
    
    public static void info(String message)
    {
        log(LogLevel.INFO, message);
    }
    
    public static void warn(String message)
    {
        log(LogLevel.WARN, message);
    }
    
    public static void error(String message)
    {
        log(LogLevel.ERROR, message);
    }
    
    public static void critical(String message)
    {
        log(LogLevel.CRIT, message);
    }
}
