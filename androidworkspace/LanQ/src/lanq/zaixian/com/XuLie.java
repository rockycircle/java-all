package lanq.zaixian.com;

import java.util.Scanner;

public class XuLie {

public static void main(String[] args){
	
	
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
	int res=0;
	for(int i=1;i<=n;i++){
		res=res+i;
		
	}
	System.out.print(res);
	scanner.close();
	
}
}
