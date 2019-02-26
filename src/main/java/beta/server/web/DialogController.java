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

/**
 * Controller for the Aufgabe 2 website checks if the Contact is valid then saves it
 * in a List. For incorrect input it has Violationmessages.
 *
 * @author alexander.lohmann
 */
@Named
@ViewScoped
public class DialogController implements Serializable {

    /**
     * String to use for violation Message.
     */
    private String violateMessage = "Bitte zuerst eine Kommunikationsart auswählen";
    /**
     * String to use for Pattern.
     */
    private String mask;
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
     * Communication to save into communicationlist after inputs.
     */
    private Communication communication = new Communication();
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
    public String getViolateMessage() {
        return violateMessage;
    }

    public String getMask() {
        return mask;
    }

    public String getViolationMessage() {
        return violationMessage;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Communication getCommunication() {
        return communication;
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
     * Sets the chosen Communication type to the current communication. When the
     * input is valid it saves the Communication in an List.
     */
    public void createNewCommunication() {
        communications.add(communication);
        communication = new Communication();
    }

    /**
     * Sets the Mask to use for input Pattern and the violation Message for that
     * pattern.
     */
    public void setsMaskAndVioMessage() {
        if (communication.getType() != null) {
            if ("PHONE".equals(communication.getType().name())) {
                mask = Communication.PHONE_PATTERN;
                violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
            } else if ("MOBILE".equals(communication.getType().name())) {
                mask = Communication.PHONE_PATTERN;
                violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
            } else if ("FAX".equals(communication.getType().name())) {
                mask = Communication.PHONE_PATTERN;
                violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
            } else if ("EMAIL".equals(communication.getType().name())) {
                mask = Communication.EMAIL_PATTERN;
                violateMessage = "Bitte mit folgendem Muster Eingeben : beispiel@beispiel.beispiel";
            } else if ("ICQ".equals(communication.getType().name())) {
                mask = "^(?=.*\\d).+$";
                violateMessage = "Bitte eine Gültige Nummer eingeben.";
            } else if ("FACEBOOK".equals(communication.getType().name())) {
                mask = "[A-Za-z0-9]{1,999}";
                violateMessage = "Bitte gültigen Benutzernamen oder Email eingeben.";
            } else if ("SKYPE".equals(communication.getType().name())) {
                mask = "[A-Za-z0-9]{1,999}";
                violateMessage = "Bitte gültigen Benutzernamen oder Email eingeben.";
            } else {
                violateMessage = "Bitte zuerst eine Kommunikationsart auswählen";
            }
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
        if ("FEMALE".equals(contact.getSex().FEMALE.name())) {
            contact.setSex(Sex.FEMALE);
        } else if ("MALE".equals(contact.getSex().MALE.name())) {
            contact.setSex(Sex.MALE);
        } else {
            contact.setSex(null);
        }
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