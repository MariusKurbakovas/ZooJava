package zoopark.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "ZooKeeper.findAll", query = "select a from ZooKeeper as a")
})
@Table(name = "ZooKeeper")
@Getter
@Setter
public class ZooKeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Name")
    private String name;

    @ManyToMany(mappedBy = "zooKeeper")
    private List<Animal> animals = new ArrayList<>();

    public ZooKeeper() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZooKeeper zooKeeper = (ZooKeeper) o;
        return Objects.equals(id, zooKeeper.id) &&
                Objects.equals(name, zooKeeper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
