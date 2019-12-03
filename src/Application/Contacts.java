package Application;

import Application.datamodel.Contact;
import Application.datamodel.ContactData;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 * Created by Neel Patel on 10/27/19.
 */
public class Contacts {

  public MenuItem mainMenu;
  public MenuItem logIn;
  @FXML
  private BorderPane mainPanel;

  @FXML
  private TableView<Contact> contactsTable;

  private ContactData data;

  public void initialize() {
    data = new ContactData();
    data.loadContacts();
    contactsTable.setItems(data.getContacts());
  }

  @FXML
  public void showAddContactMessage() {
    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.initOwner(mainPanel.getScene().getWindow());
    dialog.setTitle("Add New Contact");
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
    try {
      dialog.getDialogPane().setContent(fxmlLoader.load());
    } catch (IOException e) {
      System.out.println("Cannot load the dialog");
      e.printStackTrace();
      return;
    }

    dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
    dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

    Optional<ButtonType> result = dialog.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      ContactDialog contactDialog = fxmlLoader.getController();
      Contact newContact = contactDialog.getNewContact();
      data.addContacts(newContact);
      data.saveContacts();
    }
  }

  @FXML
  public void showEditContactMessage() {
    Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
    if (selectedContact == null) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("No Contact Selected");
      alert.setHeaderText(null);
      alert.setContentText("Please select contact you want to edit.");
      alert.showAndWait();
      return;
      // alert in case when nothing is selected to edit

    }

    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.initOwner(mainPanel.getScene().getWindow());
    dialog.setTitle("Edit Contact");
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));
    try {
      dialog.getDialogPane().setContent(fxmlLoader.load());
    } catch (IOException e) {
      System.out.println("Couldn't load the dialog");
      e.printStackTrace();
    }

    dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
    dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

    ContactDialog contactDialog = fxmlLoader.getController();
    contactDialog.editContact(selectedContact);

    Optional<ButtonType> result = dialog.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      contactDialog.updateContact(selectedContact);
      data.saveContacts();
    }
  }

  public void deleteContact() {
    Contact selectedContact = contactsTable.getSelectionModel().getSelectedItem();
    if (selectedContact == null) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("No contact selected");
      alert.setHeaderText(null);
      alert.setContentText("Please select the contact you want to delete");
      alert.showAndWait();
      return;
    }
    // alert in case when nothing is selected to delete
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Delete Contact");
    alert.setContentText(null);
    alert.setContentText("Are you sure you want to remove the selected contact: " +
        selectedContact.getFirstName() + " " + selectedContact.getLastName());

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      data.deleteContact(selectedContact);
      data.saveContacts();
    }
  }

  public void goTo(ActionEvent actionEvent) throws IOException {

  }
}
