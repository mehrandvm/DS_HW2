package org.ds.morteza;

import com.sun.org.apache.regexp.internal.RECompiler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Graphic implements Initializable {
@FXML
private HBox texts;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node text = texts.getChildren().get(0);
        ((Text)text).setTextContent("12321");
    }
}
