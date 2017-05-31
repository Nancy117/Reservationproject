/*
 * Copyright 2017 Faculty of Informatics, University of Debrecen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bus.reservationproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
  * 
  *Class for login to system by correct<code> username</code> and <code>password</code>.
  */
public class FXMLController implements Initializable {
 /**
     * Button,label,password field and text field to be recognized on the command line.
     */
    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

     /**
     * Login system by entering correct  <code>username</code> and <code>password</code>,otherwise shows
     * error message.
     *
     * @param event the action event of this button
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String username = this.username.getText();
        String pass =this.password.getText();
        if (username.equals("Nancy") && pass.equals("melony.12")) {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
            
        } else {
            label.setText("Wrong PassWord and Name");
        }
         /**
     * Initializes the controller class.
     *  @param url
     * @param rb
     */
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  /**
     * Cancel login to system.
     *
     * @param event the action event of this button
     */
    @FXML
    private void cancelActionPerformed(ActionEvent event) {
        System.exit(0);
    }
}
