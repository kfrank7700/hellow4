package utils;

/**
 * Created by fkitema on 10/24/2017.
 */

public class ExceptionMailer {
    public static void send(Throwable e) {
        System.out.println("Sending email containing exception " + e);
    }
}