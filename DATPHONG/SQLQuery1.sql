CREATE DATABASE HOTEL
go
use HOTEL
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CHITIETKM') and o.name = 'FK_CHITIETK_CHITIETKM_KHUYENMA')
alter table CHITIETKM
   drop constraint FK_CHITIETK_CHITIETKM_KHUYENMA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CHITIETKM') and o.name = 'FK_CHITIETK_CHITIETKM_LOAIPHON')
alter table CHITIETKM
   drop constraint FK_CHITIETK_CHITIETKM_LOAIPHON
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CTPHIEUDAT') and o.name = 'FK_CTPHIEUD_CTPHIEUDA_PHONG')
alter table CTPHIEUDAT
   drop constraint FK_CTPHIEUD_CTPHIEUDA_PHONG
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CTPHIEUDAT') and o.name = 'FK_CTPHIEUD_CTPHIEUDA_PHIEUDAT')
alter table CTPHIEUDAT
   drop constraint FK_CTPHIEUD_CTPHIEUDA_PHIEUDAT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('LOAIPHONG') and o.name = 'FK_LOAIPHON_RELATIONS_KHACHSAN')
alter table LOAIPHONG
   drop constraint FK_LOAIPHON_RELATIONS_KHACHSAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('NHANXET') and o.name = 'FK_NHANXET_NHANXET_KHACHSAN')
alter table NHANXET
   drop constraint FK_NHANXET_NHANXET_KHACHSAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('NHANXET') and o.name = 'FK_NHANXET_NHANXET2_KHACHHAN')
alter table NHANXET
   drop constraint FK_NHANXET_NHANXET2_KHACHHAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PHIEUDAT') and o.name = 'FK_PHIEUDAT_RELATIONS_KHACHHAN')
alter table PHIEUDAT
   drop constraint FK_PHIEUDAT_RELATIONS_KHACHHAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PHONG') and o.name = 'FK_PHONG_RELATIONS_LOAIPHON')
alter table PHONG
   drop constraint FK_PHONG_RELATIONS_LOAIPHON
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CHITIETKM')
            and   name  = 'CHITIETKM_FK'
            and   indid > 0
            and   indid < 255)
   drop index CHITIETKM.CHITIETKM_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CHITIETKM')
            and   name  = 'CHITIETKM2_FK'
            and   indid > 0
            and   indid < 255)
   drop index CHITIETKM.CHITIETKM2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CHITIETKM')
            and   type = 'U')
   drop table CHITIETKM
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CTPHIEUDAT')
            and   name  = 'CTPHIEUDAT_FK'
            and   indid > 0
            and   indid < 255)
   drop index CTPHIEUDAT.CTPHIEUDAT_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CTPHIEUDAT')
            and   name  = 'CTPHIEUDAT2_FK'
            and   indid > 0
            and   indid < 255)
   drop index CTPHIEUDAT.CTPHIEUDAT2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CTPHIEUDAT')
            and   type = 'U')
   drop table CTPHIEUDAT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KHACHHANG')
            and   type = 'U')
   drop table KHACHHANG
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KHACHSAN')
            and   type = 'U')
   drop table KHACHSAN
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KHUYENMAI')
            and   type = 'U')
   drop table KHUYENMAI
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('LOAIPHONG')
            and   name  = 'RELATIONSHIP_1_FK'
            and   indid > 0
            and   indid < 255)
   drop index LOAIPHONG.RELATIONSHIP_1_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('LOAIPHONG')
            and   type = 'U')
   drop table LOAIPHONG
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('NHANXET')
            and   name  = 'NHANXET_FK'
            and   indid > 0
            and   indid < 255)
   drop index NHANXET.NHANXET_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('NHANXET')
            and   name  = 'NHANXET2_FK'
            and   indid > 0
            and   indid < 255)
   drop index NHANXET.NHANXET2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('NHANXET')
            and   type = 'U')
   drop table NHANXET
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PHIEUDAT')
            and   name  = 'RELATIONSHIP_3_FK'
            and   indid > 0
            and   indid < 255)
   drop index PHIEUDAT.RELATIONSHIP_3_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PHIEUDAT')
            and   type = 'U')
   drop table PHIEUDAT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PHONG')
            and   name  = 'RELATIONSHIP_7_FK'
            and   indid > 0
            and   indid < 255)
   drop index PHONG.RELATIONSHIP_7_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PHONG')
            and   type = 'U')
   drop table PHONG
go

/*==============================================================*/
/* Table: CHITIETKM                                             */
/*==============================================================*/
create table CHITIETKM (
   MALOAI               NVARCHAR(10)             not null,
   MAKM                 NVARCHAR(10)             not null,
   NGAYBD               datetime             null,
   NGAYKT               datetime             null,
   constraint PK_CHITIETKM primary key nonclustered (MALOAI, MAKM)
)
go

/*==============================================================*/
/* Index: CHITIETKM2_FK                                         */
/*==============================================================*/
create index CHITIETKM2_FK on CHITIETKM (
MALOAI ASC
)
go

/*==============================================================*/
/* Index: CHITIETKM_FK                                          */
/*==============================================================*/
create index CHITIETKM_FK on CHITIETKM (
MAKM ASC
)
go

/*==============================================================*/
/* Table: CTPHIEUDAT                                            */
/*==============================================================*/
create table CTPHIEUDAT (
   SOPHIEU              NVARCHAR(10)             not null,
   SOPH                 NVARCHAR(10)             not null,
   SONGUOI              int                  null,
   NGAYDAT              datetime             null,
   NGAYNHAN             datetime             null,
   NGAYTRA              datetime             null,
   constraint PK_CTPHIEUDAT primary key nonclustered (SOPHIEU, SOPH)
)
go

/*==============================================================*/
/* Index: CTPHIEUDAT2_FK                                        */
/*==============================================================*/
create index CTPHIEUDAT2_FK on CTPHIEUDAT (
SOPHIEU ASC
)
go

/*==============================================================*/
/* Index: CTPHIEUDAT_FK                                         */
/*==============================================================*/
create index CTPHIEUDAT_FK on CTPHIEUDAT (
SOPH ASC
)
go

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG (
   MAKH                 NVARCHAR(10)             not null,
   HOTEN                NVARCHAR(30)             null,
   DIACHI               NVARCHAR(100)            null,
   SDT                  NVARCHAR(10)             null,
   GT                   NVARCHAR(5)              null,
   EMAIL                NVARCHAR(30)             null,
   MATKHAU              NVARCHAR(15)             null,
   constraint PK_KHACHHANG primary key nonclustered (MAKH)
)
go

/*==============================================================*/
/* Table: KHACHSAN                                              */
/*==============================================================*/
create table KHACHSAN (
   MAKS                 NVARCHAR(10)             not null,
   TENKS                NVARCHAR(50)             null,
   DIACHI               NVARCHAR(100)            null,
   SDT                  NVARCHAR(15)             null,
   EMAIL                NVARCHAR(30)             null,
   constraint PK_KHACHSAN primary key nonclustered (MAKS)
)
go

/*==============================================================*/
/* Table: KHUYENMAI                                             */
/*==============================================================*/
create table KHUYENMAI (
   MAKM                 NVARCHAR(10)             not null,
   TEKM                 NVARCHAR(30)             null,
   MUCKM                int                  null,
   constraint PK_KHUYENMAI primary key nonclustered (MAKM)
)
go

/*==============================================================*/
/* Table: LOAIPHONG                                             */
/*==============================================================*/
create table LOAIPHONG (
   MALOAI               NVARCHAR(10)             not null,
   MAKS                 NVARCHAR(10)             not null,
   TENLOAI              NVARCHAR(30)             null,
   GIA                  money                null,
   MOTA                 NVARCHAR(200)            null,
   SONGUOITOIDA         int                  null,
   constraint PK_LOAIPHONG primary key nonclustered (MALOAI)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on LOAIPHONG (
MAKS ASC
)
go

/*==============================================================*/
/* Table: NHANXET                                               */
/*==============================================================*/
create table NHANXET (
   MAKH                 NVARCHAR(10)             not null,
   MAKS                 NVARCHAR(10)             not null,
   THONGTINPHANHOI      NVARCHAR(200)            null,
   constraint PK_NHANXET primary key nonclustered (MAKH, MAKS)
)
go

/*==============================================================*/
/* Index: NHANXET2_FK                                           */
/*==============================================================*/
create index NHANXET2_FK on NHANXET (
MAKH ASC
)
go

/*==============================================================*/
/* Index: NHANXET_FK                                            */
/*==============================================================*/
create index NHANXET_FK on NHANXET (
MAKS ASC
)
go

/*==============================================================*/
/* Table: PHIEUDAT                                              */
/*==============================================================*/
create table PHIEUDAT (
   SOPHIEU              NVARCHAR(10)             not null,
   MAKH                 NVARCHAR(10)             not null,
   NGAYTT               datetime             null,
   TONGTIEN             money                null,
   constraint PK_PHIEUDAT primary key nonclustered (SOPHIEU)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on PHIEUDAT (
MAKH ASC
)
go

/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG (
   SOPH                 NVARCHAR(10)             not null,
   MALOAI               NVARCHAR(10)             not null,
   TENPH                NVARCHAR(30)             null,
   TINHTRANG            NVARCHAR(10)             null,
   MOTA                 NVARCHAR(200)            null,
   ANH                  NVARCHAR(200)            null,
   constraint PK_PHONG primary key nonclustered (SOPH)
)
go

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on PHONG (
MALOAI ASC
)
go

alter table CHITIETKM
   add constraint FK_CHITIETK_CHITIETKM_KHUYENMA foreign key (MAKM)
      references KHUYENMAI (MAKM)
go

alter table CHITIETKM
   add constraint FK_CHITIETK_CHITIETKM_LOAIPHON foreign key (MALOAI)
      references LOAIPHONG (MALOAI)
go

alter table CTPHIEUDAT
   add constraint FK_CTPHIEUD_CTPHIEUDA_PHONG foreign key (SOPH)
      references PHONG (SOPH)
go

alter table CTPHIEUDAT
   add constraint FK_CTPHIEUD_CTPHIEUDA_PHIEUDAT foreign key (SOPHIEU)
      references PHIEUDAT (SOPHIEU)
go

alter table LOAIPHONG
   add constraint FK_LOAIPHON_RELATIONS_KHACHSAN foreign key (MAKS)
      references KHACHSAN (MAKS)
go

alter table NHANXET
   add constraint FK_NHANXET_NHANXET_KHACHSAN foreign key (MAKS)
      references KHACHSAN (MAKS)
go

alter table NHANXET
   add constraint FK_NHANXET_NHANXET2_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH)
go

alter table PHIEUDAT
   add constraint FK_PHIEUDAT_RELATIONS_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH)
go

alter table PHONG
   add constraint FK_PHONG_RELATIONS_LOAIPHON foreign key (MALOAI)
      references LOAIPHONG (MALOAI)
go


--Insert KHACHSAN
INSERT INTO KHACHSAN VALUES('KS01',N'Khách Sạn Equatorial TP.HCM',N'242 Trần Bình Trọng, P. 4, Q. 5, Tp. Hồ Chí Minh','(0235)38397777','info@hcm.equatorial.com');
INSERT INTO KHACHSAN VALUES ('KS02',N'Khách Sạn Phương Đông',N'5 Đống Đa, P. Thạch Thang, Q. Hải Châu, Tp. Đà Nẵng','(0236)25121021','saigontourane.dng@gmail.com');
INSERT INTO KHACHSAN VALUES ('KS03',N'Khách Sạn Rạng Đông',N'124 P. Ghềnh Ráng,Mai Hắc Đế, Tp. Quy Nhơn, Bình Định','(0256) 3546185','khangkhanghotel@gmail.com');
--Insert LOAIPHONG
INSERT INTO LOAIPHONG VALUES('LP01','KS01',N'Phòng đơn',250000,N'Phòng riêng cho một người, thường chỉ bao gồm một giường đơn phù hợp với một người.',1),
('LP02','KS02',N'Phòng đơn',270000,N'Phòng riêng cho một người, thường chỉ bao gồm một giường đơn phù hợp với một người.',1),
('LP03','KS03',N'Phòng đơn',275000,N'Phòng riêng cho một người, thường chỉ bao gồm một giường đơn phù hợp với một người.',1)
INSERT INTO LOAIPHONG VALUES('LP04','KS01',N'Phòng đôi',500000,N'Phòng có một giường đôi hoặc hai giường đơn, tùy thuộc vào nhu cầu của khách hàng. Phòng đôi có diện tích trung bình từ 20 đến 30 mét vuông và được trang bị đầy đủ các tiện nghi cơ bản',2),
('LP05','KS02',N'Phòng đôi',550000,N'Phòng có một giường đôi hoặc hai giường đơn, tùy thuộc vào nhu cầu của khách hàng. Phòng đôi có diện tích trung bình từ 20 đến 30 mét vuông và được trang bị đầy đủ các tiện nghi cơ bản',2),
('LP06','KS03',N'Phòng đôi',600000,N'Phòng có một giường đôi hoặc hai giường đơn, tùy thuộc vào nhu cầu của khách hàng. Phòng đôi có diện tích trung bình từ 20 đến 30 mét vuông và được trang bị đầy đủ các tiện nghi cơ bản',2)

INSERT INTO LOAIPHONG VALUES('LP07','KS01',N'Phòng gia đình',1000000,N'Phòng gia đình rộng hơn và có đủ chỗ ngủ cho một gia đình. Phòng này có thể gồm hai hoặc nhiều giường đơn hoặc giường đôi',6),
('LP08','KS02',N'Phòng gia đình',1100000,N'Phòng gia đình rộng hơn và có đủ chỗ ngủ cho một gia đình. Phòng này có thể gồm hai hoặc nhiều giường đơn hoặc giường đôi',6),
('LP09','KS03',N'Phòng gia đình',1200000,N'Phòng gia đình rộng hơn và có đủ chỗ ngủ cho một gia đình. Phòng này có thể gồm hai hoặc nhiều giường đơn hoặc giường đôi',6)
SELECT * FROM PHONG
--insert PHONG
INSERT INTO PHONG VALUES('P001','LP01',N'Phòng 01',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P002','LP01',N'Phòng 02',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P003','LP01',N'Phòng 03',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P004','LP02',N'Phòng 04',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P005','LP02',N'Phòng 05',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P006','LP02',N'Phòng 06',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P007','LP03',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P008','LP03',N'Phòng 05',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P009','LP03',N'Phòng 06',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0010','LP03',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
SELECT * FROM PHONG
INSERT INTO PHONG VALUES('P0011','LP04',N'Phòng 01',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0012','LP04',N'Phòng 02',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0013','LP04',N'Phòng 03',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0014','LP05',N'Phòng 04',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0015','LP05',N'Phòng 05',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0016','LP05',N'Phòng 06',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0017','LP06',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0018','LP06',N'Phòng 05',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0019','LP06',N'Phòng 06',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0020','LP06',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');

INSERT INTO PHONG VALUES('P0021','LP07',N'Phòng 01',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0022','LP07',N'Phòng 02',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0023','LP07',N'Phòng 03',N'Trống',N'','https://cdn3.ivivu.com/2014/01/SUPER-DELUXE2.jpg');
INSERT INTO PHONG VALUES('P0024','LP08',N'Phòng 04',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0025','LP08',N'Phòng 05',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0026','LP08',N'Phòng 06',N'Trống',N'','https://dulichmocchau.org/view/at_hinh-anh-khach-san-2-sao-tai-moc-chau_afbf10a282aa5120d9346ac08e741ac2.jpg');
INSERT INTO PHONG VALUES('P0027','LP09',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0028','LP09',N'Phòng 05',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0029','LP09',N'Phòng 06',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');
INSERT INTO PHONG VALUES('P0030','LP09',N'Phòng 07',N'Trống',N'','https://khachsanngocthanh2.com/wp-content/uploads/2017/11/phong-gia-dinh-2.jpg');


