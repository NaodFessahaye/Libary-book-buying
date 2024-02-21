package pkg528final;

import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;

/**
 *
 * @author Gulam
 */
public class Files { 
    private static Files files=null;
    private String customerFileName = "D:\\customer.txt";
    private String bookFileName = "D:\\books.txt";
    public FileWriter custWriter;
    public FileWriter bookWriter;
    public FileReader custReader;
    public FileReader bookReader;
    private File customerFile;
    private File bookFile;
    // static ArrayList<Customer> hi=new ArrayList<>();
    //private static ObservableList<Customer> customers = FXCollections.observableArrayList();
    //private ObservableList<Books> books = FXCollections.observableArrayList();
    
     public static Files getInstance() throws FileNotFoundException, IOException{
        if(files==null)
            files=new Files();
            
            return files;
    }
     
   public Files ()throws FileNotFoundException, IOException{
        File c = new File(customerFileName);
        File b = new File(bookFileName);
        c.createNewFile();
        b.createNewFile();
        FileReader a=new FileReader(c); 
        FileReader g=new FileReader(b); 
        FileWriter f=new FileWriter(c,true);
        FileWriter h=new FileWriter(b,true);
        this.customerFile=c;
        this.bookFile=b;
        this.bookReader=g;
        this.custReader=a;
        this.custWriter=f;
        this.bookWriter=h;
   }
   public void customerFileRead(ArrayList<Customer> cust) throws FileNotFoundException  {

        Scanner scan = new Scanner(customerFile);  
        ArrayList<Customer> temp=new ArrayList<>();
        while(scan.hasNextLine())   {
            String[] listOfCustomers = scan.nextLine().split(" ");
            
            temp.add(new Customer(listOfCustomers[0],listOfCustomers[1],Integer.parseInt(listOfCustomers[2])));
            
        }
        scan.close();
        cust=temp;
    }
 public void bookFileRead(ArrayList<Books> book)  {
        Scanner scan = new Scanner(bookFileName);
        ArrayList<Books> temp=new ArrayList<>();
        while(scan.hasNextLine())   {
            String[] listOfBooks = scan.nextLine().split(": $");
            double price = Double.parseDouble(listOfBooks[1]);
            temp.add(new Books(listOfBooks[0], price));
        }
        scan.close();
        book=temp;
    }
    
    public void customerFileWrite(ArrayList<Customer> cust) {
       try { 
            customerFile.createNewFile();
            for(int i=0;i<cust.size();i++)
            custWriter.write(cust.get(i).getUsername()+" "+
                    cust.get(i).getPassword()+" "+cust.get(i).getPoints()+"\n");
            custWriter.flush();

        } 
        catch (IOException e) {             
            System.out.println("An error occurred.");
                     e.printStackTrace();         } 
        }
     public void bookFileWrite(ArrayList<Books> book) {
        try {
            bookFile.createNewFile();
            for(int i=0;i<book.size();i++)
            bookWriter.write(book.get(i).getBookName() + " " + 
                    book.get(i).getBookPrice() + "\n");
            bookWriter.flush();
        } catch (IOException e) {             
            System.out.println("An error occurred.");
                     e.printStackTrace();      
        }
    }
    public void customerFileRemove(Customer c, ArrayList<Customer> cust) throws FileNotFoundException, IOException    {
        cust.remove(c);
        customerFile.createNewFile();
        customerFileWrite(cust);      
    }
    public void bookFileRemove(Books b, ArrayList<Books> books) throws IOException{
    books.remove(b);
    bookFile.createNewFile();
    bookFileWrite(books);
    }
}