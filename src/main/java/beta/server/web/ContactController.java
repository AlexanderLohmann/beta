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
 *
 * @author alexander.lohmann
 */
@Named
@ViewScoped
public class ContactController implements Serializable {

    @Inject
    private ContactEao contactEao;
    private List<Contact> contact;

    public List<Contact> getContact() {
        return contact;
    }
    /**
     * 
     */
    public void betaMethod(){
    List<Contact> contacts = contactEao.findAll();
    contact = contacts;
    }
}
