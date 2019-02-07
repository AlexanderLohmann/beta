/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Contact;
import beta.server.entity.Sex;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author alexander.lohmann
 */
@Named
@ViewScoped
public class DialogController implements Serializable {

    /**
     * String to use for Title input.
     */
    private String title;

    /**
     * String to use for First Name input.
     */
    private String firstName;
    /**
     * String to use for Last Name input.
     */
    private String lastName;
    /**
     * String to use for sex input setup.
     */
    private String sex = "";

    /**
     * ArrayList to store new Contacts in.
     */
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Getter
    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    //Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void createNewContact() {
        
        Sex sexs;
        if ("Female".equals(sex)) {
            sexs = Sex.FEMALE;
        } else {
            sexs = Sex.MALE;
        }
        Contact blub = new Contact(sexs,title,firstName,lastName);
        if (blub.getViolationMessage() == null){
        contacts.add(blub);
        }
    }
}
