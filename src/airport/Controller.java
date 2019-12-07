/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Controller {

    private Logger logger = Logger.getLogger("Airport.log");
    private FileHandler fh = null;

    public Controller() {
        try {
            fh = new FileHandler("Airport.log");
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    public void doLogging(String text) throws IOException {
        logger.info(text);
        logger.setUseParentHandlers(false);
    }
}   

    