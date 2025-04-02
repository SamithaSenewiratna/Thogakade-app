package controller.item;

import com.jfoenix.controls.JFXTextField;

import dto.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ServiceFactory;
import service.custom.ItemService;
import util.ServiceType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;







public class itemFormController implements Initializable {

   ItemService service   = ServiceFactory.getInstance().getServiceType(ServiceType.ITEM);

    public TableColumn colItemCode;
    public TableColumn colDiscription;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;

    public JFXTextField txtQtyOnHand;
    public JFXTextField txtItemCode;
    public JFXTextField txtDiscription;
    public JFXTextField txtUnitPrice;

    public TableView tblItems;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDiscription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qty"));
        loadTable();
    }


    private void loadTable() {
        List<Item> all = service.getAll();
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        all.forEach(item -> {
            itemObservableList.add(item);
        });
        tblItems.setItems(itemObservableList);
    }


    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
    }


}
