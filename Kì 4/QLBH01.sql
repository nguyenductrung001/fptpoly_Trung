create database QLBH01
go
use QLBH01
go
 


create table taikhoan
(
	tentaikhoan nvarchar(50) not null,
	matkhau nvarchar(50) not null,
	hoten nvarchar(50) not null,
	ngaysinh date not null,
	gioitinh bit not null,
	sdt nvarchar(15) not null,
	email nvarchar(50) not null,
	vaitro int not null,
	constraint pk_tentaikhoan primary key (tentaikhoan)
)
create table danhmuc 
(
	
	tendanhmuc nvarchar(50) not null,
	loai nvarchar(50) not null,
	constraint pk_tendanhmuc primary key (tendanhmuc)
)
create table sanpham
(

	masp nvarchar(15) not null,
	maspchitiet nvarchar(15) not null,
	tensp NVARCHAR(MAX) not null,
	tendanhmuc nvarchar(50) not null,
	kichco nvarchar(15) not null,
	mausac nvarchar(20) not null,
	soluong int not null,
	dongia money not null,
	ngaythem date not null,
	mota nvarchar(max) not null,
	anh nvarchar(20) not null,
	trangthai nvarchar(50) not null,
	
	constraint pk_masp primary key(maspchitiet),
	constraint fk_danhmuc foreign key (tendanhmuc) references danhmuc (tendanhmuc) ON DELETE NO ACTION ON UPDATE CASCADE

)

create table hoadon(
	mahd int identity(1,1) primary key  not null,
	tentaikhoan nvarchar(50)not null,
	ngaytao date not null,
	tongtien money not null,
	constraint fk_tentaikhoan foreign key (tentaikhoan) references taikhoan(tentaikhoan)ON DELETE NO ACTION ON UPDATE CASCADE,
)

create table hoadonchitiet
(
	mahd int not null,
	maspchitiet nvarchar(15) not null,	
	tensp ntext not null,
	kichco nvarchar(15) not null,
	soluong int not null,
	dongia money not null,
	thanhtien money not null,	
	constraint pk_hoadon primary key (mahd,maspchitiet),
	constraint fk_mahd foreign key (mahd) references hoadon(mahd) ON DELETE NO ACTION ON UPDATE CASCADE,
	constraint fk_masp foreign key (maspchitiet) references sanpham(maspchitiet) ON DELETE NO ACTION ON UPDATE CASCADE
) 
-- nhập bảng tài khoản

insert into taikhoan values(N'duyzt11',N'123456',N'Đỗ Văn Duy',N'1998-03-01',0,N'0966501755',N'duydzai01@gmail.com',0)
insert into taikhoan values(N'manhoccho11',N'123456',N'Nguyễn Tiến Mạnh',N'2001-09-01',0,N'0126345678',N'manhoccho11@gmail.com',1)
insert into taikhoan values(N'hieuthu2',N'123456',N'Giang Văn Hiếu',N'2001-01-03',0,N'0123487864',N'hieuthu2@gmail.com',0)
insert into taikhoan values(N'khanhkz',N'123456',N'Tạ Duy khánh',N'2001-06-01',0,N'0389680491',N'khanhkz@gmail.com',0)
insert into taikhoan values(N'totthaydoi',N'123456',N'Nguyễn Đức Tốt',N'2001-01-09',0,N'0966501755',N'totthaydoi@gmail.com',0)
insert into taikhoan values(N'hienxinhgai',N'123456',N'Nguyễn Thúy Hiền',N'1998-03-28',1,N'0123456788',N'hiennt11@gmail.com',1)
insert into taikhoan  values(N'manhzt11',N'123456',N'Nguyễn Tiến Mạnh',N'2001-01-06',0,N'0456145145',N'manh230920011@gmail.com',1)
-- nhập bảng danh muc

insert into danhmuc values(N'Giày tây',N'Giày')
insert into danhmuc values(N'Giày Dior',N'Giày')
insert into danhmuc values(N'Giày Gucci',N'Giày')
insert into danhmuc values(N'Giày Jordan',N'Giày')
insert into danhmuc values(N'Giày mlb',N'Giày')
insert into danhmuc values(N'Quần Balenciaga',N'Giày')
insert into danhmuc values(N'Giày vans',N'Giày')
insert into danhmuc values(N'Giày air force 1',N'Giày')


-- nhập bảng hóa đơn
insert into hoadon values(N'duyzt11',N'2020-10-11',2064000)
insert into hoadon values(N'khanhkz',N'2020-10-15',847000)
insert into hoadon values(N'hieuthu2',N'2020-10-16',2533000)
insert into hoadon values(N'hieuthu2',N'2019-11-16',2533000)
insert into hoadon values(N'hieuthu2',N'2020-11-16',2533000)
select * from hoadon

---- nhập bảng sản phẩm
-- insert into sanpham values(N'DM2Q71',N'DM2Q7111',N'',N'',N'',N'',99,72000,N'01-01-2020',N'',N'',N'1')
--Giày tây
insert into sanpham values(N'DM1Q12',N'DM1Q1101',N'GIÀY NAM DA THẬT ELLY HOMME – EGTM11',N'Giày tây',N'40',N'đen',99,1679000,N'01-01-2020',N'Người đàn ông lịch lãm luôn cần một đôi giày để có vững bước trên mọi chặng đường và hành trình sự nghiệp khi luôn đối mặt với các buổi ký kết hợp đồng cùng các sự kiện quan trọng. Chính vì vậy, một đôi giày cao cấp như Giày nam da thật ELLY HOMME – EGTM11 sẽ giúp người đàn ông thêm đẳng cấp và tự tin.',N'anhtay.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1102',N'GIÀY NAM DA THẬT ELLY HOMME – EGTM11',N'Giày tây',N'41',N'đen',99,1679000,N'01-01-2020',N'Người đàn ông lịch lãm luôn cần một đôi giày để có vững bước trên mọi chặng đường và hành trình sự nghiệp khi luôn đối mặt với các buổi ký kết hợp đồng cùng các sự kiện quan trọng. Chính vì vậy, một đôi giày cao cấp như Giày nam da thật ELLY HOMME – EGTM11 sẽ giúp người đàn ông thêm đẳng cấp và tự tin.',N'anhtay.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1103',N'GIÀY NAM DA THẬT ELLY HOMME – EGTM11',N'Giày tây',N'42',N'đen',99,1679000,N'01-01-2020',N'Người đàn ông lịch lãm luôn cần một đôi giày để có vững bước trên mọi chặng đường và hành trình sự nghiệp khi luôn đối mặt với các buổi ký kết hợp đồng cùng các sự kiện quan trọng. Chính vì vậy, một đôi giày cao cấp như Giày nam da thật ELLY HOMME – EGTM11 sẽ giúp người đàn ông thêm đẳng cấp và tự tin.',N'anhtay.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1104',N'GIÀY NAM DA THẬT ELLY HOMME – EGTM11',N'Giày tây',N'43',N'đen',99,1679000,N'01-01-2020',N'Người đàn ông lịch lãm luôn cần một đôi giày để có vững bước trên mọi chặng đường và hành trình sự nghiệp khi luôn đối mặt với các buổi ký kết hợp đồng cùng các sự kiện quan trọng. Chính vì vậy, một đôi giày cao cấp như Giày nam da thật ELLY HOMME – EGTM11 sẽ giúp người đàn ông thêm đẳng cấp và tự tin.',N'anhtay.jpg',N'1')

insert into sanpham values(N'DM1Q12',N'DM1Q1105',N'Giày Tây Nam Cao Cấp – TNA06',N'Giày tây',N'40',N'đen',99,1679000,N'01-01-2020',N'Newzada là thương hiệu Giày Việt nam xuất khẩu nổi tiếng tại thị trường Việt nam trong xuất thời gian qua. Newzada luôn mang đến người tiêu dùng những sản phẩm ưng ý nhất với thiết kế vừa vặn, tiện lợi, chất lượng được kiểm soát chặt chẽ để đảm bảo độ bền sử dụng lâu dài.',N'anhtay1.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1106',N'Giày Tây Nam Cao Cấp – TNA06',N'Giày tây',N'41',N'đen',99,1679000,N'01-01-2020',N'Newzada là thương hiệu Giày Việt nam xuất khẩu nổi tiếng tại thị trường Việt nam trong xuất thời gian qua. Newzada luôn mang đến người tiêu dùng những sản phẩm ưng ý nhất với thiết kế vừa vặn, tiện lợi, chất lượng được kiểm soát chặt chẽ để đảm bảo độ bền sử dụng lâu dài.',N'anhtay1.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1107',N'Giày Tây Nam Cao Cấp – TNA06',N'Giày tây',N'42',N'đen',99,1679000,N'01-01-2020',N'Newzada là thương hiệu Giày Việt nam xuất khẩu nổi tiếng tại thị trường Việt nam trong xuất thời gian qua. Newzada luôn mang đến người tiêu dùng những sản phẩm ưng ý nhất với thiết kế vừa vặn, tiện lợi, chất lượng được kiểm soát chặt chẽ để đảm bảo độ bền sử dụng lâu dài.',N'anhtay1.jpg',N'1')
insert into sanpham values(N'DM1Q12',N'DM1Q1108',N'Giày Tây Nam Cao Cấp – TNA06',N'Giày tây',N'43',N'đen',99,1679000,N'01-01-2020',N'Newzada là thương hiệu Giày Việt nam xuất khẩu nổi tiếng tại thị trường Việt nam trong xuất thời gian qua. Newzada luôn mang đến người tiêu dùng những sản phẩm ưng ý nhất với thiết kế vừa vặn, tiện lợi, chất lượng được kiểm soát chặt chẽ để đảm bảo độ bền sử dụng lâu dài.',N'anhtay1.jpg',N'1')


--mlb
insert into sanpham values(N'DM1Q11',N'DM1Q1111',N'Giày Mlb- rep 1:1',N'Giày mlb',N'40',N'Trắng',99,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1112',N'Giày Mlb- rep 1:1',N'Giày mlb',N'41',N'Trắng',40,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1113',N'Giày Mlb- rep 1:1',N'Giày mlb',N'43',N'Trắng',50,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1114',N'Giày Mlb- rep 1:1',N'Giày mlb',N'42',N'Trắng',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb.jpg',N'1')

insert into sanpham values(N'DM1Q11',N'DM1Q1115',N'Giày Mlb- rep 1:1',N'Giày mlb',N'40',N'Đỏ',99,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb2.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1116',N'Giày Mlb- rep 1:1',N'Giày mlb',N'41',N'Đỏ',40,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb2.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1117',N'Giày Mlb- rep 1:1',N'Giày mlb',N'43',N'Đỏ',50,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb2.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1118',N'Giày Mlb- rep 1:1',N'Giày mlb',N'42',N'Đỏ',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb2.jpg',N'1')

insert into sanpham values(N'DM1Q11',N'DM1Q1119',N'Giày Mlb- rep 1:1',N'Giày mlb',N'40',N'Đen',99,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb3.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1120',N'Giày Mlb- rep 1:1',N'Giày mlb',N'41',N'Đen',40,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb3.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1121',N'Giày Mlb- rep 1:1',N'Giày mlb',N'43',N'Đen',50,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb3.jpg',N'1')
insert into sanpham values(N'DM1Q11',N'DM1Q1122',N'Giày Mlb- rep 1:1',N'Giày mlb',N'42',N'Đen',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker đế cao thời trang.Thiết kế lấy cảm hứng từ hiệp hội bóng chày MLB.Cộng hưởng cùng chi tiết chữ LA sắc nét.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhmlb3.jpg',N'1')
-- dior
insert into sanpham values(N'DM1Q13',N'DM1Q1222',N'Giày Dior Kaws B23 Low',N'Giày Dior',N'40',N'Trắng',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ thấp thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1123',N'Giày Dior Kaws B23 Low',N'Giày Dior',N'41',N'Trắng',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ thấp thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1124',N'Giày Dior Kaws B23 Low',N'Giày Dior',N'42',N'Trắng',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ thấp thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1125',N'Giày Dior Kaws B23 Low',N'Giày Dior',N'43',N'Trắng',60,1100000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ thấp thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior.jpg',N'1')

insert into sanpham values(N'DM1Q13',N'DM1Q1126',N'Giày Dior X B23 Shawn Stussy',N'Giày Dior',N'40',N'Trắng',60,1300000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ cao thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior1.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1127',N'Giày Dior X B23 Shawn Stussy',N'Giày Dior',N'41',N'Trắng',60,1300000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ cao thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior1.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1128',N'Giày Dior X B23 Shawn Stussy',N'Giày Dior',N'42',N'Trắng',60,1300000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ cao thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior1.jpg',N'1')
insert into sanpham values(N'DM1Q13',N'DM1Q1129',N'Giày Dior X B23 Shawn Stussy',N'Giày Dior',N'43',N'Trắng',60,1300000,N'01-01-2020',N'Kiểu dáng giày sneaker cổ cao thời trang.Là thương hiệu thời trang nổi tiếng.Cộng hưởng cùng chi tiết màng bọc ở thân không sợ bẩn lớp vải bên trong.Lớp lót êm ái, nâng dáng bước chân.Gam màu hiện đại dễ dàng phối với nhiều trang phục và phụ kiện',N'anhdior1.jpg',N'1')
--Giày Gucci
insert into sanpham values(N'DM1Q14',N'DM1Q1130',N'Gucci nam footwear 576137 A38V0 9090',N'Giày Dior',N'40',N'Nâu',60,1500000,N'01-01-2020',N'Được làm từ da đau khổ màu trắng có in hình lưỡi trai Gucci cổ điển, đôi giày thể thao này có đế cao su, chiều cao 1 inch, phần trên thấp, chi tiết da kim loại màu đỏ ở mặt sau của một chiếc giày và chi tiết da kim loại màu xanh lá cây ở mặt sau của đế còn lại. Sản xuất tại Nước Ý.',N'anhgucci.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1131',N'Gucci nam footwear 576137 A38V0 9090',N'Giày Dior',N'41',N'Nâu',60,1500000,N'01-01-2020',N'Được làm từ da đau khổ màu trắng có in hình lưỡi trai Gucci cổ điển, đôi giày thể thao này có đế cao su, chiều cao 1 inch, phần trên thấp, chi tiết da kim loại màu đỏ ở mặt sau của một chiếc giày và chi tiết da kim loại màu xanh lá cây ở mặt sau của đế còn lại. Sản xuất tại Nước Ý.',N'anhgucci.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1132',N'Gucci nam footwear 576137 A38V0 9090',N'Giày Dior',N'42',N'Nâu',60,1500000,N'01-01-2020',N'Được làm từ da đau khổ màu trắng có in hình lưỡi trai Gucci cổ điển, đôi giày thể thao này có đế cao su, chiều cao 1 inch, phần trên thấp, chi tiết da kim loại màu đỏ ở mặt sau của một chiếc giày và chi tiết da kim loại màu xanh lá cây ở mặt sau của đế còn lại. Sản xuất tại Nước Ý.',N'anhgucci.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1133',N'Gucci nam footwear 576137 A38V0 9090',N'Giày Dior',N'43',N'Nâu',60,1500000,N'01-01-2020',N'Được làm từ da đau khổ màu trắng có in hình lưỡi trai Gucci cổ điển, đôi giày thể thao này có đế cao su, chiều cao 1 inch, phần trên thấp, chi tiết da kim loại màu đỏ ở mặt sau của một chiếc giày và chi tiết da kim loại màu xanh lá cây ở mặt sau của đế còn lại. Sản xuất tại Nước Ý.',N'anhgucci.jpg',N'1')

insert into sanpham values(N'DM1Q14',N'DM1Q1134',N'GUCCI nam Gucci Band Ace Sneakers',N'Giày Dior',N'40',N'Trắng',60,1600000,N'01-01-2020',N'Được làm từ da trắng, đôi giày thể thao này của Gucci có đế cao su, chiều cao 0,6 inch, chi tiết Web màu xanh lá cây và màu đỏ, dải thêu Gucci và các ngôi sao, chi tiết da màu đỏ ở mặt sau của một chiếc giày và chi tiết da màu xanh lá cây ở mặt sau của chiếc giày kia Giày, mũi giày tròn và đế có thương hiệu. Sản xuất tại Ý.',N'anhgucci1.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1135',N'GUCCI nam Gucci Band Ace Sneakers',N'Giày Dior',N'41',N'Trắng',60,1600000,N'01-01-2020',N'Được làm từ da trắng, đôi giày thể thao này của Gucci có đế cao su, chiều cao 0,6 inch, chi tiết Web màu xanh lá cây và màu đỏ, dải thêu Gucci và các ngôi sao, chi tiết da màu đỏ ở mặt sau của một chiếc giày và chi tiết da màu xanh lá cây ở mặt sau của chiếc giày kia Giày, mũi giày tròn và đế có thương hiệu. Sản xuất tại Ý.',N'anhgucci1.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1136',N'GUCCI nam Gucci Band Ace Sneakers',N'Giày Dior',N'42',N'Trắng',60,1600000,N'01-01-2020',N'Được làm từ da trắng, đôi giày thể thao này của Gucci có đế cao su, chiều cao 0,6 inch, chi tiết Web màu xanh lá cây và màu đỏ, dải thêu Gucci và các ngôi sao, chi tiết da màu đỏ ở mặt sau của một chiếc giày và chi tiết da màu xanh lá cây ở mặt sau của chiếc giày kia Giày, mũi giày tròn và đế có thương hiệu. Sản xuất tại Ý.',N'anhgucci1.jpg',N'1')
insert into sanpham values(N'DM1Q14',N'DM1Q1137',N'GUCCI nam Gucci Band Ace Sneakers',N'Giày Dior',N'43',N'Trắng',60,1600000,N'01-01-2020',N'Được làm từ da trắng, đôi giày thể thao này của Gucci có đế cao su, chiều cao 0,6 inch, chi tiết Web màu xanh lá cây và màu đỏ, dải thêu Gucci và các ngôi sao, chi tiết da màu đỏ ở mặt sau của một chiếc giày và chi tiết da màu xanh lá cây ở mặt sau của chiếc giày kia Giày, mũi giày tròn và đế có thương hiệu. Sản xuất tại Ý.',N'anhgucci1.jpg',N'1')
-- Giày Jordan
insert into sanpham values(N'DM1Q15',N'DM1Q1138',N'Jordan x Dior Air Jordan 1 High sneakers',N'Giày Jordan',N'40',N'Xám',60,1700000,N'01-01-2020',N'Một trong những đợt ra mắt rất được mong đợi trong năm. Giày thể thao Dior x Air Jordan 1 High là sự hợp tác đầu tiên giữa cường quốc sang trọng và gã khổng lồ giày sneaker. Được chế tác từ da màu xám chó sói và màu trắng buồm, đôi giày thể thao Air Jordan 1 High này mang hình dáng đỉnh cao mang tính biểu tượng, và cập nhật nó bằng biểu tượng hình chữ nhật swoosh màu xám của Dior. Sự cân bằng hoàn hảo giữa phong cách cổ điển và cao cấp.',N'anhjordan.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1139',N'Jordan x Dior Air Jordan 1 High sneakers',N'Giày Jordan',N'41',N'Xám',60,1700000,N'01-01-2020',N'Một trong những đợt ra mắt rất được mong đợi trong năm. Giày thể thao Dior x Air Jordan 1 High là sự hợp tác đầu tiên giữa cường quốc sang trọng và gã khổng lồ giày sneaker. Được chế tác từ da màu xám chó sói và màu trắng buồm, đôi giày thể thao Air Jordan 1 High này mang hình dáng đỉnh cao mang tính biểu tượng, và cập nhật nó bằng biểu tượng hình chữ nhật swoosh màu xám của Dior. Sự cân bằng hoàn hảo giữa phong cách cổ điển và cao cấp.',N'anhjordan.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1140',N'Jordan x Dior Air Jordan 1 High sneakers',N'Giày Jordan',N'42',N'Xám',60,1700000,N'01-01-2020',N'Một trong những đợt ra mắt rất được mong đợi trong năm. Giày thể thao Dior x Air Jordan 1 High là sự hợp tác đầu tiên giữa cường quốc sang trọng và gã khổng lồ giày sneaker. Được chế tác từ da màu xám chó sói và màu trắng buồm, đôi giày thể thao Air Jordan 1 High này mang hình dáng đỉnh cao mang tính biểu tượng, và cập nhật nó bằng biểu tượng hình chữ nhật swoosh màu xám của Dior. Sự cân bằng hoàn hảo giữa phong cách cổ điển và cao cấp.',N'anhjordan.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1141',N'Jordan x Dior Air Jordan 1 High sneakers',N'Giày Jordan',N'43',N'Xám',60,1700000,N'01-01-2020',N'Một trong những đợt ra mắt rất được mong đợi trong năm. Giày thể thao Dior x Air Jordan 1 High là sự hợp tác đầu tiên giữa cường quốc sang trọng và gã khổng lồ giày sneaker. Được chế tác từ da màu xám chó sói và màu trắng buồm, đôi giày thể thao Air Jordan 1 High này mang hình dáng đỉnh cao mang tính biểu tượng, và cập nhật nó bằng biểu tượng hình chữ nhật swoosh màu xám của Dior. Sự cân bằng hoàn hảo giữa phong cách cổ điển và cao cấp.',N'anhjordan.jpg',N'1')

insert into sanpham values(N'DM1Q15',N'DM1Q1142',N'Jordan Air Jordan 1 Mid SE black gold patent leather',N'Giày Jordan',N'40',N'Đen',60,1700000,N'01-01-2020',N'Air Jordan 1 Mid SE bằng da sáng chế vàng đen.Được cung cấp bởi một thị trường giày thể thao hàng đầu giải quyết các loại giày không mặc, đã bán hết, theo nhu cầu hiếm. Mỗi sản phẩm được kiểm tra nghiêm ngặt bởi các chuyên gia giàu kinh nghiệm đảm bảo tính xác thực. Bạn không thể đi sai với một đôi giày thể thao. Được chế tác từ da đen, da bằng sáng chế vàng đen của Air Jordan 1 Mid SE này từ Jordan là một hình bóng đỉnh cao vượt thời gian với sự tinh tế hơn. Dễ dàng như vậy. Đặc trưng với một chi tiết đục lỗ, các tấm da bằng sáng chế, các điểm nhấn màu vàng kim loại, ren và đế cao su.',N'anhjordan1.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1143',N'Jordan Air Jordan 1 Mid SE black gold patent leather',N'Giày Jordan',N'41',N'Đen',60,1700000,N'01-01-2020',N'Air Jordan 1 Mid SE bằng da sáng chế vàng đen.Được cung cấp bởi một thị trường giày thể thao hàng đầu giải quyết các loại giày không mặc, đã bán hết, theo nhu cầu hiếm. Mỗi sản phẩm được kiểm tra nghiêm ngặt bởi các chuyên gia giàu kinh nghiệm đảm bảo tính xác thực. Bạn không thể đi sai với một đôi giày thể thao. Được chế tác từ da đen, da bằng sáng chế vàng đen của Air Jordan 1 Mid SE này từ Jordan là một hình bóng đỉnh cao vượt thời gian với sự tinh tế hơn. Dễ dàng như vậy. Đặc trưng với một chi tiết đục lỗ, các tấm da bằng sáng chế, các điểm nhấn màu vàng kim loại, ren và đế cao su.',N'anhjordan1.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1145',N'Jordan Air Jordan 1 Mid SE black gold patent leather',N'Giày Jordan',N'42',N'Đen',60,1700000,N'01-01-2020',N'Air Jordan 1 Mid SE bằng da sáng chế vàng đen.Được cung cấp bởi một thị trường giày thể thao hàng đầu giải quyết các loại giày không mặc, đã bán hết, theo nhu cầu hiếm. Mỗi sản phẩm được kiểm tra nghiêm ngặt bởi các chuyên gia giàu kinh nghiệm đảm bảo tính xác thực. Bạn không thể đi sai với một đôi giày thể thao. Được chế tác từ da đen, da bằng sáng chế vàng đen của Air Jordan 1 Mid SE này từ Jordan là một hình bóng đỉnh cao vượt thời gian với sự tinh tế hơn. Dễ dàng như vậy. Đặc trưng với một chi tiết đục lỗ, các tấm da bằng sáng chế, các điểm nhấn màu vàng kim loại, ren và đế cao su.',N'anhjordan1.jpg',N'1')
insert into sanpham values(N'DM1Q15',N'DM1Q1146',N'Jordan Air Jordan 1 Mid SE black gold patent leather',N'Giày Jordan',N'43',N'Đen',60,1700000,N'01-01-2020',N'Air Jordan 1 Mid SE bằng da sáng chế vàng đen.Được cung cấp bởi một thị trường giày thể thao hàng đầu giải quyết các loại giày không mặc, đã bán hết, theo nhu cầu hiếm. Mỗi sản phẩm được kiểm tra nghiêm ngặt bởi các chuyên gia giàu kinh nghiệm đảm bảo tính xác thực. Bạn không thể đi sai với một đôi giày thể thao. Được chế tác từ da đen, da bằng sáng chế vàng đen của Air Jordan 1 Mid SE này từ Jordan là một hình bóng đỉnh cao vượt thời gian với sự tinh tế hơn. Dễ dàng như vậy. Đặc trưng với một chi tiết đục lỗ, các tấm da bằng sáng chế, các điểm nhấn màu vàng kim loại, ren và đế cao su.',N'anhjordan1.jpg',N'1')
--Giày air force 1
insert into sanpham values(N'DM1Q16',N'DM1Q1147',N'NIKE White Air Force 1',N'Giày air force 1',N'40',N'Trắng',60,1700000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1148',N'NIKE White Air Force 1',N'Giày air force 1',N'41',N'Trắng',60,1700000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1149',N'NIKE White Air Force 1',N'Giày air force 1',N'42',N'Trắng',60,1700000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1150',N'NIKE White Air Force 1',N'Giày air force 1',N'43',N'Trắng',60,1700000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air.jpg',N'1')

insert into sanpham values(N'DM1Q16',N'DM1Q1162',N'Nike X Off-White Air Force 1',N'Giày air force 1',N'40',N'Đen',60,1800000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air1.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1159',N'Nike X Off-White Air Force 1',N'Giày air force 1',N'41',N'Đen',60,1800000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air1.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1160',N'Nike X Off-White Air Force 1',N'Giày air force 1',N'42',N'Đen',60,1800000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air1.jpg',N'1')
insert into sanpham values(N'DM1Q16',N'DM1Q1161',N'Nike X Off-White Air Force 1',N'Giày air force 1',N'43',N'Đen',60,1800000,N'01-01-2020',N'Low-top paneled buffed leather sneakers in white. Perforated detailing at round toe. Logo plaque at tonal lace-up closure. Textile logo patch at padded tongue. Padded collar. Tonal leather Swoosh appliqué at sides. Tonal embroidered logo at heel tab. Tonal mesh lining. Tonal textured rubber midsole featuring embossed logo at outer side. Tonal treaded rubber outsole',N'air1.jpg',N'1')

--Giày vans
insert into sanpham values(N'DM1Q17',N'DM1Q1151',N'Vans Old Skool sneakers',N'Giày vans',N'40',N'Tím',60,900000,N'01-01-2020',N'VansOld Skool sneakers Multicoloured leather, suede and canvas Old Skool sneakers from Vans featuring a round toe, a lace-up front fastening, a stripe detail to the side, a contrasting heel counter, a flat rubber sole and a lightning print to the sides. These styles are supplied by a premium sneaker and street wear marketplace. Stocking only the most sought-after footwear and clothing, they source and curate some of the most hard-to-find items from around the world.',N'vans.jpg',N'1')
insert into sanpham values(N'DM1Q17',N'DM1Q1152',N'Vans Old Skool sneakers',N'Giày vans',N'41',N'Tím',60,900000,N'01-01-2020',N'VansOld Skool sneakers Multicoloured leather, suede and canvas Old Skool sneakers from Vans featuring a round toe, a lace-up front fastening, a stripe detail to the side, a contrasting heel counter, a flat rubber sole and a lightning print to the sides. These styles are supplied by a premium sneaker and street wear marketplace. Stocking only the most sought-after footwear and clothing, they source and curate some of the most hard-to-find items from around the world.',N'vans.jpg',N'1')
insert into sanpham values(N'DM1Q17',N'DM1Q1153',N'Vans Old Skool sneakers',N'Giày vans',N'42',N'Tím',60,900000,N'01-01-2020',N'VansOld Skool sneakers Multicoloured leather, suede and canvas Old Skool sneakers from Vans featuring a round toe, a lace-up front fastening, a stripe detail to the side, a contrasting heel counter, a flat rubber sole and a lightning print to the sides. These styles are supplied by a premium sneaker and street wear marketplace. Stocking only the most sought-after footwear and clothing, they source and curate some of the most hard-to-find items from around the world.',N'vans.jpg',N'1')
insert into sanpham values(N'DM1Q17',N'DM1Q1154',N'Vans Old Skool sneakers',N'Giày vans',N'43',N'Tím',60,900000,N'01-01-2020',N'VansOld Skool sneakers Multicoloured leather, suede and canvas Old Skool sneakers from Vans featuring a round toe, a lace-up front fastening, a stripe detail to the side, a contrasting heel counter, a flat rubber sole and a lightning print to the sides. These styles are supplied by a premium sneaker and street wear marketplace. Stocking only the most sought-after footwear and clothing, they source and curate some of the most hard-to-find items from around the world.',N'vans.jpg',N'1')

--Giày Balenciaga
insert into sanpham values(N'DM1Q18',N'DM1Q1155',N'Balenciaga Triple S low-top sneakers',N'Giày air force 1',N'40',N'Trắng',60,900000,N'01-01-2020',N'Balenciaga Triple S low-top sneakers Get the triple of comfort and the triple of coolness with these Triple S low-top sneakers from Balenciaga. Crafted with leather panels, these sneakers are definitely made for walking! Featuring a lace-up front fastening, a round toe, Triple S printed t to the tongue, a triple-stack chunky rubber sole and embroidered size at the edge of the toe.',N'balen.jpg',N'1')

insert into sanpham values(N'DM1Q18',N'DM1Q1156',N'Balenciaga Triple S low-top sneakers',N'Giày air force 1',N'41',N'Trắng',60,900000,N'01-01-2020',N'Balenciaga Triple S low-top sneakers Get the triple of comfort and the triple of coolness with these Triple S low-top sneakers from Balenciaga. Crafted with leather panels, these sneakers are definitely made for walking! Featuring a lace-up front fastening, a round toe, Triple S printed t to the tongue, a triple-stack chunky rubber sole and embroidered size at the edge of the toe.',N'balen.jpg',N'1')

insert into sanpham values(N'DM1Q18',N'DM1Q1157',N'Balenciaga Triple S low-top sneakers',N'Giày air force 1',N'42',N'Trắng',60,900000,N'01-01-2020',N'Balenciaga Triple S low-top sneakers Get the triple of comfort and the triple of coolness with these Triple S low-top sneakers from Balenciaga. Crafted with leather panels, these sneakers are definitely made for walking! Featuring a lace-up front fastening, a round toe, Triple S printed t to the tongue, a triple-stack chunky rubber sole and embroidered size at the edge of the toe.',N'balen.jpg',N'1')

insert into sanpham values(N'DM1Q18',N'DM1Q1158',N'Balenciaga Triple S low-top sneakers',N'Giày air force 1',N'43',N'Trắng',60,900000,N'01-01-2020',N'Balenciaga Triple S low-top sneakers Get the triple of comfort and the triple of coolness with these Triple S low-top sneakers from Balenciaga. Crafted with leather panels, these sneakers are definitely made for walking! Featuring a lace-up front fastening, a round toe, Triple S printed t to the tongue, a triple-stack chunky rubber sole and embroidered size at the edge of the toe.',N'balen.jpg',N'1')


insert into hoadonchitiet values(N'1',N'DM1Q1158',N'Balenciaga Triple S low-top sneakers',N'40',3,490000,1470000) 	
insert into	hoadonchitiet values(N'1',N'DM2Q7114',N'Áo khoác Hoodie Nỉ nam form rộng phối nhiều màu cực chất',N'S',2,720000,144000)
insert into	hoadonchitiet values(N'1',N'DM2Q6314',N'bộ thể thao thu đông nam',N'XL',1,450000,450000)

-- nhập hóa đơn 2
insert into	hoadonchitiet values(N'2',N'DM2Q5212',N'Áo Sơ Mi Nam Dài Tay AD07 Lịch Lãm Thời Trang Nam',N'L',3,89000,267000)
insert into	hoadonchitiet values(N'2',N'DM2Q1311',N'Áo Thun SWE In 3D Phản Quang Xịn Unisex Pink.Shop, Đủ Size, Chất Vải Đẹp Mềm Mịn Co Giãn Tốt, Form Chuẩn, Kiểu Dáng Trẻ Trung',N'XS',2,75000,150000)
insert into	hoadonchitiet values(N'2',N'DM2Q4211',N'ÁO KHOÁC BÒ NAM CAO CẤP THỜI TRANG CHẤT LIÊU ĐẸP PHƯƠNG VI FASHION AK28',N'M',2,215000,430000)
insert into	hoadonchitiet values(N'2',N'DM2Q6314',N'bộ thể thao thu đông nam',N'XL',2,450000,450000)

-- nhập hóa đơn 3
insert into	hoadonchitiet values(N'3',N'DM2Q5213',N'Áo Sơ Mi Nam Dài Tay AD07 Lịch Lãm Thời Trang Nam',N'XL',3,89000,267000)
insert into	hoadonchitiet values(N'3',N'DM1Q8117',N'QUẦN SUÔNG 2 LINE',N'34',2,249000,498000)
insert into	hoadonchitiet values(N'3',N'DM2Q4213',N'ÁO KHOÁC BÒ NAM CAO CẤP THỜI TRANG CHẤT LIÊU ĐẸP PHƯƠNG VI FASHION AK28',N'XL',5,215000,1075000)
insert into	hoadonchitiet values(N'3',N'DM2Q2314',N'Áo Thun Ba Lỗ Nam Hàn Quốc WASTE',N'L',2,198000,396000)
insert into hoadonchitiet values(N'3',N'DM1Q1221',N'QUẦN JEAN NAM RÁCH CAO CẤP TRẺ TRUNG 351 JET SHOP',N'28',3,99000,297000)


update  danhmuc set tendanhmuc=N'Giày Balenciaga' where tendanhmuc=N'Quần Balenciaga'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1130'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1131'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1132'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1133'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1134'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1135'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1136'
update sanpham set tendanhmuc=N'Giày Gucci' where maspchitiet like N'DM1Q1137'
-- sửa giày balen
update sanpham set tendanhmuc=N'Giày Balenciaga' where maspchitiet like N'DM1Q1155'
update sanpham set tendanhmuc=N'Giày Balenciaga' where maspchitiet like N'DM1Q1156'
update sanpham set tendanhmuc=N'Giày Balenciaga' where maspchitiet like N'DM1Q1157'
update sanpham set tendanhmuc=N'Giày Balenciaga' where maspchitiet like N'DM1Q1158'







update sanpham set tendanhmuc=N'Giày vans' where maspchitiet like N'DM1Q1151'
update sanpham set tendanhmuc=N'Giày vans' where maspchitiet like N'DM1Q1152'
update sanpham set tendanhmuc=N'Giày vans' where maspchitiet like N'DM1Q1153'
update sanpham set tendanhmuc=N'Giày vans' where maspchitiet like N'DM1Q1154'

select * from sanpham
select * from danhmuc
select * from taikhoan