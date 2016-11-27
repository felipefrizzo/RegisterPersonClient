package br.univel.view.customer;

import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 27/11/16.
 */
public class GetCustomers {
    private final RequestClient client;
    private ObservableList<Customer> list = FXCollections.observableArrayList();
    private ArrayList<Customer> customers = new ArrayList<>();

    public GetCustomers(final RequestClient client) {
        Objects.requireNonNull(client, "Client socket cannot be null");
        this.client = client;

        Customer customer = new Customer();
        customer.setOperationType(OperationType.GET);
        System.out.println(customer.getOperationType());
        this.customers = (ArrayList<Customer>) this.client.sendObject(customer);
        this.customers.forEach(c -> list.add(c));
    }

    public ObservableList<Customer> getList() {
        return list;
    }
}
