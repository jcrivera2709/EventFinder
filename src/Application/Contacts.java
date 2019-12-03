package Application;

import Application.datamodel.Contact;
import Application.datamodel.ContactData;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Neel Patel on 10/27/19.
 */
public class Contacts {

  public MenuBar menuBar;
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
      ContactController contactCon = fxmlLoader.getController();
      Contact newContact = contactCon.getNewContact();
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

    ContactController contactCon = fxmlLoader.getController();
    contactCon.editContact(selectedContact);

    Optional<ButtonType> result = dialog.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
      contactCon.updateContact(selectedContact);
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

  public void goToMenu() throws IOException {

    Stage stage;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.{
    stage = (Stage) menuBar.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    stage.show();

  }

  public void goToLogIn() throws IOException {
    Stage stage;
    Parent root;

    // Based on button pressed if statement will load the selected scene.
    // if not scene is selected the default scene will be the main menu.{
    stage = (Stage) menuBar.getScene().getWindow();
    root = FXMLLoader.load(getClass().getResource("Login.fxml"));

    // Gets root from if statement.
    // Scene width and height are both defined in main.
    Scene scene = new Scene(root, Main.SCENE_WIDTH, Main.SCENE_HEIGHT);
    stage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    stage.show();
  }
}
