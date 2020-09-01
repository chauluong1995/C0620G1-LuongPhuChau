package case_study.furama_resort.models;

import case_study.furama_resort.commons.DocGhiFileCSV;

import java.util.List;
import java.util.Stack;

public class TuHoSo {
    public Stack<Employee> employeeStack = new Stack<>();

    public TuHoSo() {
        List<Employee> list = DocGhiFileCSV.docFileEmployee();
        for (Employee employee : list) {
            employeeStack.push(employee);
        }
    }
}
