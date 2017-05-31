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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author melon
 */
public class FXMLReservationController implements Initializable {
         private static org.slf4j.Logger logger = LoggerFactory.getLogger(FXMLReservationController.class);
      
       /**
     * Button,label and text field to be recognized on the command line.
     */
    @FXML
    private Label Name;
    @FXML
    private Label Gender;
    @FXML
    private Label Passengers;
    @FXML
    private Label destination;
    @FXML
    private Label Seat;
    @FXML
    private Label Bus_Type;
    @FXML
    private Label Doj;
    @FXML
    private Label time;
    @FXML
    private TextField field;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    @FXML
    private TextField date;
    @FXML
    private TextField field6;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button details;
    @FXML
    private Button next;
    @FXML
    private TableView<Passengers> tableview;
    @FXML
    private TableColumn<Passengers, String> name;
    @FXML
    private TableColumn<Passengers, String> gender;
    @FXML
    private TableColumn<Passengers, String> pass;
    @FXML
    private TableColumn<Passengers, String> destinatn;
    @FXML
    private TableColumn<Passengers, String> seat;
    @FXML
    private TableColumn<Passengers, String> bustype;
    @FXML
    private TableColumn<Passengers, String> DOJ;
    @FXML
    private TableColumn<Passengers, String> Time;
    
    private ObservableList<Passengers>data;

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
     * A button action perform to insert Passenger by entering data 
     * This link {@link JDBC:derby://localHost:1527/SHIYIN", "", ""}
     * connects to database with username and password. 
     * Handle SQLException by showing error message if error occurs.
     *
     * @param event  the action event of this button
     * @return no return
     */

    @FXML
    private void AddActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
         String name = field.getText();
        String Gender = field1.getText();
        String Pssengers = field2.getText();
        String destination = field3.getText();
        String seat = field4.getText();
        String bustype = field5.getText();
        String doj =date.getText();
        String time = field6.getText();
         
        try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
                     
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = con.createStatement();

            String s = "insert into PASSENGER_DETAILS(NAME,GENDER,PASSENGERS,DESTINATION,SEAT,BUS_TYPE,DAY_OF_JOURNEY,TIME) values('" + name + "','" + Gender+ "','" + Pssengers+ "','" + destination+"','"+seat+"','"+bustype+"','"+doj+"','"+time+ "')";
            stmt.executeUpdate(s);
             logger.info("add successful");
        } catch (SQLException ex) {
            logger.debug("debug message");
        }
    }
    /**
     * A button action perform to delete Passengers by name. This
     * link{@link JDBC:derby://localHost:1527/SHIYIN", "", ""}
     * connects to database with username and password. Shows message if
     * delete Passenger is successful. Handle SQLException by showing error message
     * if inputs are wrong.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void DeleteActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String name = field.getText();

        try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = conn.createStatement();

            String sql = "delete from PASSENGER_DETAILS where  (NAME = '" + name + "') ";
                stmt.execute(sql);
                stmt.close();
                conn.close();
             logger.info("delete successful");
        } catch (SQLException ex) {
           logger.debug("debug message");
        }
    }
     /**
     * Shows table of Passenger details. This link  {@link JDBC:derby://localHost:1527/SHIYIN", "", ""}
     * connects to database with username and password. Add element from
     * database to table Handle SQLException by showing error message if wrong
     * occurs.
     *
     *
     */
    @FXML
    private void DetailsActionEvent(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
             DriverManager.registerDriver((Driver) Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance());
            
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SHIYIN", "Nancy", "H0FOND");
            java.sql.Statement stmt = con.createStatement();
             data=FXCollections.observableArrayList();
            String s;
            s = "Select * from PASSENGER_DETAILS ";
            ResultSet r;
            r = stmt.executeQuery(s);
              while (r.next()) {
              data.add(new Passengers(r.getString("NAME"), r.getString("GENDER"), r.getString("PASSENGERS"), r.getString("DESTINATION"),r.getString("SEAT"), r.getString("BUS_TYPE"), r.getString("DAY_OF_JOURNEY"), r.getString("TIME")));
            }
            r.close();
            stmt.close();
            con.close();
           logger.info("add row to table");
        } catch (SQLException ex) {
           logger.error("error message");
        }
       name.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Name"));
        gender.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Gender"));
        pass.setCellValueFactory(new PropertyValueFactory<Passengers,String>("passenger"));
        destinatn.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Destination"));
        seat.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Seat"));
        bustype.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Bustype"));
       DOJ.setCellValueFactory(new PropertyValueFactory<Passengers,String>("DOJ"));
        Time.setCellValueFactory(new PropertyValueFactory<Passengers,String>("Time"));
        
        
        tableview.setItems(null);
        tableview.setItems(data);
    }
      /**
     * This goes to FXMLBManagement.
     *
     * @param event  the action event of this button
     */
    @FXML
    private void NextActionEvent(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLBManagement.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setTitle("Reservation System");
            stage.setScene(scene);
            stage.show();
            
            logger.info("nextclicked");
    }
    
}
