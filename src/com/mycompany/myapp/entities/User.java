/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author USER-PC
 */
public class User {
    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private int Enabled;
    private String Password;
    private String Last_login;
    private String Confirmation_token;
    private String Password_request_at;
    private String Roles;
    private String sexe;
    private int tel;
    private String image;
    private String ville;
    

    public User(){}

    public User(int id, String username,String username_canonical,String email,String email_canonical, int Enabled,String Password, String Last_login, String Confirmation_token, String Password_request_at, String Roles, String sexe,int tel, String image, String ville) {
        this.id = id;
        this.username = username;
        this.username_canonical= username_canonical;
        this.email = email;
        this.email_canonical=email_canonical;
        this.Enabled = Enabled;
        this.Password = Password;
        this.Last_login = Last_login;
        this.Confirmation_token = Confirmation_token;
        this.Password_request_at = Password_request_at;
        this.Roles = Roles;
        this.tel=tel;
        this.sexe = sexe;
        this.image = image;
        this.ville = ville;
    }
     public User( String username,String username_canonical,String email,String email_canonical, int Enabled,String Password, String Last_login, String Confirmation_token, String Password_request_at, String Roles, String sexe,int tel, String image, String ville) {
        
        this.username = username;
        this.username_canonical= username_canonical;
        this.email = email;
        this.email_canonical=email_canonical;
        this.Enabled = Enabled;
        this.Password = Password;
        this.Last_login = Last_login;
        this.Confirmation_token = Confirmation_token;
        this.Password_request_at = Password_request_at;
        this.Roles = Roles;
        this.tel=tel;
        this.sexe = sexe;
        this.image = image;
        this.ville = ville;
    }
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

 


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

   

    /**
     * @return the Enabled
     */
    public int getEnabled() {
        return Enabled;
    }

    /**
     * @param Enabled the Enabled to set
     */
    public void setEnabled(int Enabled) {
        this.Enabled = Enabled;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Last_login
     */
    public String getLast_login() {
        return Last_login;
    }

    /**
     * @param Last_login the Last_login to set
     */
    public void setLast_login(String Last_login) {
        this.Last_login = Last_login;
    }

    /**
     * @return the Confirmation_token
     */
    public String getConfirmation_token() {
        return Confirmation_token;
    }

    /**
     * @param Confirmation_token the Confirmation_token to set
     */
    public void setConfirmation_token(String Confirmation_token) {
        this.Confirmation_token = Confirmation_token;
    }

    /**
     * @return the Password_request_at
     */
    public String getPassword_request_at() {
        return Password_request_at;
    }

    /**
     * @param Password_request_at the Password_request_at to set
     */
    public void setPassword_request_at(String Password_request_at) {
        this.Password_request_at = Password_request_at;
    }

    /**
     * @return the Roles
     */
    public String getRoles() {
        return Roles;
    }

    /**
     * @param Roles the Roles to set
     */
    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", Enabled=" + Enabled + ", Password=" + Password + ", Last_login=" + Last_login + ", Confirmation_token=" + Confirmation_token + ", Password_request_at=" + Password_request_at + ", Roles=" + Roles + ", sexe=" + sexe + ", tel=" + tel + ", image=" + image + ", ville=" + ville + '}';
    }
    
}

