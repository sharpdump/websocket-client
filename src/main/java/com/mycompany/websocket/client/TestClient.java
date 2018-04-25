package com.mycompany.websocket.client;

import com.neovisionaries.ws.client.*;

public class TestClient
{
    public static void main(String[] args) throws Exception
    {
        WebSocket websocket = new WebSocketFactory()
            .createSocket("ws://localhost:8881/echo")
            .addListener(new WebSocketAdapter() {
                @Override
                public void onTextMessage(WebSocket ws, String message) {
                    System.out.println("Received msg: " + message);
                }
            })
            .connect();
        websocket.sendText("good");
        Thread.sleep(50000);
        // Don't forget to call disconnect() after use.
        websocket.disconnect();
    }
}