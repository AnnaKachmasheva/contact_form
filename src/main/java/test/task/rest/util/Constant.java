package test.task.rest.util;

public class Constant {
    public static final int MIN_LENGTH = 0;

    public static final int MIN_LENGTH_PASSWORD = 5;
    public static final int MAX_LENGTH = 5000;
    public static final String PATTERN_ALPHA = "^[a-zA-Z]+$";
    public static final String PATTERN_NUMERIC = "^[0-9]+$";
    public static final String PATTERN_ALPHANUMERIC = "^[a-zA-Z0-9]+$";
    public static final String PATTERN_EMAIL = "^(.+)@(\\\\S+)$";
    public static final String PATTERN_PHONE = "^\\\\d{9}$";

    private Constant() {
        throw new AssertionError();
    }

}
