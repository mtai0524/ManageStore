package com.javafxControllers.pm;

import com.models.pm.Product;
import com.views.pm.EnviromentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageProductController implements Initializable {
    @FXML private Stage stage;
    @FXML private Button show;
    @FXML private Button btnFullScreen;
    @FXML private Button btnPrevious;

    @FXML private Button btnInsertProd;
    @FXML private Button btnDeleteProd;

    @FXML private TableView<Product> tbProduct;
    @FXML private TableColumn<Product, Integer> id;
    @FXML private TableColumn<Product, String> name;
    @FXML private TableColumn<Product, Integer> quantity;

    @FXML private TableColumn<Product, Integer> price;

    @FXML private TableColumn<Product, String> category;
    @FXML private TableColumn<Product, String> supplier;

    private ObservableList<Product> productList;

    @FXML private ComboBox<String> cbCategory;
    @FXML private ComboBox<String> cbSupplier;

    @FXML private TextField txtName;
    @FXML private TextField txtQuantity;
    @FXML private TextField txtPrice;
    ObservableList<String> listCaterories = FXCollections.observableArrayList("nòi hấp bánh bao", "dao gọt trái cây", "dụng cụ tưới hoa", "cuốc xẻn");
    ObservableList<String> listSupplier = FXCollections.observableArrayList("Hạt dẻ nhỏ", "Đâụ đậu", "Bánh bao chin", "Chôm chôm");
    private int dem = 1;
    public void deleteProd(ActionEvent event){
        ObservableList<Product> list = tbProduct.getItems();
//        System.out.println("delete");
        if(list.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Notification");
            alert.setContentText("Table is empty");
            alert.setHeaderText("Table is empty");
            ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(buttonTypeOK);
            alert.showAndWait();
        }
        else if(tbProduct.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Notification");
            alert.setContentText("Please choose row to delete");
            alert.setHeaderText("Choose row to delete");
            ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            alert.getButtonTypes().setAll(buttonTypeOK);
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirm");
            alert.setContentText("Do you want to delete this row");
            alert.setHeaderText("Delete row?");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeYes) {
                try {
                    //DELETE MUTIPLE ROW
                    ObservableList<Product> productsSelected = tbProduct.getSelectionModel().getSelectedItems();
                    ;
                    tbProduct.getItems().removeAll(productsSelected);

                    //DELETE ONE ROW
//                    Product selectedItem = tbProduct.getSelectionModel().getSelectedItem();
//                    tbProduct.getItems().remove(selectedItem);
                } catch (Exception e) {
                    return;
                }
            }
        }


    }

    public void insertProd(ActionEvent event){
        Product p = new Product();
        try{
            p.setName(txtName.getText());
            p.setQuantity(Integer.parseInt(txtPrice.getText()));
            p.setPrice(Integer.parseInt(txtPrice.getText()));
            p.setCategory(cbCategory.getValue());
            p.setSupplier(cbSupplier.getValue());
            p.setId(dem++);
            productList.add(p);
        }
        catch (Exception e){
            return;
        }
    }
    private Boolean checkFullScreen = true;
    public void fullScreen(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if (!checkFullScreen){
            btnFullScreen.setText("Full screen");
            checkFullScreen = !checkFullScreen;
        }
        else{
            btnFullScreen.setText("Escape");
            checkFullScreen = !checkFullScreen;
        }
        if (!stage.isFullScreen())
            stage.setFullScreen(true);
        else
            stage.setFullScreen(false);
        stage.show();
    }
    public void previousPage(ActionEvent event) throws IOException {
        EnviromentController evm = new EnviromentController();
        evm.switchScene(event, "HomePage.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbProduct.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listCaterories.add("Tai u ");
        productList = FXCollections.observableArrayList(
                new Product(dem++,"tidi", 100,14,  "điện tử", "sony"),
                new Product(dem++, "lo vi song",200,100 , "dụng cụ nấu ăn", "tosiba"),
                new Product(dem++,"dao",300,99, "dụng cụ làm bếp", "tàu khựa")
        );
        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        supplier.setCellValueFactory(new PropertyValueFactory<Product, String>("supplier"));
        tbProduct.setItems(productList);

        // COMBO BOX
        cbCategory.setItems(listCaterories);
        cbSupplier.setItems(listSupplier);

    }
    public void show(ActionEvent event){

    }
}
