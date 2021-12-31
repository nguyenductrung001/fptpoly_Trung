#include <stdio.h>
#include <string.h>

void hienThiTenCot();

struct HoTen {
	char ho[20];
	char dem[20];
	char ten[20];
};


struct NhanVien {
	int ma;
	struct HoTen hoVaTen;
	int tuoi;
	char gioiTinh[10];
};


void nhapHoTen(struct HoTen* ten) {
	printf("Ho: ");
	scanf("%s", ten->ho);
	printf("Dem: ");
	getchar();
	gets(ten->dem);
	printf("Ten: ");
	scanf("%s", ten->ten);
}

struct NhanVien nhapSV() {
	struct NhanVien sv;
	printf("Nhap ma: ");
	scanf("%d", &sv.ma);
	nhapHoTen(&sv.hoVaTen);
	printf("Tuoi: ");
	scanf("%d", &sv.tuoi);
	printf("Gioi tinh: ");
	scanf("%s", sv.gioiTinh);
	return sv;
}

void hienThiTTSV(struct NhanVien sv) {
	// can le sang trai 
	printf("%-10d %-10s %-20s %-10s %-10d %-10s %-10.2f %-10.2f %-10.2f %-10.2f\n",
	sv.ma, sv.hoVaTen.ho, sv.hoVaTen.dem, sv.hoVaTen.ten, sv.tuoi, sv.gioiTinh);
}







int main() {
	struct NhanVien dssv[100];
	int slsv = 0;
	int luaChon;
	
	do {
		printf("=============== MENU ===============");
		printf("\n1. Them Nhan vien vao danh sach.");
		printf("\n2. Hien thi danh sach sinh vien.");
		printf("\n3. Sap xep theo ten.");
		printf("\n4. Tim nhan vien theo ten.");
		printf("\n0. Thoat chuong trinh.");
		printf("\nBan chon ? ");
		
		scanf("%d", &luaChon);
		struct NhanVien sv;
		int i;
		switch(luaChon) {
			case 0:
				break;
				
			case 1:
				sv = nhapSV();
				dssv[slsv++] = sv;
				break;
				
			case 2:
			/*	hienThiTenCot();*/
				for(i = 0; i < slsv; i++) {
					hienThiTTSV(dssv[i]);
				}
				break;
				
		
				
				
			default:
				printf("Sai chuc nang, vui long chon lai!\n");
				break;
		}
		
	} while(luaChon);
	
	return 0;
}
