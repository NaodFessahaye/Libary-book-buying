package pkg528final;

public class Customer extends User {
   private String username;
   private String password;// we can/should make these all private since we have setters/getters
   private Status status = new Silver();
   private int points;
    
    public Customer(String username, String password, int points){
    super(username,password);
    this.username=username;
    this.password=password;
    this.points=points;}
    
   @Override
    public void setUsername(String u){this.username=u;}
   @Override
    public void setPassword(String p){this.password=p;} 
    public void setPoints(int po){this.points=po;this.status.updateStatus(this);}
    public void setStatus(Status g){this.status =g;}
   @Override
     public String getUsername(){return this.username;}
   @Override
     public String getPassword(){return this.password;}
     public Status getStatus(){return this.status;}//these 2 will be 
     public int getPoints(){return this.points;}//useful for the GUI
    
   public  void redeemAndBuy(int pointsRedeemed){
        this.points=this.points-pointsRedeemed;
        this.status.updateStatus(this);
    }
    public void buy(int totalCost){
        this.setPoints(totalCost*10);
        this.status.updateStatus(this);
    }
}
