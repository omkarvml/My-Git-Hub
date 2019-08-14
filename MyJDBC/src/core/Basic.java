package core;

import java.util.Scanner;

public class Basic {

	
	
	//even or odd
	public void even(){
		for(int i=1;i<=20;i++){
			if(i%2==0){
				System.out.println(i+"  is even number");
			}
			else{
				System.out.println(i+"  is odd number");
			}
		}
	}
	//
	///MyJDBC
	
	// factorial of any number
	public void Fact(){
		int n,fact=1,temp;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter number to find out factorial:");
		n=scan.nextInt();
		temp=n;
		while(n!=0){
			fact=fact*n;
			n--;
		}
		System.out.println("factorial of "+temp+" is "+fact);
	}
	//
	//
	//febbronic series
	public void Febb(){
		
		int a=0,b=1,c;
		System.out.print("requried series is:: "+a+","+b+",");
		c=a+b;
		System.out.print(c);
		for(int i=2;i<=15;i++){
			a=b;
			b=c;
			c=a+b;
			System.out.print(c+",");
		}
	}
	//
	//
	//Prime number or not
	public void Prime(){
		int i,n;
		boolean isPrime=true;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter number to find priome or not:");
		n=scan.nextInt();
				for(i=2;i<n;i++){
					if(n%i==0){
						isPrime=false;
						break;
					}			
				}

	if(isPrime){
		System.out.println(n+" is a prime number");
	}
	else{
		System.out.println(n+"is not a prime number");
	}
}
	////
	////
	/// Poliondrome
	
	public void Amstrong(){
		int m,n,l,sum=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter number to find amstrong or not:");
		n=scan.nextInt();
		m=n;
		while(n>0){
			l=n%10;
			sum= sum +(l*l*l);
			n=n/10;
			}
		if(sum==m){
			System.out.println(m+"  is an amstrong number ");
		}
		else{
			System.out.println(m+" is not an amstrong number");
		}
		
	}
	//
	//
	// polendrome or not
	public void polendrome(){
		int m,n,l,rev=0;
		Scanner scan=new Scanner(System.in);
		System.out.println("enter number to find Polendrome or not:");
		n=scan.nextInt();
		m=n;
		while(n>0){
			l=n%10;
			rev=rev*10+l;
			n=n/10;
		}
		if(m==rev){
			System.out.println(m+"  number is a polendrome");
					}
		else{
			System.out.println(m+ " is not a polendrome");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Basic b=new Basic();
	//	b.even();
		//b.Fact();
		//b.Febb();
		//b.Prime();
		//b.Amstrong();
		b.polendrome();
		
		}

}
