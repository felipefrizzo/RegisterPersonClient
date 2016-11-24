package br.univel.model;

import br.univel.enums.OperationType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDate birthday;
    private String cpf;
    private String rg;
    private OperationType operationType;

    /**
     * Initializes a newly created instance of this type without specific arguments.
     */
    public Customer() {
    }

    /**
     * Initializes a newly created instance of this type with specific arguments.
     *
     * @param name
     * @param birthday
     * @param cpf
     * @param rg
     * @param operationType
     */
    public Customer(final String name, final LocalDate birthday, final String cpf, final String rg, final OperationType operationType) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(cpf, "Cpf cannot be null");
        Objects.requireNonNull(rg, "Rg cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.rg = rg;
        this.operationType = operationType;
    }

    /**
     *
     * @return The current value of this Customer's ID
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id New Value for this Customer's Id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     *
     * @return The current value of this Customer's Name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name New Value for this Customer's Name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return The current value of this Customer's Birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday New Value for this Customer's Birthday
     */
    public void setBirthday(final LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     *
     * @return The current value of this Customer's Cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf New Value for this Customer's Cpf
     */
    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return The current value of this Customer's Rg
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg New Value for this Customer's Rg
     */
    public void setRg(final String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return The current value of this Customer's Operation Type
     */
    public OperationType getOperationType() {
        return operationType;
    }

    /**
     *
     * @param operationType New Value for this Customer's Operation Type
     */
    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
