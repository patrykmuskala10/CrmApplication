package pl.patrykmuskala.CrmApplication.Model;


import javax.persistence.*;

@Entity
@Table(name = "salesmen")
public class Salesman {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teams_id", referencedColumnName = "id")
    private Team team;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Salesman() {
    }

    public Salesman(String name, String surname, Team team) {
        this.name = name;
        this.surname = surname;
        this.team = team;
    }
}
