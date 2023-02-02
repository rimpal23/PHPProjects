
package project;

import java.text.*;
import java.util.Date;
import java.time.LocalDate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.print.*;
import javafx.stage.Window;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import java.io.*;
import java.time.ZoneId;
import javafx.print.PageOrientation;

public class FXMLDocumentController {
       @FXML
    private RadioButton radCafeAuLait;

    @FXML
    private RadioButton radWheat;

    @FXML
    private ToggleGroup Bagel;

    @FXML
    private RadioButton radWhite;

    @FXML
    private CheckBox chkCreamCheese;

    @FXML
    private CheckBox chkButter;

    @FXML
    private CheckBox chkBlueberry;

    @FXML
    private CheckBox chkRaspberry;

    @FXML
    private CheckBox chkPeach;

    @FXML
    private RadioButton radNoCoffee;

    @FXML
    private ToggleGroup Coffee;

    @FXML
    private RadioButton radRegCoffee;

    @FXML
    private RadioButton radCappuccino;

    @FXML
    private TextField lblSubtotal;

    @FXML
    private TextField lblTax;

    @FXML
    private TextField lblTotal;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnExit;
     @FXML
    private RadioButton no;
     
     @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf5;
    
    @FXML
    private Label total1;
    
    @FXML
    private Label Total2;

     @FXML
    private Label Total3;
     
       @FXML
    private Button btnFile;

    @FXML
    private Button btnPrinter;
     Window owner;
     WebEngine we=new WebEngine();
     private double total=0.00;
        private double input=0.00;
          private double input2=0.00;
        public String s;
          public String s1;
          public String s2;
          public String s3;
           public String s4;
         
          double Amount;
            double Amount1;
            double Amount2;
             double Amount3;
              double Amount4;
              double Amount5;
              double Amount6;
              double Amount7;
              double Amount8,Amount9;
        private double qty1;
        private double qty2;
        private double qty3;
        private double qty4;
        private double qty5;
        private double qty6,qty7,qty8,qty9,qty10;
     @FXML
    void BagelCost(ActionEvent event) {
      if(event.getSource()==radWheat){
          tf1.setDisable(false);
          radWhite.setDisable(true);
          tf2.setDisable(true);
          no.setDisable(true);
      }
       if(event.getSource()==radWhite){
          tf2.setDisable(false);
          radWheat.setDisable(true);
          tf1.setDisable(true);
          no.setDisable(true);
      }
        if(event.getSource()==no){
            tf1.setDisable(true);
          radWhite.setDisable(true);
          tf2.setDisable(true);
          radWheat.setDisable(true);
        }
        if(no.isSelected()){
            input=0.00;
        }
        if(radWheat.isSelected()){
             input = 1.25* Double.parseDouble(tf1.getText());
            }
       if(radWhite.isSelected()){
         input = 1.50*(Double.parseDouble(tf2.getText()));
         }
        
    total1.setText(""+input);
   
    }

    @FXML
    void CoffeeCost(ActionEvent event) {
       if(radRegCoffee==event.getSource()){
           tf3.setDisable(false);
           radCappuccino.setDisable(true);
           radCafeAuLait.setDisable(true);
           tf4.setDisable(true);
           tf5.setDisable(true);
       }
        if(radNoCoffee==event.getSource()){
           tf3.setDisable(true);
           radCappuccino.setDisable(true);
           radCafeAuLait.setDisable(true);
           radRegCoffee.setDisable(true);
           tf4.setDisable(true);
           tf5.setDisable(true);
       }
        if(radCappuccino==event.getSource()){
           tf3.setDisable(true);
           radRegCoffee.setDisable(true);
           radCafeAuLait.setDisable(true);
           radNoCoffee.setDisable(true);
           tf4.setDisable(false);
           tf5.setDisable(true);
       }
        if(radCafeAuLait==event.getSource()){
           tf3.setDisable(true);
           radCappuccino.setDisable(true);
           radRegCoffee.setDisable(true);
           radNoCoffee.setDisable(true);
           tf4.setDisable(true);
           tf5.setDisable(false);
       }
       
          if(radNoCoffee.isSelected()){
               input2=0.00;
               
          }
           if(radRegCoffee.isSelected()){
            input2 =(Double.parseDouble(tf3.getText())* 1.25);
            }
         if(radCappuccino.isSelected()){
             input2 =(Double.parseDouble(tf4.getText())* 2.00);
        }
         if(radCafeAuLait.isSelected()){
           input2 =(Double.parseDouble(tf5.getText())* 1.75);
            }
        this.Total3.setText(""+input2);
    }

    @FXML
    void ToppingCost(ActionEvent event) {
         
          
          if(chkCreamCheese.isSelected()){
              total=0.50;
              }
          if(chkButter.isSelected()){
              total+=0.25;
            }
          if(chkBlueberry.isSelected()){
                  total+=0.75;
                  }
          if(chkRaspberry.isSelected()){
               total+=0.75;
               }
          if(chkPeach.isSelected()){
               total+=0.75;
               }
          this.Total2.setText(""+total);
         
    
    }
    
    @FXML
    void handleButtonAction(ActionEvent event) {
          if(btnCalculate==event.getSource()){
             
             lblSubtotal.setText(""+(input+input2+total));
                   
             lblTax.setText(""+0.13*(input+input2+total));
             lblTotal.setText(""+((input+input2+total)+0.13*(input+input2+total)));
          }
          if(btnExit==event.getSource()){
              System.exit(0);
          }    
          if(btnReset==event.getSource()){
            
              tf1.clear();
              tf2.clear();
              tf3.clear();
              tf4.clear();
              tf5.clear();
              lblSubtotal.clear();
              lblTax.clear();
              lblTotal.clear();
              radCafeAuLait.setSelected(false);
              radWheat.setSelected(false);
              radWhite.setSelected(false);
              chkCreamCheese.setSelected(false);
              chkButter.setSelected(false);
              chkBlueberry.setSelected(false);
              chkRaspberry.setSelected(false);
              chkPeach.setSelected(false);
              radNoCoffee.setSelected(false);
              radRegCoffee.setSelected(false);
              radCappuccino.setSelected(false);
              no.setSelected(false);
              total1.setText("");
              Total2.setText("");
              Total3.setText("");
              tf1.setDisable(false);
              radWhite.setDisable(false);
              tf2.setDisable(false);
              no.setDisable(false);
              tf3.setDisable(false);
              tf4.setDisable(false);
              tf5.setDisable(false);
              radWheat.setDisable(false);
              radNoCoffee.setDisable(false);
              radRegCoffee.setDisable(false);
              radCappuccino.setDisable(false);
              radCafeAuLait.setDisable(false);
              
          }
          if(btnPrinter==event.getSource()){
              Printer p=Printer.getDefaultPrinter();
              p.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
              PrinterJob j=PrinterJob.createPrinterJob(p);
              j.showPrintDialog(owner);
              if(j!=null){
                  we.print(j);
                  j.endJob();
              }
          }
    }
         
          @FXML   
          void Print(ActionEvent event)throws Exception {
          if(btnFile==event.getSource()){
              write();
          }
          }
          public void write() throws Exception{
            DateFormat df=new SimpleDateFormat("hh:mm a");
           Date date=new Date();
          LocalDate ld=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          int year=ld.getYear();
          int day=ld.getDayOfMonth();
          int month=ld.getMonthValue();
         File f=new File("Receipt.txt");
         FileOutputStream fo=new FileOutputStream(f);
         DataOutputStream d=new DataOutputStream(fo);
         
          d.writeBytes("**********************SHERIDAN BAGEL SHOP*****************");
          String newLine=System.getProperty("line.separator");
             d.writeBytes(newLine);
           d.writeBytes(month+"  "+day+" " +df.format(date)+"  "+year);
            d.writeBytes(newLine);
         d.writeBytes("Item:              Qty:                Amount");
              d.writeBytes(newLine);
              if(no.isSelected()){
             d.writeBytes(no.getText()+"                     "+"$"+0.00 );}
              if(radWheat.isSelected()){
              s=radWheat.getText();
              qty1=Double.parseDouble(tf1.getText());
             input = 1.25* Double.parseDouble(tf1.getText());
             Amount=input;
             d.writeBytes(s+"           "+qty1+"              "+"$"+Amount );}
              d.writeBytes(newLine);
             if(radWhite.isSelected()){
           s1=radWhite.getText();
           qty2=Double.parseDouble(tf2.getText());
         input = 1.50*(Double.parseDouble(tf2.getText()));
         Amount1=input;
        
         d.writeBytes(s1+"              "+qty2+"              "+"$"+Amount1 );}
              d.writeBytes(newLine);
              d.writeBytes(newLine);
              d.writeBytes("Coffee");
               d.writeBytes(newLine);
                if(radNoCoffee.isSelected()){
                    d.writeBytes(radNoCoffee.getText() +"      "+"$"+0.00);}
               if(radRegCoffee.isSelected()){
               s2=radRegCoffee.getText();
               qty6=Double.parseDouble(tf3.getText());
            input2 =(Double.parseDouble(tf3.getText())* 1.25);
            Amount2=input2;
           
        d.writeBytes(s2 +"              "+qty6+"               "+"$"+Amount2);}
               d.writeBytes(newLine);
                if(radCappuccino.isSelected()){
             s3=radCappuccino.getText();
             qty3=Double.parseDouble(tf4.getText());
             input2 =(Double.parseDouble(tf4.getText())* 2.00);
             Amount3=input2;
        
        d.writeBytes(s3 +"               "+qty3+"              "+"$"+Amount3);}
               d.writeBytes(newLine);
               if(radCafeAuLait.isSelected()){
           input2 =(Double.parseDouble(tf5.getText())* 1.75);
           s4=radCafeAuLait.getText();
           qty4=Double.parseDouble(tf5.getText());
           Amount4=qty4;
            
        d.writeBytes(s4 +"               "+qty4+"              "+"$"+Amount4);}
               d.writeBytes(newLine);
                d.writeBytes("Toppings");
                 if(chkCreamCheese.isSelected()){
             
              qty5=0.50;
             
        d.writeBytes("Cream Cheese" +"    "+qty5+"                            ");}
               d.writeBytes(newLine);
               if(chkButter.isSelected()){
              
              qty7=0.25;
              
            
        d.writeBytes("Butter" +"          "+qty7+"                           ");}
                 d.writeBytes(newLine);
                 if(chkBlueberry.isSelected()){
              
              qty8=0.75;
                  
                  
        d.writeBytes("Blueberry jam" +"    "+qty8+"          "+"$"+Total2.getText());}
                 d.writeBytes(newLine);
                 if(chkRaspberry.isSelected()){
              
            
               qty9=0.75;
               
        d.writeBytes("Raspberry jam" +"     "+qty9+"                            ");}
                 d.writeBytes(newLine);
                  if(chkPeach.isSelected()){
              
            
               qty10=0.75;
               
        d.writeBytes("Peach jelly" +"       "+qty10+"                           ");}
           
         d.writeBytes(newLine);
           
                   d.writeBytes("Subtotal is:"+lblSubtotal.getText());
                   d.writeBytes(newLine);
                     d.writeBytes("Tax is:"+lblTax.getText());
                      d.writeBytes(newLine);
                       d.writeBytes("Total is:"+lblTotal.getText());
                        d.writeBytes(newLine);
                         d.writeBytes("*******************Thank you for your order*******************");
         d.close();
        
       }
}
    
           





  

    

