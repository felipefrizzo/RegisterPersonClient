package br.univel.client.socket;

import br.univel.client.RequestClient;
import br.univel.model.Customer;
import br.univel.model.Professional;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public class ClientSocket implements RequestClient {
    @Override
    public Object sendObject(final Object object) {
        Objects.requireNonNull(object, "Object cannot be null");

        try (Socket socket = new Socket("localhost", 8080);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
            output.writeObject(object);
            output.flush();

            return input.readObject();
        } catch (ClassNotFoundException| IOException e) {
            throw new RuntimeException(e);
        }
    }
}
