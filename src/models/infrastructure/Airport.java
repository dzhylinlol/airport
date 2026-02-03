package models.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String code;
    private String name;
    private List <Terminal> terminals;

    public Airport() {};

    public Airport(String code, String name) {
        this.code = code;
        this.name = name;
        this.terminals = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Airport {" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", terminals=" + terminals +
                '}';
    }

    public void addTerminal(String terminalName) {
        Terminal terminal = new Terminal(terminalName);
        terminals.add(terminal);

    }
    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }
}




