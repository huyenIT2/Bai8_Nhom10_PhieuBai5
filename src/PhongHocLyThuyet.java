
import java.util.Scanner;

public class PhongHocLyThuyet extends PhongHoc {

    private boolean mayChieu;

    public boolean isMayChieu() {
        return mayChieu;
    }

    public void setMayChieu(boolean mayChieu) {
        this.mayChieu = mayChieu;
    }

    public PhongHocLyThuyet() {
    }

    public PhongHocLyThuyet(String maPhong, String dayNha, float dienTich, int soBongDen, boolean mayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.mayChieu = mayChieu;
    }
      
    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);     
        super.Nhap();
        System.out.print("Nhap co may chieu khong? (true/false) ");
        mayChieu = sc.nextBoolean();
    }
     
    @Override
    public boolean xetDatChuan(){
        return super.xetDatChuan() && isMayChieu();
    } 
    
    @Override
    public void Xuat(){
        String datChuan, coMayChieu;
        if (xetDatChuan()) {
            datChuan = "Co";
            coMayChieu = "Co";
        }            
        else {
            datChuan = "Khong";
            coMayChieu = "Khong";
        }            
        super.Xuat();
        System.out.printf("%15s %15s %n", coMayChieu, datChuan);
    }
    public static void inTieuDe(){
        PhongHoc.inTieuDe();
        System.out.printf("%15s %15s %n","May chieu", "Dat chuan" );
    }
}
