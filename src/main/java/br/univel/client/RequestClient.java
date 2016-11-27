package br.univel.client;

/**
 * Created by felipefrizzo on 24/11/16.
 */
public interface RequestClient {

    /**
     * Send object to Server.
     *
     * @param object
     * @return it's returns the object that received from server
     */
    Object sendObject(final Object object);
}
