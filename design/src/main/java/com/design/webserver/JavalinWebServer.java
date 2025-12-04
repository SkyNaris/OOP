package com.design.webserver;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class JavalinWebServer implements WebServer {

    private final Javalin app;

    public JavalinWebServer() {
        // Створення екземпляра Javalin
        this.app = Javalin.create();
    }

    @Override
    public void configure(String path, Handler handler) {
        // Прив'язуємо GET запит по шляху path до нашого handler (View)
        app.get(path, handler);
    }

    @Override
    public void start(int port) {
        app.start(port);
    }
}