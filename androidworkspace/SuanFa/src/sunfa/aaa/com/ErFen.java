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
	//	System.out.print("����������Ϊa");
		//a=scanner.nextInt();
		//System.out.print("����������Ϊb");
	//	b=scanner.nextInt();
	//	System.out.print("����������Ϊe");
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
			System.out.print("�˸�Ϊ"+x);
		}else{
			
			System.out.print("�������޸�");
		}
		
		//scanner.close();
		
		
	}
	
	
}
