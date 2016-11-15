package br.univel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date birthday;
    private String cpf;
    private String rg;

    public Client() {
    }

    public Client(final String name, final Date birthday, final String cpf, final String rg) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(cpf, "Cpf cannot be null");
        Objects.requireNonNull(rg, "Rg cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(final String rg) {
        this.rg = rg;
    }
}
