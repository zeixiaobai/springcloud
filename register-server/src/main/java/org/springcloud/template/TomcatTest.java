package org.springcloud.template;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;

public class TomcatTest {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        new TomcatWebServer(tomcat);
    }
}
