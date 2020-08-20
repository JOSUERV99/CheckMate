package validations;

public class RegexPatterns {

	public static String EMAILL = 
		"^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	
	public static String PHONE_NUMBER = 
		"^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
	
	public static String NAME =
		"^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
	
	public static String COSTARICAN_ID =
		"/^[1-9]-?\\d{4}-?\\d{4}$/";
	
	public static String MONEY =
		"^-?(?:0|[1-9]\\d{0,2}(?:,?\\d{3})*)(?:\\.\\d+)?$";	
}
