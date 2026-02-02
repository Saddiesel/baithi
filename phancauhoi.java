/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.ArrayList;
import java.util.List;

// 1. Thiết kế lớp cha 
abstract class NhanVien {
    private String maNV; // [cite: 102]
    private String tenNV;

    public NhanVien(String maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    // Getter/Setter để đảm bảo tính đóng gói [cite: 103]
    public String getTenNV() { return tenNV; }

    // Phương thức trừu tượng tính lương [cite: 94]
    public abstract double tinhLuong();
}

// 2. Lớp con FullTime 
class FullTime extends NhanVien {
    private double luongCoBan;
    private double heSoLuong;

    public FullTime(String maNV, String tenNV, double luongCoBan, double heSoLuong) {
        super(maNV, tenNV);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong; // [cite: 98]
    }
}

// 2. Lớp con PartTime 
class PartTime extends NhanVien {
    private double soGioLamViec;
    private double luongMoiGio;

    public PartTime(String maNV, String tenNV, double soGioLamViec, double luongMoiGio) {
        super(maNV, tenNV);
        this.soGioLamViec = soGioLamViec;
        this.luongMoiGio = luongMoiGio;
    }

    @Override
    public double tinhLuong() {
        return soGioLamViec * luongMoiGio; // [cite: 100]
    }
}

// Chương trình chính
public class Main {
    public static void main(String[] args) {
        // 3. Tính đa hình: Danh sách chứa lẫn lộn các loại nhân viên 
        List<NhanVien> danhSachNV = new ArrayList<>();
        danhSachNV.add(new FullTime("FT01", "Nguyen Van A", 5000000, 2.0));
        danhSachNV.add(new PartTime("PT01", "Tran Thi B", 80, 50000));

        // Sử dụng vòng lặp để in ra mà không cần check 
        for (NhanVien nv : danhSachNV) {
            System.out.println("Tên: " + nv.getTenNV() + " - Lương: " + nv.tinhLuong());
        }
    }
}