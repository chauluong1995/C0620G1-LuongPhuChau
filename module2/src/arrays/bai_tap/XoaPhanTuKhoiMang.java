package arrays.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] mangSoNguyen = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần xóa khỏi mảng : ");
        int soCanXoa = scanner.nextInt();
        int viTriSoCanXoa = -1;

        for (int i=0;i<mangSoNguyen.length;i++){
            if (mangSoNguyen[i] == soCanXoa){
                viTriSoCanXoa = i;
            }
        }

        if (viTriSoCanXoa == -1){
            System.out.println("Số bạn nhập là " + soCanXoa + " , nó không có trong mảng số nguyên đã cho !");
            System.out.print("Mảng số nguyên đã cho là : ");
        }else if (viTriSoCanXoa == mangSoNguyen.length - 1){
            mangSoNguyen[mangSoNguyen.length-1] = 0;
            System.out.print("Mảng số nguyên sau khi xóa số " + soCanXoa + " là : ");
        }else {
            for (int j=viTriSoCanXoa;j<mangSoNguyen.length-1;j++){
                mangSoNguyen[j] = mangSoNguyen[j+1];
            }
            mangSoNguyen[mangSoNguyen.length-1] = 0;
            System.out.print("Mảng số nguyên sau khi xóa số " + soCanXoa + " là : ");
        }
        for (int element : mangSoNguyen) {
            System.out.print(element + " ");
        }
    }
}
