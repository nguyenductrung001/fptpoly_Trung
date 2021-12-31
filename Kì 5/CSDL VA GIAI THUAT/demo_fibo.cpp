#include <stdio.h>
int fibo(){
	if(n==1 || n==2){
		return 1;
	}
	return fibo(n-1) + fibo(n-2);

}
int mail(){
int n;
printf("Nhap n: ");
scanf("%d,&n");
printf("So fibo thu %d =%d",n,fibo(n));
return 0;
}
