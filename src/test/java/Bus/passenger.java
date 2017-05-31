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
package Bus;

import bus.reservationproject.FXMLBManagementController;
import bus.reservationproject.FXMLReservationController;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melon
 */
public class passenger {
    
     @Test
    public void passenger() {
    }
    
    @Test
    public void addpassenger() throws IllegalArgumentException{
  
    
       FXMLReservationController testControler = new FXMLReservationController();
        
    Class c = testControler.getClass();
         try {
             Field f = c.getDeclaredField("field");
             Object o=null;
             f.get(o);
             String s = (String)o;
             
           
             Field f1 = c.getDeclaredField("field1");
             Object o1=null;
             f1.get(o1);
             String s1 = (String)o1;
             
          
             Field f2 = c.getDeclaredField("field2");
             Object o2=null;
             f2.get(o2);
             String s2 = (String)o2;
             
            
             Field f3 = c.getDeclaredField("field3");
             Object o3=null;
             f3.get(o3);
             String s3 = (String)o3;
             
              Field f4 = c.getDeclaredField("field4");
             Object o4=null;
             f4.get(o4);
             String s4 = (String)o4;
             
              Field f5 = c.getDeclaredField("date");
             Object o5=null;
             f5.get(o5);
             String s5 = (String)o5;
             
              Field f6 = c.getDeclaredField("field6");
             Object o6=null;
             f6.get(o6);
             String s6 = (String)o6;
             
        Assert.assertFalse(s, equals(null));
        Assert.assertEquals(s1,s1);
        Assert.assertEquals(s2,s2);
        Assert.assertEquals(s3,s3);
        Assert.assertEquals(s4,s4);
        Assert.assertEquals(s5,s5);
        Assert.assertEquals(s6,s6);
           
         } catch (NoSuchFieldException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
    @Test
    public void deletepassenger() throws IllegalArgumentException{
             FXMLReservationController testControler = new FXMLReservationController();
            try {   
             Class c = testControler.getClass();
             Field f = c.getDeclaredField("field");
             Object o=null;
             f.get(o);
             String s = (String)o;
             
             Assert.assertFalse(s,equals(null));
             Assert.assertEquals(s,s);
         } catch (NoSuchFieldException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Test
    public void passengerdetail(){
         try {
             FXMLReservationController testControler = new FXMLReservationController();
             
             Class c = testControler.getClass();
             Field f = c.getDeclaredField("data");
             Object o1=null;
             f.get(o1);
             String s = (String)o1;
            
             Assert.assertFalse("not null", equals(null));
         } catch (NoSuchFieldException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
