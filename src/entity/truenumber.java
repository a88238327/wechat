package entity;

public class truenumber {
	public static boolean isNumber(String str) { 
		for (int i = str.length();--i>=0;)
		{
		if (!Character.isDigit(str.charAt(i)))
		{
		return false;
		}
		}
		return true;
		}
}
