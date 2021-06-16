package sample;

import com.sun.org.slf4j.internal.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Controller {


    @FXML
    private MenuItem menueItemCopiar;
    @FXML
    private MenuItem menueItemTallar;
    @FXML
    private MenuItem menueItemEngaxar;
    @FXML
    private MenuItem menueItemDesfer;
    @FXML
    private MenuItem menueItemSortir;
    @FXML
    private Menu menueItemFont;
    @FXML
    private Menu menueItemTamany;
    @FXML
    private MenuItem menuItemSmall;
    @FXML
    private MenuItem menuItemDefault;
    @FXML
    private MenuItem menuItemLarge;
    @FXML
    private MenuItem menuItemXLarge;
    @FXML
    private MenuItem menuItemArial;
    @FXML
    private MenuItem menuItemPerpetua;
    @FXML
    private MenuItem menuItemMagneto;

    @FXML
    private Menu menueAjuda;
    @FXML
    private MenuItem menueItemSobreEditor;
    @FXML
    private MenuItem menueItem;
    @FXML
    private TextArea taText;

    private String myText;

    final Clipboard clipboard = Clipboard.getSystemClipboard();

    @FXML
    public void initialize() {
        createContextMenu();
        taText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent evt) {
                if(evt.getButton() == javafx.scene.input.MouseButton.SECONDARY) {
                    if(!taText.isUndoable()) menueItemDesfer.setDisable(true);
                    else menueItemDesfer.setDisable(false);
                    if(taText.getSelectedText().equals("")) {
                        menueItemTallar.setDisable(true);
                        menueItemCopiar.setDisable(true);
                        menueItemEngaxar.setDisable(true);
                    } else {
                        menueItemTallar.setDisable(false);
                        menueItemCopiar.setDisable(false);
                        menueItemEngaxar.setDisable(false);

                    }
                }
            }
        });
    }

    private void createContextMenu() {
        final ContextMenu contextMenu = new ContextMenu();
        menueItemDesfer = new MenuItem("Undo");
        menueItemTallar = new MenuItem("Cut");
        menueItemCopiar = new MenuItem("Copy");
        menueItemEngaxar = new MenuItem("Paste");

        menueItemDesfer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                taText.undo();
            }
        });

        menueItemTallar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                taText.cut();
            }
        });

        menueItemCopiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                taText.copy();
            }
        });

        menueItemEngaxar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                taText.paste();
            }
        });

        contextMenu.getItems().addAll(menueItemDesfer, menueItemTallar, menueItemCopiar, menueItemEngaxar);
        taText.setContextMenu(contextMenu);
    }


    @FXML
    void onChangeFont(javafx.event.ActionEvent event) {
        String menuItemSelected = ((MenuItem) event.getSource()).getId();

        switch (menuItemSelected) {
            case "menuItemArial":
                textAreaArial();
                break;
            case "menuItemPerpetua":
                textAreaPerpetua();
                break;
            case "menuItemMagneto":
                textAreaMagneto();
                break;
            default:
                System.out.println("");
        }
    }
    @FXML
    void onChangeSize(javafx.event.ActionEvent event) {

        String menuItemSelected = ((MenuItem) event.getSource()).getId();

        switch (menuItemSelected) {
            case "menuItemSmall":
                textAreaSmall();
                break;
            case "menuItemDefault":
                textAreaDefault();
                break;
            case "menuItemLarge":
                textAreaLarge();
                break;
            case "menuItemXLarge":
                textAreaXLarge();
                break;
            default:
                System.out.println("");
        }

    }

    private void textAreaArial ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font ("Arial"));
        taText.setStyle("-fx-font-family: Arial");

    }

    private void textAreaPerpetua ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font ("Calibri"));
        taText.setStyle("-fx-font-family:  Perpetua Titling MT");

    }

    private void textAreaMagneto ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font ("Tahoma"));
        taText.setStyle("-fx-font-family: Magneto");


    }

    private void textAreaSmall ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font (10));
        taText.setStyle("-fx-font-size: 10");

    }

    private void textAreaDefault ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font (12));
        taText.setStyle("-fx-font-size: 12");

    }

    private void textAreaLarge ()
    {
        taText.getSelectedText();
        //taText.setFont (Font.font (16));
        taText.setStyle("-fx-font-size: 16");


    }

    private void textAreaXLarge() {
        taText.getSelectedText();
        //taText.setFont (Font.font (20));
        taText.setStyle("-fx-font-size: 20");

    }

    @FXML
    void onCopy() {
        if (!taText.isFocused()) menueItemCopiar.setDisable(true);

        else {
            myText = taText.getSelectedText();

            final ClipboardContent content = new ClipboardContent();
            content.putString(myText);
            clipboard.setContent(content);
        }
    }

    @FXML
    void onCut() {
        myText = taText.getSelectedText();
        taText.cut();

        final ClipboardContent content = new ClipboardContent();
        content.putString(myText);
        clipboard.setContent(content);
    }

    @FXML
    void onPaste() {
        taText.paste();
    }

    @FXML
    void onUndo() {
        taText.cancelEdit();
        taText.undo();
        clipboard.clear();
    }

    @FXML
    void onClick_Font (ActionEvent event){
    }


    @FXML
    void about (){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("About");
        alert.setHeaderText("Aquest editor de text permet crear i\n" +
                "modificar arxius digitals compostos\n " +
                "únicament per textos sense format,\n " +
                "coneguts comunament com arxius\n" +
                "de text o text pla");
        alert.setContentText("https://github.com/mousaab_kammal");
        alert.showAndWait();
    }

    //Obtener el objeto de estancia unica de un método de fábrica estático, para trabajar con el portapapeles,

    public void onClick_menueItemSortir(javafx.event.ActionEvent actionEvent) {
        Platform.exit();
    }



}