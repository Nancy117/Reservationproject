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
public class Bus {
    private final StringProperty bus_type;
    private final StringProperty station;
    private final StringProperty destination;
    private final StringProperty price;

    public Bus(String bus_type, String station, String destination, String price) {
        this.bus_type = (new SimpleStringProperty(bus_type));
        this.station = (new SimpleStringProperty(station));
        this.destination = (new SimpleStringProperty(destination));
        this.price = (new SimpleStringProperty(price));
    }

    public String getBus_type() {
        return bus_type.get();
    }

    public String getStation() {
        return station.get();
    }

    public String getDestination() {
        return destination.get();
    }

    public String getPrice() {
        return price.get();
    }

    public void setBus_type(String value) {
        bus_type.set(value);
    }

    public void setStation(String value) {
        station.set(value);
    }

    public void setDestination(String value) {
        destination.set(value);
    }

    public void setPrice(String value) {
        price.set(value);
    }

    public StringProperty nameproperty() {
        return bus_type;
    }

    public StringProperty stationproperty() {
        return station;
    }

    public StringProperty destproperty() {
        return destination;
    }

    public StringProperty pricesproperty() {
        return price;
    }

    
}
