package io_text_file.thuc_hanh;

public class NotFoundProductException extends Exception {
    public void getMassage(){
        System.out.println("Sản phẩm không tồn tại !");
    }
}
