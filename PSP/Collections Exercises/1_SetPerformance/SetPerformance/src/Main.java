import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main() {
        HashSet<Integer> hashList = new HashSet<>();
        TreeSet<Integer> treeList = new TreeSet<>();

        //1. Add 100,000 (integer) random items. Compare times.
        //RESULTS
        //HashSet: The operation takes: 11ms
        //TreeList: The operation takes: 15ms
        Instant start = Instant.now();
        for(int i = 0; i < 100000; i++){
            treeList.add(i);

        }
        Instant end = Instant.now();
        Duration dur = Duration.between(start, end);
        System.out.printf("HashSet: The operation ... takes: %dms\n", dur.toMillis());


        //2. Check if 50,000 random items are present in the sets.
        //RESULTS
        // HashSet: The operation ... takes: 6ms
        //TreeList: The operation ... takes: 15ms
        Random random = new Random();
        start = Instant.now();
        for (int i = 0; i < 50000; i++) {
            treeList.contains(random.nextInt(100000));
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("HashSet: The operation ... takes: %dms\n", dur.toMillis());


        //3. Remove 50,000 items.
        //RESULTS
        //HashSet: The operation ... takes: 3ms
        //TreeList: The operation ... takes: 18ms
        start = Instant.now();
        for(int i = 0; i<50000; i++){
            treeList.remove(i);
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("HashSet: The operation ... takes: %dms\n", dur.toMillis());


        //4. Iterate through all items.
        //RESULTS
        //HashSet: The operation ... takes: 2ms
        //TreeList: The operation ... takes: 4ms
        start = Instant.now();
        for(Integer i : hashList){
            // do nothing
        }
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.printf("HashSet: The operation ... takes: %dms\n", dur.toMillis());
    }
}


