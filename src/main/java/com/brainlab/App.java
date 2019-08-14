package com.brainlab;

import io.javalin.Javalin;

/**
 * This application provides a REST API for performing mathematical operations.
 */
public class App {

    /**
     * Main entry point for the application.
     * Javalin server is run on http://localhost:5000/.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Javalin app = start();
    }

    /**
     * Helper function for starting the application.
     * @return Javalin server.
     */
    public static Javalin start() {
        Javalin app = Javalin.create().start(5000);
        app.get("/calculator/add", Routes::calculatorAdd);
        return app;
    }

}
