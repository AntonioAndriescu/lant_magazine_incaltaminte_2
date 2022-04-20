package org.example.ViewModel;

import org.example.ViewModel.Commands.Command;
import org.example.ViewModel.Commands.LoginButton;

public class VMLogin {
    public Command login;
    private String userValue = "";
    private String passValue = "";

    public void instantiereComenzi() {
        login = new LoginButton(this, userValue, passValue);
    }

    public void setUserValue(String userValue) {
        this.userValue = userValue;
    }

    public void setPassValue(String passValue) {
        this.passValue = passValue;
    }
}
