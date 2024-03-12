package dat3.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cinema {

    @Id
    private Long id;
    private String name;
    private String address;

    public Cinema(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Cinema() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
