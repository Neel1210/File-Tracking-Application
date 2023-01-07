/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;


public class LoginPojo {

    public LoginPojo() {
    }

    public LoginPojo(String Email, String PassWord) {
        this.Email = Email;
        this.PassWord = PassWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    private String Email;
    private String PassWord;
}
