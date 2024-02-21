package pkg528final;

 public class Gold extends Status {
    @Override
     public void updateStatus(Customer c){
     if (c.getPoints()>=1000)c.setStatus(new Gold());  
     if (c.getPoints()<1000)c.setStatus(new Silver());
     }
    @Override
     public String toString(){return "Gold";}
 }  
