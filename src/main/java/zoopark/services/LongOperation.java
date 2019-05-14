package zoopark.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
@Alternative
public class LongOperation implements Serializable, ILongOperation {

    @Futureable
    public Future<Integer> doLongOperation() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final Integer randomNumber = new Random().nextInt(100);
        return new AsyncResult<>(randomNumber);
    }
}
