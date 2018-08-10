package lanq.lixian.com;

public class XdXm {

	public static void main(String[] args){
		
		double a=2.0;
		double b=0;
		while(b==0){
			double k=Math.pow( a, a);
			a=a+0.000001;
			double l=Math.pow( a, a);
			if(k<10&&l>10){
				b=1;
				System.out.print(a);
			}
			
		}
	}
}
