import java.util.EmptyStackException;

public class Stack<T> {
    Object[] backingArr;
    private int size = 0;
    private final int max;
    private int top = -1;

    private void decreaseFields() {
        if (top > -1) {
            top--;
        }

        if (size > 0) {
            size--;
        }
    }

    public Stack(int size) {
        this.max = size;
        backingArr = new Object[size];
    }

    public Stack() {
        this(5);
    }

    public void push(final T object) throws Exception {
        if (top + 1 < max) {
            backingArr[top + 1] = object;
            top++;
            size++;
        } else {
            throw new StackOverflowError();
        }
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (top > -1 && backingArr[top] != null) {
            return (T) backingArr[top];
        }
        throw new EmptyStackException();

    }

    public T pop() {
        if (top > -1 && backingArr[top] != null) {
            var temp = backingArr[top];
            backingArr[top] = null;
            this.decreaseFields();
            return (T) temp;
        }
        throw new EmptyStackException();
    }

    @Override
    public String toString() {
        StringBuilder wordObjs = new StringBuilder();
        for (var obj : backingArr) {
            wordObjs.append(obj);
        }
        return wordObjs.toString();
    }
}
