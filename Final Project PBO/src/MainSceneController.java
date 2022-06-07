import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;

public class MainSceneController {
    @FXML
    private TextField Agama;

    @FXML
    private TextField Alamat;

    @FXML
    private TextField NamaLengkap;

    @FXML
    private TextField Tempat;

    @FXML
    private DatePicker TglLahir;

    @FXML
    private TextField jeniskelamin;

    @FXML
    private TextField nik;
    
    @FXML
    private Button btnTerdaftar;

    @FXML
    private Label terdaftar;

    @FXML
    private TextField tfEmail;

    @FXML
    private PasswordField tfKataSandi;

    @FXML
    private TextField tfnamaLengkap;

    @FXML
    private Label salah;
    
    @FXML
    private PasswordField tfPassword;

    @FXML
    void btnDaftarClicked(ActionEvent event) throws IOException {
            System.out.println("this is clicked");
        Parent root = FXMLLoader.load(getClass().getResource("Daftar.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
}
    
        @FXML
        public void btnLoginClicked(ActionEvent e) throws IOException {
            System.out.println("this is clicked");
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            String email = tfEmail.getText();
            String password = tfPassword.getText(); 
            System.out.println(email + " " + password);

            ArrayList<String> listAkun = new ArrayList<String>();

            File myObj = new File("E:\\project\\Project.java\\src\\akun.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(", ");
                if(data[1].equals(email) && data[2].equals(password)) {
                    System.out.println("Succesful login");
                    Stage stage = (Stage) tfEmail.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                }else {
                    salah.setText("Email atau Password salah");;
                }
            }
            
        }
        @FXML
        void terdaftarHandler(ActionEvent event) throws IOException {
            if(tfnamaLengkap.getText().isEmpty()) {
                terdaftar.setText("Anda Belum Terdaftar");
                
            }
            else {
                terdaftar.setText("Akun Anda Telah Terdaftar");
                FileWriter myWriter = new FileWriter("E:\\project\\Project.java\\src\\akun.txt",true);
                myWriter.write(tfnamaLengkap.getText()+ ", " +tfEmail.getText() + ", " + tfKataSandi.getText()+ "\n");
                myWriter.close();
                System.out.println("Akun Anda Telah Terdaftar");
                Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        }
        @FXML
        void btnKirim(ActionEvent event) throws IOException {
        FileWriter myWriter = new FileWriter("E:\\project\\Project.java\\src\\biodata.txt",true);
        myWriter.write(NamaLengkap.getText()+ ", " + Tempat.getText() + ", " + TglLahir.getValue()+", " + jeniskelamin.getText() + ", " + Agama.getText() + ", " + Alamat.getText() + ", "+ nik.getText()+ ", " + "\n");
        System.out.println("Biodata Anda Telah Terkirim");
        myWriter.close();
    }
}