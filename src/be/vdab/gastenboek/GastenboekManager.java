package be.vdab.gastenboek;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GastenboekManager {

    private final static Path PAD = Path.of("/Users/joann/data/gastenboek.ser");
    public void schrijfGastenboek(Gastenboek gastenboek) {
        try (var stream = new ObjectOutputStream(Files.newOutputStream(PAD))) {
            stream.writeObject(gastenboek);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Gastenboek leesGastenBoek() {
        if (Files.exists(PAD)) {
            try (var stream = new ObjectInputStream(Files.newInputStream(PAD))) {
                return (Gastenboek) stream.readObject();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return new Gastenboek();
    }
}
