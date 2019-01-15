/*
 * The GoodsDispenser class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package goodsdispenser;

/**
 * This is a simulation of a goods dispenser system.
 * Consumers wait in the queue in front of the dispenser.
 * The dispenser dispenses goods to the consumers in the 
 * order of their arrivals (FIFO).
 * If there are no goods in the dispenser, the consumers must wait for refill
 * and the next dispense cycle.
 * @author Drazen
 */
public class GoodsDispenser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QueuedGoodsDispenser dispenser = new QueuedGoodsDispenser();
        dispenser.reportSummary();
        
        System.out.println("-".repeat(40));
        dispenser.enqueueConsumer("Jane");
        dispenser.enqueueConsumers(new String[] {"Bob", "Alice", "Jack"});
        dispenser.addGoods(2);
        dispenser.reportSummary();
        dispenser.reportQueue();
        
        System.out.println("-".repeat(40));
        dispenser.dispense();
        dispenser.reportSummary();
        dispenser.reportQueue();
        
        System.out.println("-".repeat(40));
        dispenser.addGoods(5);
        dispenser.dispense();
        dispenser.reportSummary();
        dispenser.reportQueue();
        
        System.out.println("-".repeat(40));
        dispenser.enqueueConsumer("Mike");
        dispenser.enqueueConsumer("Cindy");
        dispenser.enqueueConsumer("Fred");
        dispenser.reportSummary();
        dispenser.reportQueue();
        dispenser.dispense();
        dispenser.reportSummary();
        dispenser.reportQueue();
    }   
}