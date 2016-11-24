package br.univel.client.socket;

import br.univel.client.RequestClient;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public class ClientSocket implements RequestClient {
    @Override
    public void sendObject(final Object object) {
        Objects.requireNonNull(object, "Object cannot be null");

        try (Socket socket = new Socket("localhost", 8080);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream())) {
            output.writeObject(object);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
