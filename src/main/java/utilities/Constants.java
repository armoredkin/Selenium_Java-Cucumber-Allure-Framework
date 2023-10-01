package utilities;

public class Constants {

    public static final String PROPERTYFILE="src/main/resources/constants.properties";
    public int ten = 10;
    public static final int PAGELOAD_WAIT_DURATION= 30000;
    public static final String DEMOBLAZE = JavaHelpers.getPropertyValue(PROPERTYFILE,"demoblaze_url");
    public static final String USERNAME = JavaHelpers.getPropertyValue(PROPERTYFILE,"username");
    public static final String PASSWORD = JavaHelpers.getPropertyValue(PROPERTYFILE,"password");


}
