package dsa_stack_queue.bai_tap;

import java.util.*;

public class DemergingUseQueue {
    public static void main(String[] args) {
        Queue<NhanVien> nu = new LinkedList<>();
        Queue<NhanVien> nam = new LinkedList<>();
        List<NhanVien> list = new ArrayList<>();
        list.add(new NhanVien("Nam", "01/01/1995"));
        list.add(new NhanVien("Nữ", "15/05/1995"));
        list.add(new NhanVien("Nam", "27/05/1995"));
        list.add(new NhanVien("Nữ", "08/10/1996"));
        list.add(new NhanVien("Nam", "18/10/1996"));
        System.out.println(list);

        for (NhanVien element : list) {
            if (element.getGioiTinh().equals("Nữ")) {
                nu.add(element);
            } else nam.add(element);
        }

        List<Object> listOutput = new ArrayList<>();
        while (!nu.isEmpty()) {
            listOutput.add(nu.remove());
        }
        while (!nam.isEmpty()) {
            listOutput.add(nam.remove());
        }
        System.out.println(listOutput);
    }
}

class NhanVien {
    private String gioiTinh;
    private String ngaySinh;

    public NhanVien(String gioiTinh, String ngaySinh) {
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    @Override
    public String toString() {
        return gioiTinh + " " + ngaySinh;
    }
}
