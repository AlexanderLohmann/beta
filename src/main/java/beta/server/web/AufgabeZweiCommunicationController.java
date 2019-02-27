/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.entity.Communication;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author alexander.lohmann
 */
@RequestScoped
public class AufgabeZweiCommunicationController {
    
    @Inject
    private AufgabeZweiDialogController dialogcontroller;
    /**
     * String to use for violation Message.
     */
    private String violateMessage = "Bitte zuerst eine Kommunikationsart auswählen";
    /**
     * String to use for Pattern.
     */
    private String mask;
    /**
     * Communication to save into communicationlist after inputs.
     */
    private Communication communication = new Communication();

    // Getter
    public String getViolateMessage() {
        return violateMessage;
    }

    public String getMask() {
        return mask;
    }

    public Communication getCommunication() {
        return communication;
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
     * Sets the chosen Communication type to the current communication. When the
     * input is valid it saves the Communication in an List.
     */
    public void createNewCommunication() {
        dialogcontroller.getCommunications().add(communication);
    }
}
