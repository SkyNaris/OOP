package com.design.webserver;

import io.javalin.http.Handler;

public interface WebServer {
    // Цей метод ми викликаємо в Main
    void configure(String path, Handler handler);
    
    void start(int port);
}