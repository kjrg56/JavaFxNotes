JAVA FX TUTORIAL

// Creating a basic window.

  @Override
  public void start(Stage primaryStage) {
    StackPane layout = new StackPane();
    Scene scene = new Scene(layout, 300, 250);
    
    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
  }


// Handling button events and using lambda expressions

 	Button btn = new Button();

	btn.setOnAction(new EventHandler<ActionEvent>() {
	  @Override
	  public void handle(ActionEvent event) {
	    System.out.println("Using an anonymous inner class!");
	  }
	});

	btn.setOnAction((ActionEvent e) -> {
	  System.out.println("Using lambda expressions!!");
	});

	btn.setOnAction(e -> System.out.println("Using shorter lambda expression!"));


// Switching between scenes

  	private Stage window;
  	private Scene scene1, scene2;
  
  	@Override
    public void start(Stage primaryStage) {
	    window = primaryStage;
	    
	    //First Scene
	    Label label1 = new Label("Welcome to the first scene");
	    Button button1 = new Button("Go to scene 2");
	    button1.setOnAction(e -> window.setScene(scene2));
	    
	    //Layout 1 : children are laid out in vertical column
	    VBox layout1 = new VBox(20);    //Leaves a space of 20px between each control.
	    layout1.getChildren().addAll(label1, button1);
	    scene1 = new Scene(layout1, 200, 200);
	    
	    //Second Scene
	    Label label2 = new Label("Welcome to the second scene");
	    Button button2 = new Button("Go to scene 1");
	    button2.setOnAction(e -> window.setScene(scene1));
	    
	    //Layout 2
	    StackPane layout2 = new StackPane();
	    layout2.getChildren().addAll(label2, button2);
	    scene2 = new Scene(layout2, 300, 300);
	    
	    window.setScene(scene1);
	    window.setTitle("Hi!");
	    
	    window.show();
	    
	}


// Creating Alert Box

	private static void displayAlertBox(String title, String message) {
	    Stage alertBox = new Stage();
	    alertBox.initModality(Modality.APPLICATION_MODAL);
	    
	    Label dialogMessage = new Label(message);
	    
	    VBox layout = new VBox(20);
	    layout.setAlignment(Pos.CENTER);
	    layout.setMinWidth(100);
	    layout.getChildren().addAll(dialogMessage);
	    
	    Scene alertScene = new Scene(layout);
	    
	    alertBox.setScene(alertScene);
	    alertBox.setTitle(title);
	    alertBox.showAndWait();
	    
	}


// Creating Confirmation Box

    private static boolean displayConfirmBox(String title, String message) {
		Stage confirmBox = new Stage();
		confirmBox.initModality(Modality.APPLICATION_MODAL);

		Label dialogMessage = new Label(message);

		Button yesButton = new Button("YES");
		yesButton.setOnAction(e -> {
		  result = true;
		  confirmBox.close();
		});

		Button noButton = new Button("NO");
		noButton.setOnAction(e -> {
		  result = false;
		  confirmBox.close();
		});

		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER_LEFT);
		layout.setMinWidth(200);
		layout.getChildren().addAll(dialogMessage, yesButton, noButton);

		Scene alertScene = new Scene(layout);

		confirmBox.setScene(alertScene);
		confirmBox.setTitle(title);
		confirmBox.showAndWait();

		return result;
	}


// Do something when user wants to close the program

	primaryStage.setOnCloseRequest(e -> {
      e.consume(); // invalidates the event. It's like JS preventDefault.
      if (displayConfirmBox("Confirmation", "Are you sure you want to exit?")) {
        primaryStage.close();
      }
    });


// Embedding layouts in a BorderPane

    HBox topMenu = new HBox(10);
    Button btn1 = new Button("File");
    Button btn2 = new Button("Edit");
    Button btn3 = new Button("View");
    topMenu.getChildren().addAll(btn1, btn2, btn3);
    
    VBox leftMenu = new VBox(20);
    Button btnA = new Button("Left A");
    Button btnB = new Button("Left B");
    Button btnC = new Button("Left C");
    leftMenu.getChildren().addAll(btnA, btnB, btnC);
    
    BorderPane baseLayout = new BorderPane();
    baseLayout.setTop(topMenu);
    baseLayout.setLeft(leftMenu);
    
    Scene scene = new Scene(baseLayout);
    
    primaryStage.setScene(scene);
    primaryStage.show();


// Using a grid pane

	GridPane grid = new GridPane();
    grid.setPadding(new Insets(10));
    grid.setVgap(10);
    grid.setHgap(10);
    
    Label lblUsername = new Label("Username");
    GridPane.setConstraints(lblUsername, 1, 1);

    TextField txtUsername = new TextField();
    txtUsername.setPromptText("kjrg");
    GridPane.setConstraints(txtUsername, 2, 1);

    Label lblPassword = new Label("Password");
    GridPane.setConstraints(lblPassword, 1, 3);

    TextField txtPassword = new TextField();
    GridPane.setConstraints(txtPassword, 2, 3);
    
    Button btnLogIn = new Button("Sign In");
    GridPane.setConstraints(btnLogIn, 1, 4);
    
    grid.getChildren().addAll(lblUsername, txtUsername, lblPassword, txtPassword, btnLogIn);
    
    Scene scene = new Scene(grid, 600, 400);
    
    primaryStage.setScene(scene);
    primaryStage.show();


// Using checkboxes

    VBox layout = new VBox(10);
    
    CheckBox chk1 = new CheckBox("Pepperoni");
    CheckBox chk2 = new CheckBox("Ham");
    
    Button btn = new Button("Order now!");
    btn.setOnAction( e -> {
      if (chk1.isSelected()) {
        System.out.println("Your pepperoni pizza is on its way!");
      } else if (chk2.isSelected()) {
        System.out.println("Your ham pizza is on its way!");
      }
    });
    
    layout.getChildren().addAll(chk1, chk2, btn);
    
    Scene scene = new Scene(layout, 600, 400);
    
    primaryStage.setScene(scene);
    primaryStage.show();


// Using ChoiceBoxes (DropDownList)

    VBox layout = new VBox(10);
    
    ChoiceBox<String> fruits = new ChoiceBox<>();
    fruits.getItems().add("Orange");
    fruits.getItems().add("Banana");
    fruits.getItems().addAll("Pineapple", "Apple", "Peach");
    
    Button btn = new Button("Get Fruit");
    btn.setOnAction( e -> {
      System.out.println(fruits.getValue());
    });
    
    layout.getChildren().addAll(fruits, btn);
    
    Scene scene = new Scene(layout, 600, 400);
    
    primaryStage.setScene(scene);
    primaryStage.show();


// Adding a selection listener

	choicBox.getSelectionModel().selectedItemProperty()
      .addListener((observable, oldValue, newValue) -> {
        System.out.println(newValue);
    });

