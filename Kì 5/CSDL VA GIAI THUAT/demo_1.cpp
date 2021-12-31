#include <stdio.h>
int mail(){
	int f0 =1,f1=1,n;
	printf("Nhap n: ");
scanf("%d" ,&n);
for(int i = 2 ;i<=n;i++){
	int tong =f0+f1;
	
	f0 = f1;
	f1 = tong;
}
printf("So fibonaci thu %d la %d\n",n,f1);
return 0;
}


