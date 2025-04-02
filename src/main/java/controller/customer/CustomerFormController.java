package controller.customer;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dto.Customer;
import service.ServiceFactory;
import service.custom.CustomerService;
import util.ServiceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSalary;

    @FXML
    private TableView tblCustomer;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSalary;

    CustomerService service = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        loadTable();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

        Customer customer = new Customer(
                        txtId.getText(),
                        txtName.getText(),
                        txtAddress.getText(),
                        Double.parseDouble(txtSalary.getText())
                );

        if(customerService.saveCustomer(customer)){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added!!").show();
            loadTable();


        }else {
            new Alert(Alert.AlertType.ERROR,"Customer Not Added : (").show();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Customer customer = service.searchCustomer(txtId.getText());
        System.out.println(customer);

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    private void loadTable() {
        List<Customer> all = service.getAll();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        all.forEach(customer -> {
            customerObservableList.add(customer);
        });
        tblCustomer.setItems(customerObservableList);
    }


}
