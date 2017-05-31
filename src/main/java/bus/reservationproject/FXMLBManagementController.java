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
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author melon
 */
public class FXMLBManagementController implements Initializable {
      private static org.slf4j.Logger logger = LoggerFactory.getLogger(FXMLBManagementController.class);
      
       /**
     * Button,label and text field to be recognized on the command line.
     */

    @FXML
    private Text Bus_Type;
    @FXML
    private Text Station;
    @FXML
    private Text destination;
    @FXML
    private Text price;
    @FXML
    private TextField field;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private Button Add;
    @FXML
    private Button Delete;
    @FXML
    private Button Details;
    @FXML
    private Button Update;
    @FXML
    private Button BacktoReserver;
    @FXML
    private Button Exit;
    @FXML
    private TableView<Bus> tablevie;
    @FXML
    private TableColumn<Bus,String> bustype;
    @FXML
    private TableColumn<Bus, String> station;
    @FXML
    private TableColumn<Bus, String> dest;
    @FXML
    private TableColumn<Bus, String> busprice;
     private ObservableList<Bus>data;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     /**
     * A button action perform to insert Bus by entering data 
     * This link {@link JDBC:derby://localHost:1527/SHIYIN", "", ""} connects to database with username and password. 
     * Handle SQLException by showing error message if error occurs.
     *
     * @param event  the action event of this button
     * @return no return
     */
    @FXML
    private void AddActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
          String Bus_Type = field.getText();
        String Station = field1.getText();
        String destination = field2.getText();
        String price = field3.getText();
        try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = con.createStatement();
            String sql = "insert into BUS(BUS_TYPE,STATION,DESTINATION,PRICE) values('" +Bus_Type + "','" + Station + "','" + destination + "','" + price+ "')";

            stmt.executeUpdate(sql);
            logger.info("add successful");
        } catch (SQLException ex) {
          logger.debug("debug message");
        }
    }
 /**
     * A button action perform to delete Bus by <code> BusId</code>. This
     * link{@link JDBC:derby://localHost:1527/SHIYIN", "", ""} connects to database with username and password.
     * Shows message if
     * delete Bus is successful. Handle SQLException by showing error message
     * if inputs are wrong.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void DeleteActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       String busid = field.getText();

        try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = conn.createStatement();
                 String sql = "delete from BUS where  (BUS_TYPE = '" + busid + "') ";
                stmt.execute(sql);
                 stmt.close();
                conn.close();
                
                 logger.info("delete successful");
        } catch (SQLException ex) {
          logger.debug("debug message");
        } 
    }
       /**
     * Shows table of Bus details. This {@link JDBC:derby://localHost:1527/SHIYIN", "", ""}
     * connects to database with username and password. Add element from
     * database to table Handle SQLException by showing error message if wrong
     * occurs.
     *
     *
     */
    @FXML
    public void DetailsActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
          try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = con.createStatement();
            
            data=FXCollections.observableArrayList();
            
            String sql = "select * from BUS ";

            ResultSet r = stmt.executeQuery(sql);
              while (r.next()) {
               data.add(new Bus(r.getString("BUS_TYPE"), r.getString("STATION"), r.getString("DESTINATION"), r.getString("PRICE")));
            }
            r.close();
            stmt.close();
            con.close();
           logger.info("add row to table");
        } catch (SQLException ex) {
           logger.error("error message");
        }
        bustype.setCellValueFactory(new PropertyValueFactory<Bus,String>("Bus_type"));
        station.setCellValueFactory(new PropertyValueFactory<Bus,String>("Station"));
        dest.setCellValueFactory(new PropertyValueFactory<Bus,String>("Destination"));
        busprice.setCellValueFactory(new PropertyValueFactory<Bus,String>("Price"));
        
        tablevie.setItems(null);
        tablevie.setItems(data);
    }
     /**
     * A button action perform to update Bus by insert <code>name</code>. 
     * This link{@link JDBC:derby://localHost:1527/SHIYIN", "", ""}
     * connects to database with username and password. Shows message if update
     * Bus is successful. Handle SQLException by showing error message if error
     * occurs.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void UpdateActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = field.getText();
        String Station = field1.getText();
        String destination = field2.getText();
        String price = field3.getText();
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = con.createStatement();

            String sql = "update BUS set STATION='" + Station + "',DESTINATION='" + destination + "',PRICE='" + price + "' where  BUS_TYPE = '" + name + "'";

                stmt.execute(sql);
                stmt.close();
                con.close();
                
                logger.info( "Record has been Updated");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLBManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
     * This go back to FXMLReservation.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void BackActionEvent(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLReservation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
             logger.info("back pressed");
    }
 /**
     * Close this window.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void ExitActionEvent(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void nextAction(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLName.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
            logger.info("next pressed");
        
    }
    
}
