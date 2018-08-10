package lanq.lixian.com;

import java.util.Scanner;

public class GouGu {

	public static void main(String[] args){
		Scanner scanner= new Scanner(System.in);
		int n=scanner.nextInt();
		int j=0;
		int xx=n*n;
		for(int i=1;i<=n;i++){
			int ii=i*i;
			for(int k=1;k<=n;k++){
			int kk=k*k;
			int la=ii+kk;
			if(xx==la){
				j=j+1;
			}
			}
		}
		System.out.print(j/2);
		scanner.close();
	}
	
	
	
}
