package kz.kaznitu.mysrs.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Gameclub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gameclubName;
    private String address;

    @ManyToMany
    private List<Computer> computers;
    @ManyToMany
    private List<Playstation> playstations;

    public Gameclub() {
    }

    public Gameclub(int id, String gameclubName, String address) {
        this.id = id;
        this.gameclubName = gameclubName;
        this.address = address;
    }

    public Gameclub(String gameclubName, String address) {
        this.gameclubName = gameclubName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameclubName() {
        return gameclubName;
    }

    public void setGameclubName(String gameclubName) {
        this.gameclubName = gameclubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<Playstation> getPlaystations() {
        return playstations;
    }

    public void setPlaystations(List<Playstation> playstations) {
        this.playstations = playstations;
    }

    public boolean hasComputer(Computer computer){
        for(Computer containedSkill:getComputers()){
            if(containedSkill.getId() == computer.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean hasPlaystation(Playstation playstation){
        for(Playstation containedSkill:getPlaystations()){
            if(containedSkill.getId() == playstation.getId()){
                return true;
            }
        }
        return false;
    }
}
