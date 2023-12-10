module srt.eugene {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens srt.eugene to javafx.fxml;
    exports srt.eugene;
}