package algorithms;

/**
 * write a program to sort the array and print out the contents with labels.
 */
public class SortingArrays {
	
	public static void sortTemps(double[] array)
	{
		int count=0;
		
		for(int i=0;i<array.length;i++)
			for(int j=i; j<array.length;j++) {
				if(array[i]>array[j])
				{
					double temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++)
				if(array[i]%2==0)
					count++;
					
			System.out.println(array[i]+"\t\t"+count);
		}
	}

	public static void main(String[] args) 
	{
//		double[] temps = {42.2, 10, 22, 30, 45, 55, 66.9, 100, 101.3};
//		System.out.println("Temps: \t\t times: ");
//		sortTemps(temps);
		int a=9, b=2;
		System.out.println(a/b+1);
		
		/*
		String s = "Final exam";
		System.out.println("length: "+s.length());
		System.out.println("\n");
		System.out.println("substring of last word: "+ s.substring(6, 10));
		System.out.println("\n");
		System.out.println("last index of x: "+s.lastIndexOf("x"));
		System.out.println("\n");
		System.out.println("sub string again: " +s.substring(s.lastIndexOf(" ")));
		System.out.println("\n");
		*/
	}
}
