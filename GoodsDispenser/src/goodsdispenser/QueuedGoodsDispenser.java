/*
 * The QueuedGoodsDispenser class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package goodsdispenser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements goods dispenser system.
 * Consumers wait in the queue in front of the dispenser.
 * The dispenser dispenses goods to the consumers in the 
 * order of their arrivals (FIFO).
 * If there are no goods in the dispenser, the consumers must wait for refill
 * and the next dispense cycle.
 * The class provides methods to add goods, add consumers, dispense goods, 
 * and various reports about the state of the dispenser and the queue.
 * @author Drazen
 */
public class QueuedGoodsDispenser {
    // Counter for the quantity of goods in the dispenser
    private int goodsQty;
    
    // Queue in front of the dispenser
    private final Queue<String> consumersQueue;

    /**
     * Default constructor.
     * In the beginning, the dispenser is empty and no consumer is in the queue.
     */
    public QueuedGoodsDispenser() {
        this.goodsQty = 0;
        this.consumersQueue = new LinkedList<>();
    }
    
    /**
     * Simulates dispenser refill
     * @param qty refill quantity
     */
    public void addGoods(int qty) {
        System.out.format("Adding %d goods\n", qty);
        this.goodsQty += qty;
    }
    
    /**
     * Adds an array of consumers into the queue
     * @param consumers an array of consumers to add into the queue
     */
    public void enqueueConsumers(String[] consumers) {
        this.consumersQueue.addAll(Arrays.asList(consumers));
        System.out.format("Enqueue %s\n", Arrays.toString(consumers));
    }
    
    /**
     * Add single consumer into the queue
     * @param consumer a consumer to add into the queue
     */
    public void enqueueConsumer(String consumer) {
        this.consumersQueue.add(consumer);
        System.out.format("Enqueue %s\n", consumer);
    }
    
    /**
     * Shows summary report for the dispenser, which consists of
     * quantity of goods and queue size.
     * Example: Goods Qty: 3	 Queue Size: 0
     */
    public void reportSummary() {
        System.out.format("Goods Qty: %d\t Queue Size: %d\n", 
                this.goodsQty, this.consumersQueue.size());
    }
    
    /**
     * Lists all consumers in the queue.
     */
    public void reportQueue() {
        this.consumersQueue.stream().forEach((String consumer) -> {
            System.out.println(consumer);
        });
    }
    
    /**
     * Dispenses goods to consumers until there are no goods left
     * or all consumers are served. 
     */
    public void dispense() {
        while (this.goodsQty > 0) {
            if (this.consumersQueue.isEmpty()) {
                break;
            }
            String consumer = this.consumersQueue.remove();
            System.out.format("Serving consumer: %s\n", consumer);
            this.goodsQty--;
        }
    }
}
