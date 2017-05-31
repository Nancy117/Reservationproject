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
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 *
 * @author melon
 */

public class Bus {
    
     private static org.slf4j.Logger logger = LoggerFactory.getLogger(FXMLBManagementController.class);
    @Test
    public void Bus() {
    }
    
    @Test
    public void addBUS(){
        FXMLBManagementController testmanage = new FXMLBManagementController();
        Class c = testmanage.getClass();
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
        
        Assert.assertFalse(s, equals(null));
        Assert.assertEquals(s1,s1);
        Assert.assertEquals(s2,s2);
        Assert.assertEquals(s3,s3);
        
         } catch (NoSuchFieldException ex) {
             logger.error("empty");
         } catch (SecurityException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(passenger.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @Test
    public void deletebus(){
       FXMLBManagementController testmanage = new FXMLBManagementController();
        Class c = testmanage.getClass();
         try {
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
    public void busdetail(){
      
         try {
             FXMLBManagementController testmanage = new FXMLBManagementController();
             Class c = testmanage.getClass();
             Field f = c.getDeclaredField("data");
             Object o1=null;
             f.get(o1);
             String s = (String)o1;
            
             Assert.assertFalse("not null", equals(null));
         } catch (NoSuchFieldException ex) {
             Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SecurityException ex) {
             Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalArgumentException ex) {
             Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
