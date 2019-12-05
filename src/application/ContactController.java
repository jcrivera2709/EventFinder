package application;

import application.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *  Created by Neel Patel on 10/27/19.
 */

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
    Contact contact;
    if (phoneNumberIsValid(phoneNumber) && !notes.isEmpty()) {
      contact = new Contact(firstName, lastName, phoneNumber, notes);
    } else if (phoneNumberIsValid(phoneNumber) && notes.isEmpty()) {
      contact = new Contact(firstName, lastName, phoneNumber, "Empty.");
    } else if (!phoneNumberIsValid(phoneNumber) && !notes.isEmpty()) {
      contact = new Contact(firstName, lastName, "Phone number is invalid.", notes);
    } else {
      contact = new Contact(firstName, lastName, "Phone number is invalid.", "Empty.");
    }
    return contact;
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

    if (phoneNumberIsValid(phoneNumberField.getText())) {
      contact.setPhoneNumber(phoneNumberField.getText());
    } else {
      contact.setPhoneNumber("Phone number is invalid.");
    }
    if (!notesField.getText().isEmpty()) {
      contact.setNotes(notesField.getText());
    } else {
      contact.setNotes("Empty.");
    }

  }

  private boolean phoneNumberIsValid(String phoneNumber) {
    boolean isValid = false;
    if (phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}") || phoneNumber.matches("[0-9]{10}")) {
      isValid = true;
    }
    return isValid;
  }
}
