#include <stdio.h>
#include <string.h>

void hienThiTenCot();

struct HoTen {
	char ho[20];
	char dem[20];
	char ten[20];
};


struct Nguoi {
	char quequan[100];
	struct HoTen hoVaTen;
	int tuoi;

};


void nhapHoTen(struct HoTen* ht) {
	printf("Ho: ");
	scanf("%s", ht->ho);
	printf("Dem: ");
	getchar();
	gets(ht->dem);
	printf("Ten: ");
	scanf("%s", ht->ten);
}

struct Nguoi nhapNV() {
	struct Nguoi nv;
	printf("Nhap que quan: ");
	scanf("%s", &nv.quequan); //khai bao thi de la string con nhap thi de la int 
	nhapHoTen(&nv.hoVaTen);
	printf("Tuoi: ");
	scanf("%d", &nv.tuoi);
	return nv;
}
struct NhanVien Extends Nguoi
void hienThiTTNV(struct Nguoi nv) {

	// can le sang trai
	printf("%-10s %-10s %-20s %-10s %-10d\n",
	       nv.quequan, nv.hoVaTen.ho, nv.hoVaTen.dem, nv.hoVaTen.ten, nv.tuoi);
}





int main() {
	struct Nguoi dsnv[100];
	int slnv = 0;
	int luaChon;

	do {
		printf("=============== MENU ===============");
		printf("\n1. Them .");
		printf("\n2. Hien thi.");
		printf("\n0. Thoat chuong trinh.");
		printf("\nMoi Ban chon ? ");

		scanf("%d", &luaChon);
		struct Nguoi nv;
		int i;
		switch(luaChon) {
			case 0:
				break;

			case 1:
				nv = nhapNV();
				dsnv[slnv++] = nv;
				break;

			case 2:
				/*	hienThiTenCot();*/
				printf("%-10s %-10s %-20s %-10s %-10s\n",
				       "QUe quan", "Ho", "Dem", "Ten", "Tuoi");
				for(i = 0; i < slnv; i++) {
					hienThiTTNV(dsnv[i]);
				}
				break;
			default:
				printf("Sai chuc nang, vui long chon lai!\n");
				break;
		}

	} while(luaChon);

	return 0;
}
