package pkg528final;
;
import javafx.scene.control.CheckBox;
import java.io.IOException;
/**
 *
 * @author Gulam
 */
public class Books  {
    
    private String bookName;
    private double bookPrice;
   
    private CheckBox click;
    
    public Books(String bookName, double bookPrice) {
    
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.click = new CheckBox();
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public void setBookName(String bookName)    {
        this.bookName = bookName;
    }
    
    public double getBookPrice()   {
        return this.bookPrice;
    }
    
    public void setBookPrice(double bookPrice)  {
        this.bookPrice = bookPrice;
    }
    
    public CheckBox getCheck()  {
        return click;
    }
    
    public void setCheck(CheckBox click) {
        this.click = click;
    }      
}
