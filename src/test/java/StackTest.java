import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StackTest {
    //    public static void main(String[] args) {
    //        Stack<String> stack = new Stack<>();
    //        stack.push("one");
    //        stack.push("two");
    //        stack.push("three");
    //
    //        System.out.println("Top element is: " + stack.peek());
    //        System.out.println("Stack size is: " + stack.size());
    //
    //        System.out.println("Popped element is: " + stack.pop());
    //        System.out.println("Stack size after pop is: " + stack.size());
    //    }
    @Test
    public void pushTest() {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals(1,stack.size());

    }

    @Test
    public void peekTest() {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals("cat", stack.peek());
    }

    @Test
    public void sizeTest() {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals(1, stack.size());
        stack.push("cat");
        assertEquals(2, stack.size());
    }

    @Test
    public void popTest() {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        var returned = stack.pop();
        assertEquals("cat", returned);
        assertEquals(0,stack.size());
    }

}