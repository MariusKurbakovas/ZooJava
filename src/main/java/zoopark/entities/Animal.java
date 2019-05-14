package zoopark.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Animal.findAll", query = "select a from Animal as a")
})
@Table(name = "Animal")
@Getter @Setter
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Building_Id")
    private Building building;

    @ManyToMany
    @JoinTable(name="Animal_ZooKeeper")
    private List<ZooKeeper> zooKeeper = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    public Animal() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
