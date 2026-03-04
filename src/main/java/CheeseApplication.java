package com.checkmarx.cheese;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class CheeseApplication implements QuarkusApplication {

    public static void main(String... args) {
        Quarkus.run(CheeseApplication.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Cheese App (Quarkus) - Vulnerability Test Application");
        System.out.println("WARNING: This application contains intentional security vulnerabilities");
        System.out.println("for SAST scanner testing purposes only!");
        Quarkus.waitForExit();
        return 0;
    }
}
