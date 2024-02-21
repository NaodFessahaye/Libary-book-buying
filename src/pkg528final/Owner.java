
package pkg528final;

import java.util.ArrayList;

public class Owner extends User {
     private String username;
     private String password;
     private static Owner owner=null; //for sake of ease, instead of "instance" we use "owner"
     public ArrayList<Books> books;
     public ArrayList<Customer> customers;
     
     
     private Owner(String username, String password){
         super(username,password);
         this.username=username;
         this.password=password;
         ArrayList<Books> books =new ArrayList<>();
         this.books=books;
         ArrayList<Customer> customers=new ArrayList<>();
         this.customers=customers;
     }
     public static Owner getInstance(){
         if(owner==null)
             owner=new Owner("admin","admin");
             return owner;}
     
     @Override
     public void setUsername(String u){}
     @Override
     public void setPassword(String p){}
     @Override
     public String getUsername(){return this.username;}
     @Override
     public String getPassword(){return this.password;}
     
     public Customer usernameInSystem(String a){
            Customer c=new Customer ("afjisfsk","0",0);
        for (int i=0;i<customers.size();i++){
            if(a.equals(customers.get(i).getUsername()))
                c=customers.get(i);}
            return c;
        }
     
     public void addCustomer(Customer c){
     owner.customers.add(c);
     }
     
     public void deleteCustomer(Customer c){
     owner.customers.remove(c);}
     
     public void addBook(Books b){
     owner.books.add(b);}
     
     public void deleteBook(Books b){
     owner.books.remove(b);}
}

