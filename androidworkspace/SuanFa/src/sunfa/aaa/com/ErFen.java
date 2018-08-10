package sunfa.aaa.com;

import java.util.Scanner;

public class ErFen {

	public static double f(double x){
		double a=x*x*x-x*x-5.0;
		return a;
	}
	
	public static void main(String[] args){
	    
		
		//Scanner scanner=new Scanner(System.in);
		double a=2,b=3,e=0.005,x;
	//	System.out.print("输入左区间为a");
		//a=scanner.nextInt();
		//System.out.print("输入左区间为b");
	//	b=scanner.nextInt();
	//	System.out.print("输入左区间为e");
	//	e=scanner.nextInt();
		
		if(f(a)*f(b)<0){
			System.out.print("you");
			x=(a+b)/2;
			while(f(x)!=0){
				System.out.print(f(x));
				System.out.print(f(a));
				
				if(f(x)*f(a)<0){	
					b=x;
					if(Math.abs(b-a)<e){
						
						break;
					}else{
						x=(a+b)/2;
						continue;
					}
					
				}else{
					a=x;
					if(Math.abs(b-a)<e){
						break;
					}else{
						x=(a+b)/2;
						continue;
					}
				}
				
			}
			x=(a+b)/2;
			System.out.print("此根为"+x);
		}else{
			
			System.out.print("此区间无根");
		}
		
		//scanner.close();
		
		
	}
	
	
}
