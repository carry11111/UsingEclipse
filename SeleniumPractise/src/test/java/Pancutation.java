
public class Pancutation {
	
	public static void main(String[] args)
	{
	String s1="ra\\jev?ra!y/i:ju";
	
	System.out.println(s1);
	int pancCount=0;
	for(int i=0; i<s1.length();i++)
	{

	if( s1.charAt(i)=='?' ||s1.charAt(i)=='!' ||s1.charAt(i)==':'|| s1.charAt(i)=='/'|| s1.charAt(i)== '\"')
	{
	pancCount++;
	}}

	System.out.println("pancutation count is "+ pancCount);
	}
	

 
}  


