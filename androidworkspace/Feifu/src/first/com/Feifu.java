
package first.com;

import java.util.*;
public class Feifu {
	static int power(int x, int n){
		int y = 0 ;
			if (n == 0)y = 1;
			else {
				y = y*y;
				power(x, n / 2);
					if (n % 2 == 1)
						y = y*y*x;
			
			}
			return y;
		}

public static void main(String[] args){
	int x, n,k;
	Scanner in=new Scanner(System.in);
	System.out.println("please enter x: ");
	 x=in.nextInt();
		System.out.println("please enter n: ");
		 n=in.nextInt();
		 k=power(x,n);
			System.out.println(k); 
			
}
 
}
