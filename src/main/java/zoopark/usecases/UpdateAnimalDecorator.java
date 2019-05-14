package zoopark.usecases;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.io.Serializable;

@Decorator
public abstract class UpdateAnimalDecorator implements IUpdateAnimal, Serializable {
    @Inject @Delegate @Any
    UpdateAnimal updateAnimal;

    public String updateAnimalName(){
        String result = updateAnimal.updateAnimalName();
        if (!result.contains("error")){
            System.out.println("All ZooKeepers must get an email regarding an Animal name change");
        }
        return result;
    }
}
