package lanq.lixian.com;

import java.util.Scanner;

public class Shudu {
	public static void main(String[] args){
		Scanner scanner =new Scanner(System.in);
		int[][] pan=new int[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				
				pan[i][j]=scanner.nextInt();
				
			}
			
		}
		
		
		
		
		
		
		for(int k=0;k<9;k++){
			for(int l=0;l<9;l++){
				
			System.out.print(pan[k][l]);
			System.out.print(" ");
			}
			System.out.println("");
		}
		
	}

}
