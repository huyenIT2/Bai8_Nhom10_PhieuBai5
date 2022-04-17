
import java.util.Scanner;

public abstract class PhongHoc {

    protected String maPhong;
    protected String dayNha;
    protected float dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha, float dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public PhongHoc() {

    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public float getDienTich() {
        return dienTich;
    }

    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phong: ");
        maPhong = sc.nextLine();
        System.out.print("Nhap day nha: ");
        dayNha = sc.nextLine();
        System.out.print("Nhap dien tich: ");
        dienTich = sc.nextFloat();
        System.out.print("Nhap so bong den: ");
        soBongDen = sc.nextInt();
    }
    public void Xuat(){
        System.out.printf("%15s %15s %15.2f %15d", maPhong, dayNha, dienTich, soBongDen);
    }
    public static void inTieuDe(){
        System.out.printf("%15s %15s %15s %15s", "Ma Phong", "Day Nha", "Dien Tich", "So Bong Den");
    }
       
    public boolean xetDatChuan(){
        return dienTich/10 <= soBongDen;
    }
    
    public int getSoMay() {
        return 0;
    }
    
    public void setSoMay(int soMay) {
        
    }
}
