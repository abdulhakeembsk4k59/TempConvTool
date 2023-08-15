module com.hakeem.tempconvtool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hakeem.tempconvtool to javafx.fxml;
    exports com.hakeem.tempconvtool;
}