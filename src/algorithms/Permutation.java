package algorithms;

public class Permutation 
{
	public static void main(String[] args)
	{
		String str = "nethaji"; 
		int n = str.length(); //check the length of a string.
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
	}

	//using  permute method  to check the possible ways of a string.
	private void permute(String str, int l, int r)  
	{
		if (l == r)
			System.out.println(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}	
	//using swap method for  characters at a particular  position.
	public String swap(String a, int i, int j) 
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
