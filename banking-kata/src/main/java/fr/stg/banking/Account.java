package fr.stg.banking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private List<Operation> operations;
    private int sold;

    public Account() {
        operations = new ArrayList<>();
    }

}
