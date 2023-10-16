module srt.eugene {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens srt.eugene to javafx.fxml;
    exports srt.eugene;
}