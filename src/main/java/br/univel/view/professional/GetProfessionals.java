package br.univel.view.professional;

import br.univel.client.RequestClient;
import br.univel.enums.OperationType;
import br.univel.model.Professional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by felipefrizzo on 25/11/16.
 */
public class GetProfessionals {
    private final RequestClient client;
    private ObservableList<Professional> list = FXCollections.observableArrayList();
    private ArrayList<Professional> professionals = new ArrayList<>();

    public GetProfessionals(final RequestClient client) {
        Objects.requireNonNull(client, "Client socket cannot be null");

        this.client = client;

        Professional professional = new Professional();
        professional.setOperationType(OperationType.GET);

        this.professionals = (ArrayList<Professional>) this.client.sendObject(professional);
        this.professionals.forEach(p -> list.add(p));
    }

    public ObservableList<Professional> getList() {
        return list;
    }
}
