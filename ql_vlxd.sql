Create database QL_CuaHangVLXD
go

use QL_CuaHangVLXD
go

create table NhanVien(
	MaNV int primary key identity(1,1),
	TenNV nvarchar(50),
	Email varchar(50),
	Sodt nvarchar(15),
	Diachi nvarchar(255)
)
go

create table TaiKhoan(
	Tendangnhap varchar(50) primary key,
	Matkhau varchar(50),
	Vaitro nvarchar(20),
	MaNV int,
	Foreign key (MaNV) references NhanVien(MaNV)
)
go

create table NhaCungCap(
	MaNCC int primary key identity(1,1),
	TenNCC nvarchar(100),
	Sodt nvarchar(15),
	Diachi nvarchar(255)
)

create table SanPham(
	MaSP int primary key identity(1,1),
	TenSP nvarchar(100),
	MoTa nvarchar(255),
	DonGia decimal(10,2),
	SoLuong int,
	Hinh varchar(255),
	MaNCC int,
	Foreign Key (MaNCC) References NhaCungCap(MaNCC)
)
go

create table KhachHang(
	MaKH int primary key identity(1,1),
	TenKH nvarchar(100),
	Sodt nvarchar(15) unique,
	Diachi nvarchar(255)
)
go

create table HoaDon(
	MaHD int primary key identity(1,1),
	MaKH int not null,
	MaNV int not null,
	NgayLapHD varchar(15),
	TongTien decimal(10,2),
	Foreign key (MaKH) references KhachHang(MaKH),
	Foreign key (MaNV) references NhanVien(MaNV)
)
go

create table ChiTietHoaDon(
	MaCTHD int primary key identity(1,1),
	MaHD int not null,
	MaSP int not null,
	SoLuong int,
	DonGia decimal(10, 2),
	Foreign key (MaHD) references HoaDon(MaHD),
	Foreign key (MaSP) references SanPham(MaSP)
)
go

create table PhieuNhap(
	MaPN int primary key identity(1,1),
	MaNCC int not null,
	MaNV int not null,
	NgayLapPN varchar(15),
	TongTien decimal(10,2),
	Foreign key (MaNCC) references NhaCungCap(MaNCC),
	Foreign key (MaNV) references NhanVien(MaNV)
)
go

create table ChiTietPhieuNhap(
	MaCTPN int primary key identity(1,1),
	MaPN int not null,
	MaSP int not null,
	SoLuong int,
	DonGia decimal(10, 2),
	Foreign key (MaPN) references PhieuNhap(MaPN),
	Foreign key (MaSP) references SanPham(MaSP)
)
go

-- Thêm dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (TenNV, Email, Sodt, Diachi)
VALUES 
('Nguyễn Văn A', 'nguyenvana@example.com', '0123456789', '123 Đường ABC, Quận XYZ, TP HCM'),
('Trần Thị B', 'tranthib@example.com', '0987654321', '456 Đường XYZ, Quận ABC, TP HCM');

-- Thêm dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (Tendangnhap, Matkhau, Vaitro, MaNV)
VALUES 
('admin1', 'password1', 'Quản lý', 1),
('user1', 'password2', 'Nhân viên', 2);

-- Thêm dữ liệu vào bảng NhaCungCap
INSERT INTO NhaCungCap (TenNCC, Sodt, Diachi)
VALUES 
('Công ty A', '0123456789', '789 Đường XYZ, Quận ABC, TP HCM'),
('Công ty B', '0987654321', '456 Đường ABC, Quận XYZ, TP HCM');

-- Thêm dữ liệu vào bảng SanPham
INSERT INTO SanPham (TenSP, MoTa, DonGia, SoLuong, Hinh, MaNCC)
VALUES 
('Sắt thép', 'Sản phẩm sắt thép chất lượng cao', 100000, 50, 'satchatluongcao.jpg', 1),
('Gạch ốp lát', 'Gạch ốp lát nhà phố, biệt thự', 50000, 100, 'gachoplat.jpg', 2);

-- Thêm dữ liệu vào bảng KhachHang
INSERT INTO KhachHang (TenKH, Sodt, Diachi)
VALUES 
('Công ty X', '0123456789', '789 Đường ABC, Quận XYZ, TP HCM'),
('Công ty Y', '0987654321', '456 Đường XYZ, Quận ABC, TP HCM');

-- Thêm dữ liệu vào bảng HoaDon
INSERT INTO HoaDon (MaKH, MaNV, NgayLapHD, TongTien)
VALUES 
(1, 1, '2024-05-26', 150000),
(2, 2, '2024-05-27', 200000);

-- Thêm dữ liệu vào bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, DonGia)
VALUES 
(1, 1, 2, 100000),
(2, 2, 3, 50000);

-- Thêm dữ liệu vào bảng PhieuNhap
INSERT INTO PhieuNhap (MaNCC, MaNV, NgayLapPN, TongTien)
VALUES 
(1, 1, '2024-05-26', 200000),
(2, 2, '2024-05-27', 250000);

-- Thêm dữ liệu vào bảng ChiTietPhieuNhap
INSERT INTO ChiTietPhieuNhap (MaPN, MaSP, SoLuong, DonGia)
VALUES 
(1, 1, 5, 40000),
(2, 2, 6, 45000);
