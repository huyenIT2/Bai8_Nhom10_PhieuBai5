
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class demo {

    static ArrayList<PhongHoc> dsPhong = new ArrayList<PhongHoc>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        KhoiTao();
        int chon;
        do {
            System.out.println();
            System.out.println("**************QUẢN LÝ PHÒNG HỌC**************");
            System.out.println("* 1. Thêm Phòng Học                         *");
            System.out.println("* 2. Tìm kiếm phòng học                     *");
            System.out.println("* 3. In danh sách phòng học                 *");
            System.out.println("* 4. In ra DS phòng học đạt chuẩn           *");
            System.out.println("* 5. Sắp xếp tăng dần theo cột dãy nhà      *");
            System.out.println("* 6. Sắp xếp giảm dần theo cột diện tích    *");
            System.out.println("* 7. Sắp xếp tăng dần theo cột bóng đèn     *");
            System.out.println("* 8. Cập nhật số lượng máy tính             *");
            System.out.println("* 9. Xóa phòng học                          *");
            System.out.println("* 10. In ra tổng số phòng học               *");
            System.out.println("* 11. In ra các phòng có 60 máy             *");
            System.out.println("* 12. Kết thúc chương trình                 *");
            System.out.println("*********************************************");
            System.out.print("Mời bạn nhập lựa chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    ThemPhong();
                    break;
                case 2:
                    TimKiemTheoMa();
                    break;
                case 3:
                    System.out.println("\t\t---------------DANH SACH PHONG HOC-----------------");
                    InDsPhong();
                    break;
                case 4:
                    InDsPhongDatChuan();
                    break;
                case 5:
                    SapXepTangTheoDayNha();
                    break;
                case 6:
                    SapXepGiamTheoDienTich();
                    break;
                case 7:
                    SapXepTangTheoBongDen();
                    break;
                case 8:
                    CapNhatSLMayTinhTheoMa();
                    break;
                case 9:
                    XoaPhongHoc();
                    break;
                case 10:
                    InTongSoPhong();
                    break;
                case 11:
                    InCacPhongCo60May();
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Không hợp lệ");
                    break;
            }

        } while (chon != 12);
    }
    
    private static void KhoiTao() {
        PhongHocLyThuyet p1 = new PhongHocLyThuyet("P01", "A1", 50.2f, 8, true);
        dsPhong.add(p1);
        PhongMayTinh p2 = new PhongMayTinh("P02", "A9", 25.2f, 5, 12);
        dsPhong.add(p2);
        PhongThiNghiem p3 = new PhongThiNghiem("P03", "A10", 30.5f, 2, "CNTT", 20, false);
        dsPhong.add(p3);
    }

    private static void ThemPhong() {
        int chon;
        System.out.println("Nhập: 1. Phòng lý thuyết; 2. Phòng máy tính; 3.Phòng thí nghiệm");
        System.out.print("Moi ban chon: ");
        chon = sc.nextInt();
        PhongHoc phong;
        switch (chon) {
            case 1:
                phong = new PhongHocLyThuyet();
                break;
            case 2:
                phong = new PhongMayTinh();
                break;
            default:
                phong = new PhongThiNghiem();
                break;
        }
        phong.Nhap();
        for (int j = 0; j < dsPhong.size(); j++) {
            if (phong.getMaPhong().compareToIgnoreCase(dsPhong.get(j).getMaPhong()) == 0) {
                System.out.println("Mã phòng đã tồn tại");
                return;
            }           
        }        
        dsPhong.add(phong);
    }

    private static void TimKiemTheoMa() {
        String maP;
        System.out.print("Nhap ma phong can tim: ");
        maP = sc.nextLine();
        
        System.out.println("\t=> THONG TIN PHONG HOC CO MA " + maP);
        for (PhongHoc item : dsPhong)
            if (item.getMaPhong().compareToIgnoreCase(maP) == 0) {
                if (item instanceof PhongHocLyThuyet) 
                    PhongHocLyThuyet.inTieuDe();
                else if (item instanceof PhongMayTinh)
                    PhongMayTinh.inTieuDe();
                else
                    PhongThiNghiem.inTieuDe();   
                item.Xuat();
            }       
    }

    private static void InDsPhong() {
        System.out.println("*Danh sach phong hoc ly thuyet:");
        PhongHocLyThuyet.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongHocLyThuyet) {
                item.Xuat();
            }
        }
        System.out.println("*Danh sach phong may tinh:");
        PhongMayTinh.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongMayTinh) {
                item.Xuat();
            }
        }
        System.out.println("*Danh sach phong thi nghiem:");
        PhongThiNghiem.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongThiNghiem) {
                item.Xuat();
            }
        }
    }

    private static void InDsPhongDatChuan() {
        System.out.println("\t=> DANH SACH PHONG HOC DAT CHUAN");
        System.out.println("*Danh sach phong hoc ly thuyet:");
        PhongHocLyThuyet.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongHocLyThuyet && item.xetDatChuan()) {
                item.Xuat();
            }
        }
        System.out.println("*Danh sach phong may tinh:");
        PhongMayTinh.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongMayTinh && item.xetDatChuan()) {
                item.Xuat();
            }
        }
        System.out.println("*Danh sach phong thi nghiem:");
        PhongThiNghiem.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongThiNghiem && item.xetDatChuan()) {
                item.Xuat();
            }
        }
    }

    private static void SapXepTangTheoDayNha() {
        Comparator<PhongHoc> c1 = new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc t1, PhongHoc t2) {
                return t1.getDayNha().compareTo(t2.getDayNha());
            }
        };
        
        dsPhong.sort(c1);
        System.out.println("\t=>DANH SACH PHONG HOC SAU KHI SAP XEP TANG DAN THEO DAY NHA");
        InDsPhong();
    }

    private static void SapXepGiamTheoDienTich() {
        Comparator<PhongHoc> c1 = new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc t1, PhongHoc t2) {
                return (int) (t2.getDienTich() - t1.getDienTich());
            }
        };

        dsPhong.sort(c1);
        System.out.println("\t=>DANH SACH PHONG HOC SAU KHI SAP XEP GIAM DAN THEO DIEN TICH");
        InDsPhong();
    }

    private static void SapXepTangTheoBongDen() {
        Comparator<PhongHoc> c1 = new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc t1, PhongHoc t2) {
                return t1.getSoBongDen()- t2.getSoBongDen();
            }
        };
        dsPhong.sort(c1);
        System.out.println("\t=>DANH SACH PHONG HOC SAU KHI SAP XEP TANG DAN THEO BONG DEN");
        InDsPhong();
    }

    private static void CapNhatSLMayTinhTheoMa() {
        System.out.print("Nhap ma phong can cap nhat: ");
        String maP = sc.nextLine();
        for (int i=0; i<dsPhong.size(); i++)
            if (dsPhong.get(i).getMaPhong().compareToIgnoreCase(maP) == 0) {
                System.out.print("Nhap so may tinh moi: ");
                int soMayMoi = sc.nextInt();
                dsPhong.get(i).setSoMay(soMayMoi);
            }    
        System.out.println("\t=>DANH SACH PHONG HOC SAU KHI CAP NHAT");
        InDsPhong();
    }

    private static void XoaPhongHoc() {
        System.out.print("Nhap ma phong can xoa: ");
        String maP = sc.nextLine();
        for (int i=0; i<dsPhong.size(); i++)
            if (dsPhong.get(i).getMaPhong().compareToIgnoreCase(maP) == 0) {
                dsPhong.remove(dsPhong.get(i));
            }   
        System.out.println("\t=>DANH SACH PHONG HOC SAU KHI XOA");
        InDsPhong();
    }

    private static void InTongSoPhong() {
        System.out.println("\t=> TONG SO PHONG: " + dsPhong.size());
    }

    private static void InCacPhongCo60May() {
        System.out.println("\t=>DANH SACH PHONG HOC MAY CO 60 MAY");
        PhongMayTinh.inTieuDe();
        for (PhongHoc item : dsPhong) {
            if (item instanceof PhongMayTinh && item.getSoMay() == 60) {               
                item.Xuat();
            }
        }
    }

}
