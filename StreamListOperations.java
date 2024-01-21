import java.util.List;
import java.util.stream.Collectors;

public class StreamListOperations {
    public static <T> List<T> filter(List<T> list, FilterCondition<T> condition) {
        return list.stream()
                .filter(condition::test)
                .collect(Collectors.toList());
    }

    public static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        return list.stream()
                .map(mapper::apply)
                .collect(Collectors.toList());
    }

    public static <T> T reduce(List<T> list, Reducer<T> reducer, T identity) {
        return list.stream()
                .reduce(identity, reducer::combine);
    }

    public interface FilterCondition<T> {
        boolean test(T t);
    }

    public interface Mapper<T, R> {
        R apply(T t);
    }

    public interface Reducer<T> {
        T combine(T t1, T t2);
    }
}
