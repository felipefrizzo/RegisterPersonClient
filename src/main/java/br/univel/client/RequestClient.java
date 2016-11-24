package br.univel.client;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public interface RequestClient {

    /**
     * Send object to Server.
     *
     * @param object
     */
    void sendObject(final Object object);
}
