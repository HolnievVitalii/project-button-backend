package com.button.repr;

import javax.validation.constraints.NotEmpty;

public class UserRepr {

    private Integer id;

    @NotEmpty
    private String login;

    @NotEmpty
    private String pass;

    @NotEmpty
    private String matchingPass;

    @NotEmpty
    private String name;

    private String surname;

    public UserRepr() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMatchingPass() {
        return matchingPass;
    }

    public void setMatchingPass(String matchingPass) {
        this.matchingPass = matchingPass;
    }
}
