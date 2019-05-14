package zoopark.services;

import java.util.concurrent.Future;

public interface ILongOperation {
    Future<Integer> doLongOperation();
}
