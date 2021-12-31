#include <stdio.h>
#include <string.h>

void hienThiTenCot();

struct HoTen {
	char ho[20];
	char dem[20];
	char ten[20];
};


struct NhanVien {
	char ma[7];
	struct HoTen hoVaTen;
	int tuoi;
	char gioiTinh[10];
	char luong[10];
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

struct NhanVien nhapNV() {
	struct NhanVien nv;
	printf("Nhap ma: ");
	scanf("%s", &nv.ma); //khai bao thi de la string con nhap thi de la int 
	nhapHoTen(&nv.hoVaTen);
	printf("Tuoi: ");
	scanf("%d", &nv.tuoi);
	printf("Gioi tinh: ");
	scanf("%s", nv.gioiTinh);
	printf("luong: ");
	scanf("%s", nv.luong);
	return nv;
}

void hienThiTTNV(struct NhanVien nv) {

	// can le sang trai
	printf("%-10s %-10s %-20s %-10s %-10d %-10s %-10s\n",
	       nv.ma, nv.hoVaTen.ho, nv.hoVaTen.dem, nv.hoVaTen.ten, nv.tuoi, nv.gioiTinh,nv.luong);
}
void timNhanVienTheoMa(struct NhanVien* ds,int slnv) {
	char ma[7];
	printf("Nhap ma nv can tim?: ");
	fflush(stdin) ;
	scanf("%s",&ma);
//	gets (ma);
	int flag =0;
	printf("%s",ma);
	for(int i =0; i<slnv; i++) {
		if(strcmp(ma , ds[i].ma)==0) {
			hienThiTTNV(ds[i]);
			int flag =1;
		}
	}
	if(flag ==0) {
		printf("Khong co nv nao co ma can tim\n");
	}
}
void sapXepTheoTen(struct NhanVien* ds, int slnv) {
	int i, j;
	for(i = 0; i < slnv - 1; i++) {
		for(j = slnv - 1; j > i; j --) {
			if(strcmp(ds[j].hoVaTen.ten, ds[j-1].hoVaTen.ten) < 0) {
				struct NhanVien nv = ds[j];
				ds[j] = ds[j - 1];
				ds[j - 1] = nv;
			}
		}
	}
}

void sapXepTheoLuong(struct NhanVien* ds, int slnv) {
	int i, j;
	for(i = 0; i < slnv - 1; i++) {
		for(j = slnv - 1; j > i; j --) {
			if(strcmp(ds[j].luong, ds[j-1].luong) < 0) {
				struct NhanVien nv = ds[j];
				ds[j] = ds[j - 1];
				ds[j - 1] = nv;
			}
		}
	}
}

void timTheoTen(struct NhanVien* ds, int slnv) {
	char ten[20];
	printf("Nhap ten: ");
	scanf("%s", ten);

	/*	hienThiTenCot();*/
	int i, timNV = 0;
	for(i = 0; i < slnv; i++) {
		if(strcmp(ten, ds[i].hoVaTen.ten) == 0) {
			hienThiTTNV(ds[i]);
			timNV = 1;
		}
	}
	if(timNV == 0) {
		printf("Khong co nhan vien %s trong danh sach!\n", ten);
	}
}
int main() {
	struct NhanVien dsnv[100];
	int slnv = 0;
	int luaChon;

	do {
		printf("=============== MENU ===============");
		printf("\n1. Them Nhan vien vao danh sach.");
		printf("\n2. Hien thi danh sach sinh vien.");
		printf("\n3. Sap xep theo ten.");
		printf("\n4. Tim nhan vien theo ten.");
		printf("\n5. Tim nhan vien theo ma.");
		printf("\n6. Sap xep theo luong.");
		printf("\n0. Thoat chuong trinh.");
		printf("\nMoi Ban chon ? ");

		scanf("%d", &luaChon);
		struct NhanVien nv;
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
				printf("%-10s %-10s %-20s %-10s %-10s %-10s %-10s \n",
				       "Ma NV", "Ho", "Dem", "Ten", "Tuoi", "Gioi Tinh",
				       "Luong");
				for(i = 0; i < slnv; i++) {
					hienThiTTNV(dsnv[i]);
				}
				break;

			case 3:
				sapXepTheoTen(dsnv, slnv);
				/*	hienThiTenCot();*/
				for(i = 0; i < slnv; i++) {
					hienThiTTNV(dsnv[i]);
				}
				break;


			case 4:
				timTheoTen(dsnv, slnv);
				break;
			case 5:
				timNhanVienTheoMa(dsnv,slnv);
				break;
			case 6:
				sapXepTheoLuong(dsnv, slnv);
				/*	hienThiTenCot();*/
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
