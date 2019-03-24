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
        @NamedQuery(name = "Building.findAll", query = "select a from Building as a")
})
@Table(name = "Building")
@Getter
@Setter
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "building")
    private List<Animal> animals = new ArrayList<>();

    public Building() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(id, building.id) &&
                Objects.equals(name, building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
