package br.univel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class Professional implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date birthday;
    private String username;
    private String password;

    public Professional() {
    }

    public Professional(final String name, final Date birthday, final String username, final String password) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(birthday, "Birthday cannot be null");
        Objects.requireNonNull(username, "Cpf cannot be null");
        Objects.requireNonNull(password, "Rg cannot be null");

        this.name = name;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
