pzuse QLDA
go
select TENDEAN, CAST(sum(THOIGIAN) as decimal(5,2)) as tongSoGioLamViec
from CONGVIEC inner join DEAN on CONGVIEC.MADA = DEAN.MADA
				inner join PHANCONG on CONGVIEC.MADA = PHANCONG.MADA
Group by TENDEAN

select TENDEAN, convert(decimal(5,2),sum(THOIGIAN)  ) as tongSoGioLamViec
from CONGVIEC inner join DEAN on CONGVIEC.MADA = DEAN.MADA
				inner join PHANCONG on CONGVIEC.MADA = PHANCONG.MADA
Group by TENDEAN
-----------------------------------------------
--Với mỗi phòng ban, liệt kê tên phòng ban và lương trung bình của những nhân viên làm
--việc cho phòng ban đó.
--o Xuất định dạng “luong trung bình” kiểu decimal với 2 số thập phân, sử dụng dấu
--phẩy để phân biệt phần nguyên và phần thập phân

select TENPHG,cast( AVG(LUONG) as decimal(10,2)) as luongTB
from NHANVIEN inner join PHONGBAN on NHANVIEN.PHG = PHONGBAN.MAPHG
group by TENPHG

select TENPHG,convert(  decimal(10,2),AVG(LUONG) ) as luongTB
from NHANVIEN inner join PHONGBAN on NHANVIEN.PHG = PHONGBAN.MAPHG
group by TENPHG

--o Xuất định dạng “luong trung bình” kiểu varchar. Sử dụng dấu phẩy tách cứ mỗi 3
--chữ số trong chuỗi ra, gợi ý dùng thêm các hàm Left, Replace


select TENPHG,left(cast( AVG(LUONG) as nvarchar(10)),3) +',' +REPLACE(cast( AVG(LUONG) as nvarchar(10)),left(cast( AVG(LUONG) as nvarchar(10)),3),',')
as luongTB
from NHANVIEN inner join PHONGBAN on NHANVIEN.PHG = PHONGBAN.MAPHG
group by TENPHG

----b3

select UPPER( HONV) +' '+ LOWER (TENLOT)+' '+ TENNV ,LOWER(SUBSTRING(TENNV,1,1))+UPPER(SUBSTRING(TENNV,2,1))+SUBSTRING(TENNV,3,10) AS ten, DCHI
from NHANVIEN inner join THANNHAN on NHANVIEN.MANV = THANNHAN.MA_NVIEN
where (MA_NVIEN) >=2





-- Dữ liệu cột DCHI chỉ hiển thị phần tên đường, không hiển thị các thông tin khác
--như số nhà hay thành phố.


-------
--b4
select YEAR(GETDATE()) - YEAR(NGSINH) as tuổiNV
from NHANVIEN

select MANV,TENNV,NGSINH,DATENAME(WEEKDAY,NGSINH) as thứSinh
from NHANVIEN 


select convert(nvarchar,NGSINH,105) as NgaySinh
from NHANVIEN