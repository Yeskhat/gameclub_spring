package kz.kaznitu.mysrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Playstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String playstationName;
    private String numbers;

    public Playstation() {
    }

    public Playstation(int id, String playstationName, String numbers) {
        this.id = id;
        this.playstationName = playstationName;
        this.numbers = numbers;
    }

    public Playstation(String playstationName, String numbers) {
        this.playstationName = playstationName;
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaystationName() {
        return playstationName;
    }

    public void setPlaystationName(String playstationName) {
        this.playstationName = playstationName;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}

