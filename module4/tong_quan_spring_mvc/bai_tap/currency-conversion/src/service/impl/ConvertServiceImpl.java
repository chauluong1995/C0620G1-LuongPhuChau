package service.impl;

import org.springframework.stereotype.Service;
import service.ConvertService;

@Service
public class ConvertServiceImpl implements ConvertService {

    @Override
    public String convert(String usd, String rate) {
        String REGEX_NUMBER = "\\d+";
        if (!usd.matches(REGEX_NUMBER) || !rate.matches(REGEX_NUMBER)) {
            return "Invalid Data !";
        } else {
            double result;
            result = Double.parseDouble(usd) * Double.parseDouble(rate);
            return "Result : " + result + " VND .";
        }
    }
}
