package lanq.zaixian.com;
import java.math.BigDecimal;


import java.util.Scanner;
import java.lang.*;

public class Circle {

	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);                       
		int r = scanner.nextInt();
		//double pai=3.14159265358979323;
		double pai=Math.atan(1.0)*4;
		double res=r*r*pai;
		BigDecimal   b   =   new   BigDecimal(res);  
		double   f1   =   b.setScale(7,   BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.print(f1);
		
		
	}
	
}
