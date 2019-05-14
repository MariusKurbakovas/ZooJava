package zoopark.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.Random;
import java.util.concurrent.Future;

@ApplicationScoped
@Alternative
public class VeryLongOperation implements ILongOperation {
    @Futureable
    public Future<Integer> doLongOperation() {
        try {
            Thread.sleep(5000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final Integer randomNumber = new Random().nextInt(4900) + 100;
        return new AsyncResult<>(randomNumber);
    }
}
