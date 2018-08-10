package lanq.zaixian.com;

import java.util.Scanner;

public class ShuLie {
	
	public static int partition(int A[],int low,int high){
		int k,i=low;
		int x=A[low];
		for(k=low+1;k<=high;k++){
			if(A[k]<=x){
				i+=1;
				if(i!=k){
					int q=A[i];
					A[i]=A[k];
					A[k]=q;
				}	
			}	
		}
		int w=A[low];
			A[low]=A[i];
			A[i]=w;	
			return i;
	}
	
	
	public static void quicksort(int A[],int low ,int high){
		int k = 0;
	    if(low<high){
	    	k=partition(A,low,high);
	   		quicksort(A,low,k-1);
		    quicksort(A,k+1,high);
	    }

		
	}
	
	
	
    
	public static void main(String[] args){
    	   Scanner scanner =new Scanner(System.in);
    	   int n =scanner.nextInt();
    	   int[] shul=new int[n];
    	   for(int i=0;i<n;i++){
    		   shul[i]=scanner.nextInt(); 
    	   }
    	   
    	   quicksort(shul,0,n-1);
    	   
    	   for(int j=0;j<n;j++){
    		   System.out.print(shul[j]);
    		   
    	   }
    	   scanner.close();
       }
	
	
	
}
