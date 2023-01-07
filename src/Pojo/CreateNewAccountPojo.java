/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Neel_Esh
 */
public class CreateNewAccountPojo {

    public CreateNewAccountPojo(String Email, String Password, int status) {
        this.Email = Email;
        this.Password = Password;
        this.status = status;
    }

    public CreateNewAccountPojo() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    private String Email;
    private String Password;
    private int status;
}
