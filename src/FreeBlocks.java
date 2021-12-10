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
        int position = 0;
        if (space.length > memMax) {
            int drac = 0;
            while (space.length > memMax) {
                memMax = memMax * 2;
                freeList.add(new LinkedList<Block>());
                freeList.getLast().add(new Block(memMax / 2));
            }
            byte[] memCopy = new byte[memMax];
            System.arraycopy(memPool, 0, memCopy, 0, memPool.length);
            memPool = memCopy;
            System.out.println("No free blocks are available.");
            System.out.println("Memory pool expanded to be " + memMax
                + " bytes.");
        }
        // find open space
        // System.out.println(space.length);
        int start = this.log(space.length);
        int start2 = start;
        if (freeList.get(start).size() != 0) {
            System.arraycopy(space, 0, memPool, freeList.get(start).get(0)
                .getPosition(), space.length);
            position = freeList.get(start).get(0).getPosition();
            freeList.get(start).remove(0);
        }
        else
            while (start <= freeList.size() && freeList.get(start)
                .size() == 0) {
                start++;
            }
        if (start > freeList.size()) {
            memMax = memMax * 2;
            freeList.add(new LinkedList<Block>());
            freeList.getLast().add(new Block(memMax / 2));

            byte[] memCopy = new byte[memMax];
            System.arraycopy(memPool, 0, memCopy, 0, memPool.length);
            memPool = memCopy;
            System.out.println("No free blocks are available.");
            System.out.println("Memory pool expanded to be " + memMax
                + " bytes.");
        }
        if (freeList.get(start).size() != 0) {
            this.split(space.length, (int)Math.pow(2, start), freeList.get(
                start).get(0));
            freeList.get(start).remove(0);
            System.arraycopy(space, 0, memPool, freeList.get(start2).get(0)
                .getPosition(), space.length);
            position = freeList.get(start2).get(0).getPosition();
            freeList.get(start2).remove(0);
        }

        return new Handle(position, size);
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

        int pos = hand.getPos();
        int size = hand.getLength();
        int power = this.log(size);
        int blkSize = (int)Math.pow(2, power);

        freeList.get(power).add(new Block(pos));
        this.merge(power, pos);
    }


    /**
     * dump the blocks
     */
    public void dump() {
        Boolean flag = true;
        for (int i = 0; i < freeList.size(); i++) {
            if (freeList.get(i).size() != 0) {
                int x = (int)Math.pow(2, i);
                System.out.print(x + ": ");
                for (int j = 0; j < freeList.get(i).size(); j++) {
                    System.out.print(freeList.get(i).get(j).getPosition()
                        + " ");
                }
                System.out.print("\n");
                flag = false;
            }
        }
        if (flag) {
            System.out.println("No free blocks are available.");
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
        for (int i = 1; i < x; i = i * 2) {
            count++;
        }
        return count;
    }


    /**
     * helper for inserting things
     * 
     * @param need
     *            size
     * @param have
     *            size
     * @param b
     *            current block
     */
    private void split(int need, int have, Block b) {
        if (need == have) {
            int bic = log(need);
            // freeList.get(bic).add(new Block(b.getPosition() + (have / 2)));
            freeList.get(bic).addFirst(new Block(b.getPosition()));
        }
        else {
            Block back = new Block(b.getPosition() + (have / 2));
            Block front = new Block(b.getPosition());

            int pos = log(have / 2);
            freeList.get(pos).add(back);
            split(need, have / 2, front);

        }
    }


    private void merge(int power, int position) {

        int spec = position ^ (1 << power);

        for (int i = 0; i < freeList.get(power).size(); i++) {
            if (freeList.get(power).get(i).getPosition() == spec) {
                int min = Math.min(position, freeList.get(power).get(i)
                    .getPosition());
                freeList.get(power + 1).add(new Block(min));
                freeList.get(power).remove(i);
                for (int j = 0; j < freeList.get(power).size(); j++) {
                    if (freeList.get(power).get(j).getPosition() == position) {
                        freeList.get(power).remove(j);
                    }
                }
                this.merge(power + 1, min);
                break;
            }
        }

    }
}
