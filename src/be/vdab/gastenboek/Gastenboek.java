package be.vdab.gastenboek;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gastenboek implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<GastenboekEntry> entries = new ArrayList<>();
    public List<GastenboekEntry> getEntries() {
        return entries;
    }

    public void add(GastenboekEntry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Entry mag niet null zijn");
        }
        entries.add(entry);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = entries.size() - 1; i >=0; i--) {
            builder.append(entries.get(i)).append("\n");
        }
        return builder.toString();
    }
}
