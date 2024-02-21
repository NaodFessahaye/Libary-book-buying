package pkg528final;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import static javafx.application.Application.launch;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Main extends Application {
    
    //ADMIN Buttons
    Button booksButton = new Button("Books");
    Button customersButton = new Button("Customers");

    Button backButton = new Button("Back");
    Button newbackButton = new Button("Back");

    
    //CUSTOMER Buttons
    Button Buy = new Button("Buy");
    Button Redeem = new Button("Redeem points and buy");
    Button customerbackButton = new Button("Back");
    
    //GENERAL Buttons
    Button loginButton = new Button("Login");
    Button logoutButton = new Button("Logout");
    
    
    TextField userTextField = new TextField();
    PasswordField passTextField = new PasswordField(); //Set TextField to PasswordField                                
    
    //Delete after
    String namess = userTextField.getText();
 
    
    
    
    

    //Tables
    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Jacob", "Qwerty", "60"),
                    new Person("Isabella", "Shorty", "60"),
                    new Person("Ethan", "Meow", "70"),
                    new Person("Emma", "Cow", "80"),
                    new Person("Michael", "Woof", "80"));
    final HBox hb = new HBox();
    
    private TableView<Book> tableTwo = new TableView<Book>();
    private final ObservableList<Book> dataTwo =
            FXCollections.observableArrayList(
                    new Book("Cats", "30"),
                    new Book("Rat a tooey", "10"),
                    new Book("Gromp", "15"),
                    new Book("PNL", "20"),
                    new Book("Tokyo ghoul", "30"));
    final HBox hbTwo = new HBox();

    private TableView<Customers> tableThree = new TableView<Customers>();
    private final ObservableList<Customers> dataThree =
            FXCollections.observableArrayList(
                    new Customers("30", "30"),
                    new Customers("Rat a tooey", "10"),
                    new Customers("moewht", "15"),
                    new Customers("PNL", "20"),
                    new Customers("Tokyo ghoul", "30"));
    final HBox hbThree = new HBox();
 

    
    
    Owner owner=Owner.getInstance();
        
 
    //Start
    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) throws IOException {
        //Files files = Files.getInstance();
        //primaryStage refers to the only stage (i.e. window) that
        //we care about in this app.

        //Set title of stage
        primaryStage.setTitle("Muayad Abdel Kadir's Bookstore");
        //Create a scene and place it in the stage.
        //Note that call to createFirstGridPane creates a GridPane
        //inside that scene.
        
        primaryStage.setScene(new Scene(createFirstGridPane(), 500, 300));
        //display the stage
        
      
        primaryStage.show();

        //handle the ActionEvent when okButton is clicked
        loginButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                         
                        //System.out.println(newUsername + newPassword);
                        //Create a scene and place it in the stage.
                        //(the call to createSecondGridPane creates a GridPane
                        //inside that scene)
                        if(userTextField.getText().equals("admin") && passTextField.getText().equals("admin")){
                            primaryStage.setScene(new Scene(createOwnerGrid(), 600, 500));
                            System.out.println("Successfully logged in.");
                            
                        }else if(passTextField.getText().equals(owner.usernameInSystem(userTextField.getText()).getPassword())){
                            primaryStage.setScene(new Scene(createCustomerGrid(), 600, 500));
                            System.out.println("Successfully logged in.");  
  

                          }else{
                              primaryStage.setScene(new Scene(createFirstGridPaneWrong(), 500, 300));
                                System.out.println("Incorrect password and or username");
    
                          }
                    }
                }   
        );
        
     passTextField.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        TextField password = (TextField)e.getSource();          
                        System.out.println("Password: " + password.getText());  
                    }
                }
        );

        //called when the "close" icon [x] at the window's top-right is clicked
        primaryStage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent e) {
                        System.out.println("Successfully exited the book store.");
                    }
                }
        );
        
        logoutButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        primaryStage.setScene(new Scene(createFirstGridPane(), 500, 300));
               
                    }}
        );
        
        customersButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        primaryStage.setScene(new Scene(createSecondGridPane(), 600, 500));
            
                    }}
        );

        booksButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       primaryStage.setScene(new Scene(createThirdGridPane(), 600, 500));
       
                    }}
        );
        
        backButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       primaryStage.setScene(new Scene(createFirstGridPane(), 500, 300));

                    }}
        );
        newbackButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       primaryStage.setScene(new Scene(createOwnerGrid(), 600, 500));
       
                    }}
        );
        customerbackButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       primaryStage.setScene(new Scene(createOwnerGrid(), 600, 500));
       
                    }}
        );
        Buy.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       deleteSelectedRows(e);
                        
                       primaryStage.setScene(new Scene(createCustomerBuyGrid(), 600, 500));
                       
                    }}
        );
        Redeem.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                       deleteSelectedRows(e);
                        
                       primaryStage.setScene(new Scene(createCustomerBuyGrid(), 600, 500));
       
                    }}
        );
    }

    
    
    
    
    //OWNER LOGIN SCREEN
    
    public GridPane createOwnerGrid(){
        GridPane gp0 = new GridPane();
        gp0.setAlignment(Pos.CENTER);
        
        gp0.setHgap(10);
        gp0.setVgap(10);
        gp0.setPadding(new Insets(10));
        gp0.add(logoutButton, 0,2);
        
        gp0.add(customersButton, 2,2);
        gp0.add(booksButton, 1, 2);
        //gp0.add(backButton, 3,2);
        
        Text welcomeTxt = new Text("Welcome Admin");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        gp0.add(welcomeTxt, 0,0);
        
        gp0.setStyle("-fx-background-color: #ccccff");
     
        
        String image = getClass().getResource("hacker.jpg").toExternalForm();
        gp0.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
     
        logoutButton.getStyleClass().add("logoutButton");
        logoutButton.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
        
        customersButton.getStyleClass().add("loginButton");
        customersButton.setStyle("-fx-font: 15 arial; -fx-base: #3333ff;");
            
        booksButton.getStyleClass().add("loginButton");
        booksButton.setStyle("-fx-font: 15 arial; -fx-base: #3333ff;");
   
        return gp0;
    }
    
    
    
    //LOGIN Screen
    
    public GridPane createFirstGridPane() {
        GridPane gp1 = new GridPane();
        gp1.setAlignment(Pos.CENTER);
        //add a Button in the GridPane at column 0 and row 0
        gp1.setHgap(0); //horizontal gap in pixels => that's what you are asking for
        gp1.setVgap(5); //vertical gap in pixels
        gp1.setPadding(new Insets(10, 10, 10, 10));
        
        Label welcomeLabel = new Label("Please enter your Login: ");
        GridPane.setConstraints(welcomeLabel, 0, 0);
        welcomeLabel.setStyle("-fx-text-fill: #000000");
        
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);
        nameLabel.setStyle("-fx-text-fill: #0000ff");
        
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);
        passLabel.setStyle("-fx-text-fill: #0000ff");
        
        gp1.setStyle("-fx-background-color: #ccccff");
       
        
        gp1.add(userTextField, 1, 1);
        gp1.add(passTextField, 1, 2);
        gp1.add(loginButton, 1, 3);
     
        String image = getClass().getResource("startup.jpg").toExternalForm();
        gp1.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        
        gp1.getStyleClass().add("Clean.css");
        
            loginButton.getStyleClass().add("loginButton");
            loginButton.setStyle("-fx-font: 15 arial; -fx-base: #66ff66");
        //#66ff66
        //
        gp1.getChildren().addAll(welcomeLabel,nameLabel,passLabel);
        return gp1;
    }
    
    
    //LOGIN Screen Incorrect
    
     public GridPane createFirstGridPaneWrong() {
        GridPane gp1 = new GridPane();
        gp1.setAlignment(Pos.CENTER);
        //add a Button in the GridPane at column 0 and row 0
        gp1.setHgap(0); //horizontal gap in pixels => that's what you are asking for
        gp1.setVgap(5); //vertical gap in pixels
        gp1.setPadding(new Insets(10, 10, 10, 10));
        
        Label welcomeLabel = new Label("Please enter your Login: ");
        GridPane.setConstraints(welcomeLabel, 0, 0);
        welcomeLabel.setStyle("-fx-text-fill: #000000");
        
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);
        nameLabel.setStyle("-fx-text-fill: #0000ff");
        
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);
        passLabel.setStyle("-fx-text-fill: #0000ff");
        
        Label wrongLabel = new Label("Incorrect Username and or Password");
        GridPane.setConstraints(wrongLabel, 0, 2);
        wrongLabel.setStyle("-fx-text-fill: #cc9900");
        //#ff0000
        //#cc9900
        //#ff3333
        gp1.setStyle("-fx-background-color: #ccccff");
      

        gp1.add(userTextField, 1, 1);
        gp1.add(passTextField, 1, 2);
        gp1.add(loginButton, 1, 3);
        gp1.add(wrongLabel,1,4);
        

        String image = getClass().getResource("startup.jpg").toExternalForm();
        gp1.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
        
        loginButton.getStyleClass().add("loginButton");
        loginButton.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
        
        
        gp1.getStyleClass().add("Clean.css");
        
        gp1.getChildren().addAll(welcomeLabel,nameLabel,passLabel);
        return gp1;
    }
    
    
    
    //Admins Customer Button
     
    public Group createSecondGridPane() {               
        GridPane gp2 = new GridPane();
        
        Group bookTable = new Group();
        final Label label = new Label("Customers");
        label.setFont(new Font("Arial", 20));

        table.getColumns().clear();
        hb.getChildren().clear();
       //Delete everything in tableview before creating
  
        
        table.setEditable(true);

        TableColumn userNameCol = new TableColumn("Username");
        userNameCol.setMinWidth(175);
        userNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("userName"));
        userNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        userNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setUserName(t.getNewValue());
                    }
                }
        );

         TableColumn passCol = new TableColumn("Pass");
        passCol.setMinWidth(175);
        passCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("pass"));
        passCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPass(t.getNewValue());
                    }
                }
        );
        
        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setMinWidth(100);
        pointsCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("points"));
        pointsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        pointsCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPoints(t.getNewValue());
                    }
                }
        );

       

        table.setItems(data);
        table.getColumns().addAll(userNameCol, passCol, pointsCol);

        final TextField addUserName = new TextField();
        addUserName.setPromptText("Username");
        addUserName.setMaxWidth(100);
        final TextField addPass = new TextField();
        addPass.setMaxWidth(100);
        addPass.setPromptText("Password");
        final TextField addPoints = new TextField();
        addPoints.setMaxWidth(100);
        addPoints.setPromptText("Last Name");
        

        
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Person(
                        addUserName.getText(),
                        addPass.getText(),
                        addPoints.getText()));
                addUserName.clear();
                addPass.clear();
                addPoints.clear();
            }
        });
        
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Person selectedItem = table.getSelectionModel().getSelectedItem();
                    table.getItems().remove(selectedItem);
                        
        }});
        
        
       

        

        hb.getChildren().addAll(addUserName, addPass, addPoints, addButton, deleteButton, newbackButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 100));
        vbox.getChildren().addAll(label, table, hb);
        
        vbox.setStyle("-fx-font: 15 arial; -fx-base: #66ff66;");

        bookTable.getChildren().addAll(vbox);
        return bookTable;
    }
  
    
    
    
    
    
    
    //Admins Books Button
   
    public Group createThirdGridPane() {                            
        
    
        
        Group bookTable = new Group();
        final Label label = new Label("Book");
        label.setFont(new Font("Arial", 20));

 
        tableTwo.getColumns().clear();
        hbTwo.getChildren().clear();
        //Delete everything in tableview before creating
        
        tableTwo.setEditable(true);
        

        TableColumn bookNameCol = new TableColumn("Book Name");
        bookNameCol.setMinWidth(150);
        bookNameCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("bookName"));
        bookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        bookNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Book, String> t) {
                        ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBookName(t.getNewValue());
                    }
                }
        );
        
        



        TableColumn bookPriceCol = new TableColumn("Book Price");
        bookPriceCol.setMinWidth(150);
        bookPriceCol.setCellValueFactory(
                new PropertyValueFactory<Book, String>("bookPrice"));
        bookPriceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        bookPriceCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Book, String> t) {
                        ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBookPrice(t.getNewValue());
                    }
                }
        );


        tableTwo.setItems(dataTwo);                                               
        tableTwo.getColumns().addAll(bookNameCol, bookPriceCol);

        final TextField addBookName = new TextField();
        addBookName.setPromptText("Book Name");
        addBookName.setMaxWidth(100);
        final TextField addBookPrice = new TextField();
        addBookPrice.setMaxWidth(100);
        addBookPrice.setPromptText("Book Price");
     

        
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dataTwo.add(new Book(
                        addBookName.getText(),
                        addBookPrice.getText()));
                addBookName.clear();
                addBookPrice.clear();
           
            }
        });
        
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Book selectedItem = tableTwo.getSelectionModel().getSelectedItem();
                    tableTwo.getItems().remove(selectedItem);
                    
        }});
        


        hbTwo.getChildren().addAll(addBookName, addBookPrice, addButton, deleteButton, newbackButton);
        hbTwo.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 100));
        vbox.getChildren().addAll(label, tableTwo, hbTwo);

        vbox.setStyle("-fx-font: 15 arial; -fx-base: #66ff66;");
        
        bookTable.getChildren().addAll(vbox);
        return bookTable;
    }
    
    
    
    
    
    
    
    
    //Customer Screen
    
    
   
public Group createCustomerGrid(){
   
        Group bookTableTwo = new Group();
        final Label label = new Label("Welcome User. You have P points. Your status is S");
        label.setFont(new Font("Arial", 20));
 
        tableThree.getColumns().clear();
        hbThree.getChildren().clear();
                                                                                   //Delete everything in tableview before creating
        
        tableTwo.setEditable(true);

        TableColumn cusbookNameCol = new TableColumn("Book Name");
        
        cusbookNameCol.setMinWidth(150);
        cusbookNameCol.setCellValueFactory(
                new PropertyValueFactory<Customers, String>("bookName"));
        cusbookNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        cusbookNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customers, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customers, String> t) {
                        ((Customers) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBookName(t.getNewValue());
                    }
                }
        );
  
        TableColumn cusbookPriceCol = new TableColumn("Book Price");
        cusbookPriceCol.setMinWidth(150);
        cusbookPriceCol.setCellValueFactory(
                new PropertyValueFactory<Customers, String>("bookPrice"));
        cusbookPriceCol.setCellFactory(TextFieldTableCell.forTableColumn());
        cusbookPriceCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Customers, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Customers, String> t) {
                        ((Customers) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBookPrice(t.getNewValue());
                    }
                }
        );

       
       TableColumn selectCol = new TableColumn("Select");
       selectCol.setCellValueFactory(new PropertyValueFactory<CheckBox, String>("select"));            //Changed String to CheckBox
     

        tableThree.setItems(dataThree);                                               
        tableThree.getColumns().addAll(cusbookNameCol, cusbookPriceCol, selectCol);


        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Book selectedItem = tableTwo.getSelectionModel().getSelectedItem();
                    tableTwo.getItems().remove(selectedItem);
                        
        }});
        
        hbThree.getChildren().addAll( Buy, Redeem, logoutButton);
        hbThree.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 100));
        vbox.getChildren().addAll(label, tableThree, hbThree);

        vbox.setStyle("-fx-font: 15 arial; -fx-base: #6666ff;");
        
        bookTableTwo.getChildren().addAll(vbox);
        
        return bookTableTwo;
    }
    
    







    
//Customer BUY screen

        public GridPane createCustomerBuyGrid() {
        GridPane gp5 = new GridPane();
        gp5.setAlignment(Pos.CENTER);
        
        gp5.setHgap(10);
        gp5.setVgap(10);
        gp5.setPadding(new Insets(10));
        gp5.add(logoutButton, 0,2);
        
        //gp0.add(backButton, 3,2);
        
        Text TC = new Text("Total Cost: TC");
        TC.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        gp5.add(TC, 0,0);
        
        Text Points = new Text("Points: P, Status: S");
        Points.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        gp5.add(Points, 0,1);
        
        gp5.setStyle("-fx-background-color: #ccccff");
     
        
        String image = getClass().getResource("shoppin.jpg").toExternalForm();
        gp5.setStyle("-fx-background-image: url('" + image + "'); " +
           "-fx-background-position: center center; " +
           "-fx-background-repeat: stretch;");
     
        logoutButton.getStyleClass().add("logoutButton");
        logoutButton.setStyle("-fx-font: 15 arial; -fx-base: #ee2211;");
        
        customersButton.getStyleClass().add("loginButton");
        customersButton.setStyle("-fx-font: 15 arial; -fx-base: #3333ff;");
            
        booksButton.getStyleClass().add("loginButton");
        booksButton.setStyle("-fx-font: 15 arial; -fx-base: #3333ff;");
   
        return gp5;
    }
    

      private void deleteSelectedRows(ActionEvent event){
          
          ObservableList<Customers> dataListRemove = FXCollections.observableArrayList();
          for(Customers bean : dataThree){
              if(bean.getSelect().isSelected()){
                  dataListRemove.add(bean);  
              }     
          }
          dataThree.removeAll(dataListRemove);

      }
        
    
    
      public static  class Customers{
          
        private CheckBox select;
        
        private String bookName;
        private String bookPrice;

        private Customers(String BName, String BPrice) { 
            this.bookName = new String(BName);
            this.bookPrice = new String(BPrice);
            this.select = new CheckBox();
           
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String BName) {
            bookName = BName;
        }
        public String getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(String BPrice) {
            bookPrice = BPrice;
        }
        
        public CheckBox getSelect(){
            return select;
        }
        
        public void setSelect(CheckBox select){
            
            this.select = select;
        }

        
    }    
        
      
      
      
      
      
    
    public static class Person{

        private String userName;
        private String pass;
        private String points;
       
        
        private Person(String UName, String password, String ppoints) { 
            this.userName = new String(UName);
            this.pass = new String(password);
            this.points = new String(ppoints);
           
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String UName) {
            userName = UName;
        }
        public String getPass() {
            return pass;
        }

        public void setPass(String password) {
            pass = password;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String ppoints) {
            points = ppoints;
        }

        
    }
    
    
    
    
    
    
    
    

        public static class Book{

        private String bookName;
        private String bookPrice;
   
        private Book(String BName, String BPrice) {
            this.bookName = new String(BName);
            this.bookPrice = new String(BPrice);
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String BName) {
            bookName = BName;
        }

        public String getBookPrice() {
            return bookPrice;
        }

        public void setBookPrice(String BPrice) {
            bookPrice = BPrice;
        }
        }
    

    public static void main(String[] args) {
        launch(args);
    }
}