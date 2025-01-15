package tasks;

import java.util.HashSet;
import java.util.LinkedList;

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Logger {
    private LinkedList<Pair<String, Integer>> msgQueue;
    private HashSet<String> msgSet;

    /** Initialize your data structure here. */
    public Logger() {
        msgQueue = new LinkedList<Pair<String, Integer>>();
        msgSet = new HashSet<String>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {

        // clean up.
        while (msgQueue.size() > 0) {
            Pair<String, Integer> head = msgQueue.getFirst();
            if (timestamp - head.second >= 10) {
                msgQueue.removeFirst();
                msgSet.remove(head.first);
            } else
                break;
        }

        if (!msgSet.contains(message)) {
            Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
            msgQueue.addLast(newEntry);
            msgSet.add(message);
            return true;
        } else
            return false;

    }

    public static void main(String[] args) {
//        [[],[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));


    }
}
