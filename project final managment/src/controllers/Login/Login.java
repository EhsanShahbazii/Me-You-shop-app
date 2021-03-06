package controllers.Login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import modules.files.LoginCheck;
import modules.object.Person;
import modules.tools.GlobalTools;

import java.io.IOException;

public class Login {

    //variables which are used
    public static Person person = new Person();
    public GlobalTools globalTools = new GlobalTools();
    public LoginCheck loginCheck = new LoginCheck();
    String username, password, toggle = "management";
    //to know user can login or not
    public static boolean loginIsDone = false;

    public void initialize() {
        //limit text field length
        globalTools.LimitedTextField(passwordTextField, 20);
        globalTools.LimitedTextField(usernameTextField, 20);
    }

    @FXML
    private JFXToggleButton chooseToggle;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXPasswordField passwordTextField;

    @FXML
    private JFXButton loginButton;

    //add login logic in below with exceptions
    @FXML
    void LoginAction(ActionEvent event) throws IOException {

        //save text field data in variables
        username = usernameTextField.getText();
        password = passwordTextField.getText();

        // show error if fields are empty
        if (usernameTextField.getText().isEmpty())
            globalTools.AlertShow("please enter your username.");
        else if (passwordTextField.getText().isEmpty())
            globalTools.AlertShow("please enter your password.");
        else if (!loginCheck.loginCheck(username, password, toggle)) {
            //checkToLogin() method checks is username and password  and toggle are right or not
            globalTools.AlertShow("your username or password is incorrect.");
        } else {
            //set username and password of current user
            person.setUsername(username);
            person.setPassword(password);
            person.setToggle(toggle);
            loginIsDone = true;

            //this statement show person is admin or management
            if (toggle.equals("management")) {
                //open new management page and close login pages
                globalTools.OpenNewPageXY(loginButton, "/pages/managment/managementPage.fxml", "management", 450, 110);
            } else {
                //open new admin page and close login pages
                globalTools.OpenNewPageXY(loginButton, "/pages/admin/adminPage.fxml", "admin", 450, 110);
            }
        }
    }

    //set admin or management toggle
    @FXML
    void toggleAction(ActionEvent event) {
        //get toggle and is selected or not
        if (chooseToggle.isSelected()) {
            toggle = "admin";
        }else {
            toggle = "management";
        }

    }
}
