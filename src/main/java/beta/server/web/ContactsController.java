/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Address;
import beta.server.entity.Communication;
import beta.server.entity.Communication.Type;
import beta.server.entity.Contact;
import beta.server.entity.Sex;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller to create a new Contact, checks for validation on the Contact
 * saves it in a List.
 *
 * @author alexander.lohmann
 */
@Named("ContactDialogController")
@ViewScoped
public class ContactsController implements Serializable {

    private final Logger L = LoggerFactory.getLogger(ContactsController.class);

    /**
     * ArrayList to store new Contacts in.
     */
    private final ArrayList<Contact> contacts = new ArrayList<>();
    /**
     * Contact to save in ContactList after inputs.
     */
    private Contact contact = new Contact();

    /**
     * ArrayList containing the Strings for the selectoneMenu of Type.
     */
    private final List<String> types = new ArrayList<>();
    /**
     * ArrayList containing the Strings for the selectoneMenu of Sex.
     */
    private final List<String> sexs = new ArrayList<>();

    // Getter
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact() {
        return contact;
    }

    public List<String> getTypes() {
        return types;
    }

    public List<String> getSexs() {
        return sexs;
    }

    /**
     * Fills the communications and Sexs lists.
     */
    @PostConstruct
    private void filldata() {
        for (Type typea : Communication.Type.values()) {
            types.add(typea.name());
        }
        for (Sex sexa : Sex.values()) {
            sexs.add(sexa.name());
        }
    }

    /**
     * Saves the inputed Strings to a new Contact when there is no
     * violationMessage and holds it in contacts ArrayList.
     */
    public void createNewContact() {

        //if (contact.getViolationMessage() == null) {
        contacts.add(contact);
        //} else {
        // violationMessage = contact.getViolationMessage();
        //}
    }

    /**
     * Clears Contact all its Communications and its Adresses.
     */
    public void getNewContact() {
        L.info("getNewContact() wurde aufgerufen");
        contact = new Contact();
    }
}
