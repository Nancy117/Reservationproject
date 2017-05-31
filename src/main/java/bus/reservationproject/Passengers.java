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

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author melon
 */
public class Passengers {
     private final StringProperty name;
    private final StringProperty gender;
    private final StringProperty Passenger;
    private final StringProperty Destination;
    private final StringProperty seat;
    private final StringProperty bustype;
    private final StringProperty DOJ;
    private final StringProperty time;

    public Passengers(String name, String gender, String Passenger, String Destination, String seat, String bustype, String DOJ,String time) {
        this.name = (new SimpleStringProperty(name));
        this.gender = (new SimpleStringProperty(gender));
        this.Passenger = (new SimpleStringProperty(Passenger));
        this.Destination = (new SimpleStringProperty(Destination));
        this.seat = (new SimpleStringProperty(seat));
        this.bustype = (new SimpleStringProperty(bustype));
        this.DOJ = (new SimpleStringProperty(DOJ));
         this.time =(new SimpleStringProperty(time));
    }

    public String getName() {
        return name.get();
    }

    public String getGender() {
        return gender.get();
    }

    public String getPassenger() {
        return Passenger.get();
    }

    public String getDestination() {
        return Destination.get();
    }

    public String getSeat() {
        return seat.get();
    }

    public String getBustype() {
        return bustype.get();
    }

    public String getDOJ() {
        return DOJ.get();
    }
      public String getTime() {
        return time.get();
    }
    public void setName(String value) {
        name.set(value);
    }

    public void setGender(String value) {
        gender.set(value);
    }

    public void setPassenger(String value) {
        Passenger.set(value);
    }

    public void setDestination(String value) {
        Destination.set(value);
    }
    public void setSeat(String value) {
        seat.set(value);
    }

    public void setBustype(String value) {
        bustype.set(value);
    }
    public void setDoj(String value) {
        DOJ.set(value);
    }
     public void setTime(String value) {
        time.set(value);
    }
     public StringProperty nameproperty() {
        return name;
    }

    public StringProperty genderproperty() {
        return gender;
    }

    public StringProperty Passengerproperty() {
        return Passenger;
    }

    public StringProperty Destinationproperty() {
        return Destination;
    }
     public StringProperty seatproperty() {
        return seat;
    }

    public StringProperty bustypeproperty() {
        return bustype;
    }
    public StringProperty DOJproperty() {
        return DOJ;
    }
     public StringProperty timeproperty() {
        return time;
    }
    
}
