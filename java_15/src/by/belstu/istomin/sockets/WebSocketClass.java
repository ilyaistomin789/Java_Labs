package by.belstu.istomin.sockets;

import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.RemoteEndpoint;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websocket")
public class WebSocketClass  extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote(); // для синхронной отправки
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        try {
            while (true) {
                Thread.sleep(2000);
                remoteEndpointBasic.sendText(format.format(new Date()));
            }
        } catch (InterruptedException | IOException e) {
            System.out.println(e);
        }
    }
}
