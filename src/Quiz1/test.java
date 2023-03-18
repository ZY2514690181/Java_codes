package Quiz1;

public class test {
	
	public static void fun(int m, int n) {
		if (n>0) {
			fun(m-1,n-1);
			System.out.println(m);
			fun(m+1,n-1);
		}
	}

	public static void main(String[] args) {
		fun(6,3);
	}

}
