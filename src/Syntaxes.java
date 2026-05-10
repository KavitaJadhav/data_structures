
import org.w3c.dom.Node;

import java.util.*;


public class Syntaxes {
    public static void main(String[] args) {
//        create a sub array
        int[] numbers = new int[]{1, 2, 3, 4};
        int[] range = Arrays.copyOfRange(numbers, 0, 2);
        System.out.println(range.length);


//        Hash operations
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.putIfAbsent(1, "one");
        numberMap.get(1);
        numberMap.put(2, "two");
        numberMap.keySet();
        numberMap.values();
        numberMap.getOrDefault(0, "Zero");


//        String manipulation
        String text = "Hello Jane";
        text.charAt(0);
        text.substring(1, 5);
        text.substring(0);


//stringbuffer
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append("world");


//split and join
        String[] names = new String[]{"kavita", "jyoti"};
        String joined = String.join(",", names);
        String[] splited = joined.split(",");


//queue
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.poll();


//priority queue(comparitor)
        Queue<Integer> minQueue = new PriorityQueue<>();
        minQueue.offer(2);
        minQueue.offer(1);
        minQueue.poll();


        Queue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        maxQueue.offer(1);
        maxQueue.offer(2);
        maxQueue.poll();


        class QueueNode {
            int num;
            String value;

            public QueueNode(int num, String value) {
                this.num = num;
                this.value = value;
            }
        }


        Queue<QueueNode> nodeQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.num));
        nodeQueue.offer(new QueueNode(2, "two"));
        nodeQueue.offer(new QueueNode(1, "one"));
        nodeQueue.poll();


//list
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.remove(0);


//link list
        List<Integer> linkList = new LinkedList<>();
        linkList.add(1);
        linkList.remove(0);


//stack
        Stack stack = new Stack();
        stack.push(1);
        stack.pop();


//set unordered
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);


//set ordered
        Set<Integer> set2 = new TreeSet<>();
        set1.add(1);


//collection methods
        int[] values = new int[]{1, 4, 6, 2, 8, 4};
        Arrays.sort(values);

        Arrays.stream(values).min();
        Arrays.stream(values).max();
        Arrays.stream(values).sum();
        Arrays.stream(values).average();

        List<Integer> valuesList = Arrays.asList(1, 2, 3, 4, 5);
        Collections.sort(valuesList);
        Collections.min(valuesList);
        Collections.max(valuesList);

        valuesList.stream().mapToInt(i -> i).sum();
        valuesList.stream().mapToDouble(i -> i).average().orElse(0.0);
    }
}

