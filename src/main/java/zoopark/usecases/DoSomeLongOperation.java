package zoopark.usecases;

import zoopark.interceptors.LogAspect;
import zoopark.services.ILongOperation;
import zoopark.services.LongOperation;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class DoSomeLongOperation implements Serializable {
    @Inject
    ILongOperation longOperation;

    private Future<Integer> longOperationTask = null;

    @LogAspect
    public String doLongOperation() {
        longOperationTask = longOperation.doLongOperation();
        return  "index?faces-redirect=true";
    }

    public boolean isLongOperationRunning() {
        return longOperationTask != null && !longOperationTask.isDone();
    }

    public String getLongOperationStatus() throws ExecutionException, InterruptedException {
        if (longOperationTask == null){
            return null;
        } else if (isLongOperationRunning()) {
            return "Long operation is in progress...";
        }
        return "Long operation is finished, the result: " + longOperationTask.get();
    }
}
