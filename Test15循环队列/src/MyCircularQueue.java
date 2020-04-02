public class MyCircularQueue {
    private int[] array;
    private int length;//最长个数
    private int head;//队头
    private int tail;//队尾
    private int size;//队列中元素个数

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
        public MyCircularQueue(int k) {
            this.array = new int[k];
            this.head = 0;
            this.tail = 0;
            this.size = 0;
            this.length = k;
        }
        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue ( int value){
            if (size == length) {
                return false;
            }
            if (tail == length) {
                tail = 0;
                array[tail] = value;
                tail++;
                size++;
            }
            array[tail] = value;
            tail++;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue () {
            if (size == 0) {
                return false;
            }
            head++;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front () {
            if (size == 0) {
                return -1;
            }
            int ret = array[head];
            return ret;

        }

        /** Get the last item from the queue. */
        public int Rear () {
            if (size == 0) {
                return -1;
            }
            int ret = array[tail - 1];
            return ret;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty () {
            if(size == 0){
                return true;
            }
            return false;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull () {
            if(size == length - 1){
                return true;
            }
            return false;
        }
    }