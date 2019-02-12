/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.eao.ContactEao;
import beta.server.entity.Contact;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controller for the Table List.
 *
 * @author alexander.lohmann
 */
@Named
@ViewScoped
public class ContactController implements Serializable {

    @Inject
    /**
     * ContactEao
     */
    private ContactEao contactEao;
    /**
     * Lists of contacts for output on the website.
     */
    private List<Contact> contact;

    /**
     * return list containing Contacts.
     *
     * @return list containing Contacts
     */
    public List<Contact> getContact() {
        return contact;
    }

    /**
     * Fills contacts.
     */
    public void betaMethod() {
        List<Contact> contacts = contactEao.findAll();
        contact = contacts;
    }
}
