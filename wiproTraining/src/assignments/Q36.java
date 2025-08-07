package assignments;

public class Q36 {
    private boolean isReleased = false;
    private boolean isFilled = false;

    public void fillTank() {
        isFilled = true;
        System.out.println("Tank is filled.");
    }

    public void emptyTank() {
        if (isFilled) {
            isFilled = false;
            System.out.println("Tank is emptied.");
        } else {
            System.out.println("Tank is already empty.");
        }
    }

    public void releaseTank() {
        isReleased = true;
        System.out.println("Tank is released properly.");
    }

    @Override
    protected void finalize() throws Throwable {
        if (!isReleased) {
            System.out.println("Tank was not released before garbage collection!");
        } else {
            System.out.println("Tank was released properly before cleanup.");
        }
        super.finalize();
    }

    public static void main(String[] args) {
        Q36 t1 = new Q36();
        t1.fillTank();
        t1.emptyTank();
        t1.releaseTank();
        t1 = null;

        Q36 t2 = new Q36();
        t2.fillTank();
        t2 = null;

        System.gc();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//Tank is filled.
//Tank is emptied.
//Tank is released properly.
//Tank is filled.
//Tank was not released before garbage collection!
//Tank was released properly before cleanup.
