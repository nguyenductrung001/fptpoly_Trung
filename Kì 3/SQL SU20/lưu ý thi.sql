--Lưu ý
-- thủ tục thêm dữ liệu /insert, nếu không bắt kiểm tra thì làm đơn giản
create proc ten_tt
as
Begin
	Begin TRY
		-- lệnh insert into 
		--print 'thêm dữ liệu thành công'
	End try
	Begin Catch
		print N'Thêm dữ liệu:' + Error_Massage()
	end Catch
end 