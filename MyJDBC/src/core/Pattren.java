package core;

public class Pattren {
	void P1(){
		for(int i=0;i<=4;i++){
			for(int j=0;j<=i;j++){
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	void P2(){
		for(int i=0;i<=4;i++){
			for(int j=0;j<=i;j++){
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	

	
	void P3(){
		int i,j,temp,a=1;
		
		for(i=1;i<5;i++){
			for(j=1;j<=i;j++){
				temp=a;
			if(temp==6){
				System.out.print("$");
			}
			else{
				System.out.print(a+"");
			} 
			a++;
		} 
		System.out.println();
		}
		System.out.println();
		System.out.println();
	}
 void P4()
 {
	 int i,j,temp,a=7;
		for(i=3;i>=0;i--){
			for(j=0;j<=i;j++){temp=a+j;
			if(temp==6){
				System.out.print("$");
			}
			else{
				System.out.print(a+j+"");
			}
		} a=a-i;
		System.out.println();
		}
		System.out.println();
		System.out.println();
 }
 
 
	public static void main(String[] args) {
		
		Pattren p=new Pattren();
		p.P1();
		
		p.P2();
		
		p.P3();
		p.P4();

	}

}
