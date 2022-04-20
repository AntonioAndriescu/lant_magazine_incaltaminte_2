package org.example.ViewModel.Commands;

import org.example.Model.Persistenta.PersistentaUtilizator;
import org.example.Model.Utilizator;
import org.example.View.AdministratorView;
import org.example.View.AngajatView;
import org.example.ViewModel.VMLogin;

import java.sql.SQLException;

public class LoginButton implements Command {
    private String username;
    private String password;

    public LoginButton (VMLogin login, String s1, String s2) {
        this.username = s1;
        this.password = s2;
    }

    @Override
    public void execute() {
        try {
            for(Utilizator u : PersistentaUtilizator.unmarshal().getUtilizatori()) {
                if(username.equals(u.getUsername()) && password.equals(u.getParola()) && u.getFunctie().equals("administrator")) {
                    AdministratorView v = new AdministratorView();
                    break;
                } else if (username.equals(u.getUsername()) && password.equals(u.getParola()) && u.getFunctie().equals("angajat")) {
                    AngajatView v = new AngajatView();
                    break;
                } else {
                    System.out.println("Please enter valid username and password");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
