import java.util.LinkedList;
import java.util.Queue;

public class DemergingWithQueue {
    public static void main(String[] args) {
        // Mô phỏng dữ liệu đã sắp xếp theo ngày tháng năm sinh
        Queue<Person> personQueue = new LinkedList<>();
        personQueue.add(new Person("Alice", "Female", "19900101"));
        personQueue.add(new Person("Bob", "Male", "19900505"));
        personQueue.add(new Person("Charlie", "Male", "19901010"));
        personQueue.add(new Person("Diana", "Female", "19901212"));
        personQueue.add(new Person("Eva", "Female", "19910202"));

        // Tổ chức lại dữ liệu
        Queue<Person> organizedQueue = demergeQueue(personQueue);

        // In ra kết quả
        while (!organizedQueue.isEmpty()) {
            System.out.println(organizedQueue.poll());
        }
    }

    public static Queue<Person> demergeQueue(Queue<Person> inputQueue) {
        Queue<Person> femaleQueue = new LinkedList<>();
        Queue<Person> maleQueue = new LinkedList<>();

        // Phân loại theo giới tính
        while (!inputQueue.isEmpty()) {
            Person person = inputQueue.poll();
            if ("Female".equals(person.gender)) {
                femaleQueue.add(person);
            } else {
                maleQueue.add(person);
            }
        }

        // Ghép lại theo thứ tự
        Queue<Person> organizedQueue = new LinkedList<>();
        while (!femaleQueue.isEmpty() || !maleQueue.isEmpty()) {
            if (!femaleQueue.isEmpty()) {
                organizedQueue.add(femaleQueue.poll());
            }
            if (!maleQueue.isEmpty()) {
                organizedQueue.add(maleQueue.poll());
            }
        }

        return organizedQueue;
    }
}


