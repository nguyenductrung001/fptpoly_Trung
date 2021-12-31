#include <stdio.h>
struct Date {
	int ngay;
	int thang;
	int nam;
};
struct HoTen {
	char ho[20];
	char dem[20];
	char ten[20];

};
struct NhanVien {
	int ma;
	struct HoTen hoVaTen;
	int tuoi;
	char gioitinh[10];
	float luong;
};
typedef NhanVien nhanvien;
void nhapHoTen(struct HoTen* ten) {
	printf("Ho: ");
	scanf("%s ",ten ->ho);
	printf("Dem: ");
	getchar();
	gets(ten ->dem);
	printf("ten: ");
	scanf("%s",ten->ten);
}
struct NhanVien nhapNV() {
	struct NhanVien nv;
	printf("Nhap maNV: ");
	scanf("%d",&nv.ma);
	nhapHoTen(&nv.hoVaTen);
	printf("Tuoi: ");
	scanf("%d",&nv.tuoi);
	printf("GioiTinh: ");
	scanf("%s",nv.gioitinh);
	return nv;
}
int main() {
	struct NhanVien dsnv[100];
	int slnv = 0;
	struct NhanVien nv;
	nv = nhapNV();
	dsnv[slnv++]= nv;
	printf("Ma: %d, ho ten : %s %s",nv.ma,nv.hoVaTen.ho,nv.hoVaTen.ten);
//	while(true){
//		//
//
//		cout<<"\n\n\t\t=============MENU=============";
//		cout<<"\n1.Them vao 1 nhan vien.";
//		cout<<"\n2.Tim nhan vien theo ma so.";
//		cout<<"\n3.Tim nhan vien theo ten.";
//		cout<<"\n0.Ket Thuc.";
//		cout<<"\n\n\t\t=============END=============";
//		int luachon;
//		cout<<"Nhap lua chon: ";
//		cin>>luachon
//
//		if(luachon == 0){
//			break;
//		}else if(luachon==1){
//			cout<<"\nThuc hien chuc nang cau 1";
//		}else if(luachon==2){
//			cout<<"\nThuc hien chuc nang cau 2";
//		}else if(luachon==3){
//			cout<<"\nThuc hien chuc nang cau 3";
//		}
//	}
//	system("pause");
	return 0;


}
