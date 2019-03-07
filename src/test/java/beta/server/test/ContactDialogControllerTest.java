/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.test;

import beta.server.web.ContactsController;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author alexander.lohmann
 */
public class ContactDialogControllerTest {

    ContactsController controller = new ContactsController();

    @Before
    public void init() {
        controller.getContact().setTitle("King");
        controller.getContact().setFirstName("K");
        controller.getContact().setLastName("Rool");
    }

    @Test
    public void isContactInformationCleared() {
        controller.getNewContact();
        assertThat(controller.getContact().getFirstName()).as("Should be Null").isNull();
        assertThat(controller.getContact().getLastName()).as("Should be Null").isNull();
        assertThat(controller.getContact().getTitle()).as("Should be Null").isNull();
    }
}
