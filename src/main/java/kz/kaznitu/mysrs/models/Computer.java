package kz.kaznitu.mysrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String computerName;
    private String numbers;

    public Computer() {
    }

    public Computer(int id, String computerName, String numbers) {
        this.id = id;
        this.computerName = computerName;
        this.numbers = numbers;
    }

    public Computer(String computerName, String numbers) {
        this.computerName = computerName;
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}


