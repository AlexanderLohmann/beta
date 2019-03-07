/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Communication;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller for the Dialog to create an new Communication and check for valid
 * information.
 *
 * @author alexander.lohmann
 */
@Named("CommunicationController")
@RequestScoped
public class CommunicationDialogController implements Serializable {

    private final Logger L = LoggerFactory.getLogger(CommunicationDialogController.class);

    @Inject
    private ContactsController contactDialogController;

    /**
     * Communication to save into communicationlist after inputs.
     */
    private Communication communication = new Communication();

    // Getter
    public Communication getCommunication() {
        return communication;
    }

    /**
     * Sets the chosen Communication type to the current communication. When the
     * input is valid it saves the Communication in an List.
     */
    public void createNewCommunication() {
        contactDialogController.getContact().getCommunications().add(communication);
    }
}
