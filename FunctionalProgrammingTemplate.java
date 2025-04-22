/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package functionalprogrammingtemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.Function;


public class FunctionalProgrammingTemplate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create the ArrayList of Invoices
        List<Invoice> invoices = List.of(
        new Invoice(83,"Electric sander", 7, 57.98),
        new Invoice(24,"Power saw", 18, 99.99),
        new Invoice(7,"Sledge hammer", 11, 21.50),
        new Invoice(77,"Hammer", 76, 11.99),
        
        new Invoice(39,"Lawn mower", 3, 79.50),
        new Invoice(68,"Screw driver", 106, 6.99),
        new Invoice(56,"Jig saw", 21, 11.00),
        new Invoice(3,"Wrench", 34, 7.50));
        
        //Display the table of invoices using Invoice toString().
        //Print table header.
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        
        invoices.stream()
                
                .forEach(System.out::print);
        
        //a)Use streams to sort Invoice object by partDecsription, then display the results.
        Function<Invoice,String> byPartDesc = Invoice::getPartDescription;
        
        System.out.print("\nInvoices sorted by part description\n");
        
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        
        invoices.stream()
                .sorted(Comparator.comparing(byPartDesc))
                
                .forEach(System.out::print);
        
        
        //b)Use streams to sort Invoice object by price, then display the results.
        Function<Invoice,Double> byPrice = Invoice::getPricePerItem;
        
        System.out.print("\nInvoices sorted by Price\n");
        
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        
        invoices.stream()
                
                .sorted(Comparator.comparing(byPrice))
                
                .forEach(System.out::print);
        
        
        //c)Use streams to map each Invoice to its partDescription and quantity, 
        //  then display the results.
        Function<Invoice,Integer> byQuant = Invoice::getQuantity;
        
        System.out.printf("\n%s\n%s\t%s\n","Part Description and Quantity for Each Invoice"
                
            ,"Part Description", "Quantity");
        
        invoices.stream()
                
                .sorted(Comparator.comparing(byQuant))
                
                .forEach(s -> System.out.printf("%-16s\t%8d\n",s.getPartDescription(),s.getQuantity()));
                
    }
    
}
