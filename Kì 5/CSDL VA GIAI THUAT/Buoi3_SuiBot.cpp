#include <stdio.h>
int mail(){
		int a []= {5,3,4,1,2};
		int length = sizeof(a)/sizeof(int);
		for (int i =0; i <length;i++) {
			for (int j = i+1;j<length;j++){
				if(a[i]>a[j]){
					int temp =  a[i];
					a[i]=a[j];
					a[j]= temp;
				}
			}
		}
		for(int i=0;i<length;i++){
			printf("%d\t",a[i]);
		}
	return 0;
	
}
