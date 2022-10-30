package core.logging.concretes;

import core.logging.abstracts.Logger;

public class EmailLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("e-postaya loglandı: " + data);
    }
}
