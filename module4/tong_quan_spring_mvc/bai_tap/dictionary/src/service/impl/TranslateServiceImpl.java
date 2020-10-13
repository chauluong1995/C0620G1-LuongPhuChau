package service.impl;

import org.springframework.stereotype.Service;
import service.TranslateService;

@Service
public class TranslateServiceImpl implements TranslateService {
    String[] englishs = {"school", "laptop", "notebook", "pen", "smartphone"};
    String[] vietnamese = {"Trường Học", "Máy Tính Xách Tay", "Quyển Vở", "Bút Bi", "Điện Thoại Thông Minh"};

    @Override
    public String translate(String english) {
        if (english.equals("")) {
            return "Chưa nhập thì làm sao mà tra cứu !";
        }
        for (int i = 0; i < englishs.length; i++) {
            if (englishs[i].equals(english)) {
                return "Từ " + english + " có nghĩa là : " + vietnamese[i];
            }
        }
        return english + " không có trong từ điển ! Thông cảm bộ nhớ từ điển có hạn !";
    }
}
