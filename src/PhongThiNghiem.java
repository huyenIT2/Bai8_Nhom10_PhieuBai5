
import java.util.Scanner;


public class PhongThiNghiem  extends PhongHoc{
    
    private String chuyenNganh;
    private int sucChua;
    private boolean bonRua;

    public String getChuyenNganh() {
        return chuyenNganh;
    }
    

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public float getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public boolean isBonRua() {
        return bonRua;
    }

    public void setBonRua(boolean bonRua) {
        this.bonRua = bonRua;
    }

    public PhongThiNghiem() {
    }

    public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean bonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.bonRua = bonRua;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);       
        super.Nhap();        
        System.out.print("Nhap chuyen nganh: ");
        chuyenNganh = sc.nextLine();
        System.out.print("Nhap suc chua: ");
        sucChua = sc.nextInt();
        System.out.print("Nhap co bon rua khong?(true/false) ");
        bonRua = sc.nextBoolean();
    }
     
    @Override
    public boolean xetDatChuan(){
        return super.xetDatChuan() && isBonRua();
    } 
    
    @Override
    public void Xuat(){
        String datChuan, coBonRua;
        if (xetDatChuan()) {
            datChuan = "Co";
            coBonRua = "Co";
        }            
        else {
            datChuan = "Khong";
            coBonRua = "Khong";
        }            
        super.Xuat();
        System.out.printf("%15s %15d %15s %15s %n",chuyenNganh, sucChua, coBonRua, datChuan);
    }
    public static void inTieuDe(){
        PhongHoc.inTieuDe();
        System.out.printf("%15s %15s %15s %15s %n", "Chuyen nganh", "Suc chua", "Bon rua", "Dat chuan");
    }
    
}
