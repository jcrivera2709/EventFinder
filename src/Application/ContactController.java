package Application;
/* Created by Neel Patel on 10/27/19. */

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Application.datamodel.Contact;

public class ContactController {

  @FXML
  private TextField firstNameField;
  @FXML
  private TextField lastNameField;
  @FXML
  private TextField phoneNumberField;
  @FXML
  private TextField notesField;

  Contact getNewContact() {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String phoneNumber = phoneNumberField.getText();
    String notes = notesField.getText();

    isPhoneNumberValid(phoneNumber);

    return new Contact(firstName, lastName, phoneNumber, notes);
  }

  private boolean isPhoneNumberValid(String phoneNumber) {
    boolean isValid = false;
    if (phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}") || phoneNumber.matches("[0-9]{9}")) {
      isValid = true;
    }
    return isValid;
  }

  void editContact(Contact contact) {
    firstNameField.setText(contact.getFirstName());
    lastNameField.setText(contact.getLastName());
    phoneNumberField.setText(contact.getPhoneNumber());
    notesField.setText(contact.getNotes());
  }

  void updateContact(Contact contact) {
    contact.setFirstName(firstNameField.getText());
    contact.setLastName(lastNameField.getText());
    contact.setPhoneNumber(phoneNumberField.getText());
    contact.setNotes(notesField.getText());
  }
}
