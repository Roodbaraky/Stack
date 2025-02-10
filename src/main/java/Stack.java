import java.util.EmptyStackException;

public class Stack<T> {
    Object[] backingArr;
    private int size = 0;
    private final int max;
    private int top = 0;
    private int insertAt = 0;

    private void decreaseFields() {
        if (top > 0) {
            top--;
        }

        if (size > 0) {
            size--;
            insertAt--;
        }
    }

    public Stack(int size) {
        this.max = size;
        backingArr = (T[]) new Object[size];
    }

    public Stack() {
        this(5);
    }

    public void push(final T object) throws Exception {
        if (top + 1 < max) {
            backingArr[insertAt] = object;
            top = insertAt;
            insertAt++;
            size++;
        } else {
            throw new StackOverflowError();
        }
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (backingArr[top] != null) {
            return (T) backingArr[top];
        }
        throw new EmptyStackException();

    }

    public T pop() {
        if (backingArr[top] != null) {
            var temp = backingArr[top];
            backingArr[top] = null;
            this.decreaseFields();
            return (T) temp;
        }
        throw new EmptyStackException();
    }
}
