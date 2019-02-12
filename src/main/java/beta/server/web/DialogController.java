/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Address;
import beta.server.entity.Communication;
import beta.server.entity.Contact;
import beta.server.entity.Sex;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
     * String to use for violation Message.
     */
    private String violateMessage = "Bitte zuerst eine Kommunikationsart auswählen";
    /**
     * String to use for Pattern.
     */
    private String mask;

    /**
     * String to use for Communication type input.
     */
    private String type;

    /**
     * String to use ofr Communication identifier input.
     */
    private String identifier;

    /**
     * String to use for Title input.
     */
    private String title;
    /**
     * Contact to save in ContactList after inputs.
     */
    private Contact contact = new Contact();
    /**
     * Adress to save into adresslist after inputs.
     */
    private Address address = new Address();

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
     * String with the violationMessage to ouput on Website if Contact is not
     * valid.
     */
    private String violationMessage;
    /**
     * String to use for street input.
     */
    private String street;

    /**
     * String to use for city input.
     */
    private String city;
    /**
     * String to use for zipCode input.
     */
    private String zipCode;
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
    private ArrayList<Contact> contacts = new ArrayList<>();

    // Getter
    public String getViolateMessage() {
        return violateMessage;
    }

    public String getMask() {
        return mask;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

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

    public String getViolationMessage() {
        return violationMessage;
    }

    public Contact getContact() {
        return contact;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    //Setter
    public void setType(String type) {
        this.type = type;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

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

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setViolationMessage(String violationMessage) {
        this.violationMessage = violationMessage;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Sets the input to an communication.
     */
    public void createNewCommunication() {
        Communication communication = new Communication();
        if ("Phone".equals(type)) {
            communication.setType(Communication.Type.PHONE);
        } else if ("Mobile".equals(type)) {
            communication.setType(Communication.Type.MOBILE);
        } else if ("Fax".equals(type)) {
            communication.setType(Communication.Type.FAX);
        } else if ("ICQ".equals(type)) {
            communication.setType(Communication.Type.ICQ);
        } else if ("Email".equals(type)) {
            communication.setType(Communication.Type.EMAIL);
        } else if ("Facebook".equals(type)) {
            communication.setType(Communication.Type.FACEBOOK);
        } else {
            type = new String();
            communication.setType(null);
        }
        communication.setIdentifier(identifier);
        communications.add(communication);
        System.out.println(communication.getIdentifier() + communication.getType());
    }

    /**
     * Sets the Mask to use for input Pattern.
     */
    public void setsMask() {
        if ("Phone".equals(type)) {
            mask = Communication.PHONE_PATTERN;
            violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
        } else if ("Mobile".equals(type)) {
            mask = Communication.PHONE_PATTERN;
            violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
        } else if ("Fax".equals(type)) {
            mask = Communication.PHONE_PATTERN;
            violateMessage = "Bitte mit folgendem Muster Eingeben : +Ländervorwahl Vorwahl Nummer ,Beispiel: +49 40 898989";
        } else if ("Email".equals(type)) {
            mask = Communication.EMAIL_PATTERN;
            violateMessage = "Bitte mit folgendem Muster Eingeben : beispiel@beispiel.beispiel";
        } else if ("ICQ".equals(type)) {
            mask = "^(?=.*\\d).+$";
            violateMessage = "Bitte eine Gültige Nummer eingeben.";
        } else if ("Facebook".equals(type)) {
            mask = "[A-Za-z0-9]{1,999}";
            violateMessage = "Bitte gültigen Benutzernamen oder Email eingeben.";
        } else {
            violateMessage = "Bitte zuerst eine Kommunikationsart auswählen";
        }
        System.out.println(mask);
    }

    /**
     * Sets the inputs to an address.
     */
    public void createNewAddress() {
        address.setStreet(street);
        address.setCity(city);
        address.setZipCode(zipCode);
        addresses.add(address);
    }

    /**
     * Saves the inputed Strings to a new Contact when there is no
     * violationMessage and holds it in contacts ArrayList.
     */
    public void createNewContact() {
        Sex sexs;
        if ("Female".equals(sex)) {
            sexs = Sex.FEMALE;
        } else if ("Male".equals(sex)) {
            sexs = Sex.MALE;
        } else {
            sexs = null;
        }
        contact.setSex(sexs);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
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
