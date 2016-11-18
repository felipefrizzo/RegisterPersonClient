package br.univel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date birthday;
    private String cpf;
    private String rg;

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
     */
    public Customer(final String name, final Date birthday, final String cpf, final String rg) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(cpf, "Cpf cannot be null");
        Objects.requireNonNull(rg, "Rg cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.rg = rg;
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
    public Date getBirthday() {
        return birthday;
    }

    /**
     *
     * @param birthday New Value for this Customer's Birthday
     */
    public void setBirthday(final Date birthday) {
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
}
