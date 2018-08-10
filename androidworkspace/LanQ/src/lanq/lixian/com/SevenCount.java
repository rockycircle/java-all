package lanq.lixian.com;

public class SevenCount {
public static void main(String[] args){
int[] sc={1,2,3,4,5,6,7};
int[] sd=new int[14];
int[] se={1,1,1,1,1,1,1};
 sd[0]=7;
 sd[1]=4;
 sd[8]=7;
sd[6]=4;
//sc[0]=0;
//sc[6]=0;
se[6]=0;
se[3]=0;
int b=0;
int c=0;

for (int a=0;a<14;a++ ){
	int d=0;
	if(sd[a]==0&&sd[a+b+1]==0){
		for(int aa1=0;aa1<7;aa1++){
			if(d==1){
				aa1=aa1+1;
				d=0;
			}
			if(se[aa1]!=0)
				{b=sc[aa1];
			      break;}
		}
		sd[a]=b;
		sd[a+b+1]=b;
		
	}else{
		c=sd[a-1];
		sd[a-1]=sd[a-1+c]=0;
		se[a-1]=1;
		a=a-2;
		d=1;
	}
		

	
}

for(int dd=0;dd<14;dd++){
	
	System.out.print(sd[dd]);
}



	
	
	
}
}
