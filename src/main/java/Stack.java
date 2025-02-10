public class Stack<T> {
    Object[] backingArr;
    private int size = 0;
    private int max;
    private int top = 0;
    private int insertAt = 0;

    public Stack(int size) {
        this.max = size;
        backingArr = new Object[size];
    }

    public Stack() {
        this(5);
    }

    public void push(final T object) {
        backingArr[insertAt] = object;
        top = insertAt;
        insertAt++;
        size++;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        return (T) backingArr[top];
    }

    public T pop() {
        if (backingArr[top]!=null ) {
            var temp = backingArr[top];
            backingArr[top] = null;
            top--;
            insertAt--;
            size--;
            return (T) temp;
        }
        return null;
    }
}
