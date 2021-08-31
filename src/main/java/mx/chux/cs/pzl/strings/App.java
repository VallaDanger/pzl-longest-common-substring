package mx.chux.cs.pzl.strings;

import java.util.logging.Logger;

public class App {
    
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    
    public static void main( String[] args ) {
        final String lcss = new LongestCommonSubstring("abcde").apply("bd");
        LOGGER.info(lcss);
    }
    
}
