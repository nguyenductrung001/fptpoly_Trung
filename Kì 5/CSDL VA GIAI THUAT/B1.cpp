#include <stdio.h>
// demo con tro trong c
int main(){
	int a =4;
	int *conTro;
	conTro =&a;
	
	
	printf("%d\n",&a);
	printf("%d\n",conTro);
	printf("%d\n",*conTro);
	printf("%d\n",&conTro);
	
	return 0;
}
