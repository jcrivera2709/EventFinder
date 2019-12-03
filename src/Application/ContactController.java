package Application;
/* Created by Neel Patel on 10/27/19. */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Application.datamodel.Contact;

public class ContactController {
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField phoneNumberField;
  @FXML private TextField notesField;

  public Contact getNewContact() {
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String phoneNumber = phoneNumberField.getText();
    String notes = notesField.getText();

    return new Contact(firstName, lastName, phoneNumber, notes);
  }

  public void editContact(Contact contact){
    firstNameField.setText(contact.getFirstName());
    lastNameField.setText(contact.getLastName());
    phoneNumberField.setText(contact.getPhoneNumber());
    notesField.setText(contact.getNotes());
  }

  public void updateContact(Contact contact){
    contact.setFirstName(firstNameField.getText());
    contact.setLastName(lastNameField.getText());
    contact.setPhoneNumber(phoneNumberField.getText());
    contact.setNotes(notesField.getText());
  }
}
