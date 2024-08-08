package com.andreidodu.andre_i_test.configuration.webdriverstrategy.common;

import org.openqa.selenium.Proxy;

public class WebDriverUtil {

    public static Proxy buildProxy() {
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setNoProxy("no_proxy-var");
        return proxy;
    }

    public static String calculateExtension(String os) {
        if ("windows".equalsIgnoreCase(os)) {
            return ".exe";
        }
        return "";
    }

}
