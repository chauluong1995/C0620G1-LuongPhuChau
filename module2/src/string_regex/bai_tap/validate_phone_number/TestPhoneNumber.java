package string_regex.bai_tap.validate_phone_number;

import java.util.Scanner;

public class TestPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();

        System.out.print("Input phone number need test : ");
        String phoneNumber = scanner.nextLine();

        boolean test = phoneNumberExample.validate(phoneNumber);

        System.out.println("Phone number " + phoneNumber + " is valid " + test);
    }
}
