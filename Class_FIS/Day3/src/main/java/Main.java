import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien("Ducnv", 5);
        SinhVien sv2 = new SinhVien("AA", 6);
        SinhVien sv3 = new SinhVien(" ANA", 1);
        SinhVien sv4 = new SinhVien("Kie", 3);
        List<SinhVien> list = Arrays.asList(sv1, sv2, sv3, sv4);
//        list.sort(Comparator.comparing(SinhVien::getDiem));
//        Comparator<SinhVien> com = Comparator.comparing(SinhVien::getDiem, Integer::compareTo);
        list.stream().sorted(Comparator.comparing(SinhVien::getDiem).reversed()).limit(10).forEach(System.out::println);
//        list.stream().filter(sv -> sv.getName().startsWith("A") && sv.getDiem() > 1).
//                forEach(System.out::println);

//        list.stream().filter(sv->sv.getName().st).filter()
//        list.stream().sorted(com).forEach(System.out::println);
    }
}
