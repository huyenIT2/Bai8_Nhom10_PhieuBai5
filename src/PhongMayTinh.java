
import java.util.Scanner;

public class PhongMayTinh extends PhongHoc{
    private int soMay;

    public PhongMayTinh() {
    }

    public PhongMayTinh(String maPhong, String dayNha, float dienTich, int soBongDen, int soMay) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMay = soMay;
    }
    
    @Override
    public int getSoMay() {
        return soMay;
    }

    @Override
    public void setSoMay(int soMay) {
        this.soMay = soMay;
    }
    
    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);        
        super.Nhap();
        System.out.print("Nhap so may: ");
        soMay = sc.nextInt();        
    }
     
    @Override
    public boolean xetDatChuan(){
        return super.xetDatChuan() && dienTich/1.5<=soMay;
    } 
    
    @Override
    public void Xuat(){
        String datChuan;
        if (xetDatChuan()) {
            datChuan = "Co";
        }            
        else {
            datChuan = "Khong";
        }            
        super.Xuat();
        System.out.printf("%15s %15s %n", soMay, datChuan);
    }
    public static void inTieuDe(){
        PhongHoc.inTieuDe();
        System.out.printf("%15s %15s %n","So may", "Dat chuan" );
    }
}
