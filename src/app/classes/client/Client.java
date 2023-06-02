package app.classes.client;

import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private Bill bill;
    private int table = 0;

    public Client(
            String name,
            Bill bill,
            int table
    ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bill = new Bill();
        this.table = table;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}