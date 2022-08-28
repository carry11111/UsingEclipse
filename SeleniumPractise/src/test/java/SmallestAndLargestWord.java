
public class SmallestAndLargestWord {

	public static void main(String[] args) {
		
		
		
		String str="Abc defgh Aertyu Ac";
		
		String[] ar=str.split(" ");

		String smallest = ar[0];String largest=ar[0];
		
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i].length()<smallest.length())
			{
				smallest=ar[i];
			}
		}
	
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i].length()>largest.length())
			{
				largest=ar[i];
			}
		}
		System.out.println("the smallest word is "+smallest);
		System.out.println("the smallest word is "+largest);
	}

}
