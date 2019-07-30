package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder browser = new StringBuilder();
        for (String url : urls) {
            if (isValidUrl(url)) {
                browser.append("Browsing: ").append(url ).append("!").append(System.lineSeparator());
            } else {
                browser.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return browser.toString();
    }

    private boolean isValidUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String call() {
        StringBuilder call = new StringBuilder();
        for (String number : numbers) {
            if (isValidNumber(number)) {
                call.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                call.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return call.toString();
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (Character.isLetter(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
