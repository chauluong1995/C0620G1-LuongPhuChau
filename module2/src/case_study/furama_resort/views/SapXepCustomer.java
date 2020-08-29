package case_study.furama_resort.views;

import case_study.furama_resort.models.Customer;

import java.util.Comparator;

public class SapXepCustomer implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        int ketQua = customer1.getHoTen().compareTo(customer2.getHoTen());
        if (ketQua != 0) return ketQua;
        else
            return Integer.parseInt(customer1.getNgaySinh().substring(6)) - Integer.parseInt(customer2.getNgaySinh().substring(6));
    }
}