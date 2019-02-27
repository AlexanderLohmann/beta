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
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controller for the Aufgabe 2 website checks if the Contact is valid then
 * saves it in a List. For incorrect input it has Violationmessages.
 *
 * @author alexander.lohmann
 */
@Named("DialogController")
@ViewScoped
public class AufgabeZweiDialogController implements Serializable {

    /**
     * String with the violationMessage to ouput on Website if Contact is not
     * valid.
     */
    private String violationMessage;
    /**
     * Contact to save in ContactList after inputs.
     */
    private Contact contact = new Contact();
    /**
     * Adress to save into adresslist after inputs.
     */
    private Address address = new Address();

    /**
     * List to save inputed Communication in to use later for an new Contact.
     */
    private ArrayList<Communication> communications = new ArrayList<>();
    /**
     * List to save inputed Adress in to use later for an new Contact.
     */
    private ArrayList<Address> addresses = new ArrayList<>();
    /**
     * ArrayList to store new Contacts in.
     */
    private final ArrayList<Contact> contacts = new ArrayList<>();
    /**
     * ArrayList containing the Strings for the selectoneMenu of Type.
     */
    private final List<String> types = new ArrayList<>();
    /**
     * ArrayList containing the Strings for the selectoneMenu of Sex.
     */
    private final List<String> sexs = new ArrayList<>();

    // Getter
    public String getViolationMessage() {
        return violationMessage;
    }

    public ArrayList<Communication> getCommunications() {
        return communications;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
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
     * Sets the inputs to an address.
     */
    public void createNewAddress() {
        addresses.add(address);
        address = new Address();
    }

    /**
     * Saves the inputed Strings to a new Contact when there is no
     * violationMessage and holds it in contacts ArrayList.
     */
    public void createNewContact() {
        for (Address addresse : addresses) {
            contact.getAddresses().add(addresse);
        }
        for (Communication communication : communications) {
            contact.getCommunications().add(communication);
        }
        if (contact.getViolationMessage() == null) {
            contacts.add(contact);
            contact = new Contact();
            communications = new ArrayList();
            addresses = new ArrayList();
        } else {
            violationMessage = contact.getViolationMessage();
        }
    }
}
