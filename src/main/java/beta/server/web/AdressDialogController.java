/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Address;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for the Dialog to create an new Adress
 *
 * @author alexander.lohmann
 */
@Named("AdressController")
@RequestScoped
public class AdressDialogController implements Serializable {

    private final Logger L = LoggerFactory.getLogger(CommunicationDialogController.class);
    
    @Inject
    private ContactDialogController contactDialogController;
    /**
     * Adress to save into adresslist after inputs.
     */
    private Address address = new Address();

    public Address getAddress() {
        return address;
    }

    /**
     * Sets the inputs to an address.
     */
    public void createNewAddress() {
        contactDialogController.getAddresses().add(address);
    }
}
