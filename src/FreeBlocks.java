import java.util.LinkedList;

/**
 * @author Justin Shelton and Peyton Dexter
 * @version 12.08.2021
 */
public class FreeBlocks {

    LinkedList<LinkedList<Block>> freeList = new LinkedList<>();
    byte[] memPool;
    int memMax;

    /**
     * constructor to set up memory
     * 
     * @param memSize
     *            given size
     */
    public FreeBlocks(int memSize) {
        memMax = memSize;
        memPool = new byte[memSize];
        for (int i = 1; i <= memSize; i = i * 2) {
            freeList.add(new LinkedList<Block>());
        }
        freeList.getLast().add(new Block(0));
    }


    public Handle insert(byte[] space, int size) {
        // see if insert is bigger than mem size
        if (space.length > memMax) {
            int drac = 0;
            while (space.length > memMax) {
                memMax = memMax * 2;
                drac++;
            }
            byte[] memCopy = new byte[memMax];
            System.arraycopy(memPool, 0, memCopy, 0, memPool.length);
            memPool = memCopy;
            System.out.println("Memory pool expanded to be" + memMax
                + "bytes.");
        }
        // find open space
        int start = this.log(space.length);
        if (freeList.get(start).size() != 0) {
            System.arraycopy(space, 0, memPool, freeList.get(start).get(0)
                .getPosition(), space.length);
            freeList.get(start).remove(0);
        }
        else while (start <= freeList.size() && freeList.get(start).size() == 0) {
            start++;
        }
        if (start > freeList.size()) {
            memMax = memMax * 2;
            memPool = new byte[memMax];
            System.out.println("Memory pool expanded to be" + memMax
                + "bytes.");
        }
        if (freeList.get(start).size() != 0) {
            
            freeList.get(start).remove(0);
        }

    }


    /**
     * returns the length
     * 
     * @param hand
     *            handle
     * @return length
     */
    public int length(Handle hand) {
        return hand.getLength();
    }


    public void remove(Handle hand) {

    }


    public int get(byte[] space, Handle hand, int size) {

    }


    /**
     * dump the blocks
     */
    public void dump() {
        for (int i = 0; i < freeList.size(); i++) {
            if (freeList.get(i).size() != 0) {
                int x = (int)Math.pow(2, i);
                System.out.print(x + ": ");
                for (int j = 0; j < freeList.get(i).size(); j++) {
                    System.out.print(freeList.get(i).get(j).getPosition()
                        + " ");
                }
                System.out.print("\n");
            }
        }
    }


    /**
     * helper to determine int version of log number
     * 
     * @param x
     *            input
     * @return log base 2 rounded up
     */
    private int log(int x) {
        int count = 0;
        for (int i = 1; i >= x; i = i * 2) {
            count++;
        }
        return count;
    }
    
    private Block split(int need, int have, Block b) {
        Block back = new Block(have/2);
        Block front = new Block(have/2);
        
        int pos = log(have/2);
        freeList.get(pos).add(back);
        return split(need, have/2, front);
    }
}
