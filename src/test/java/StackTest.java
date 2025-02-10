import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;

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
    public void pushTest() throws StackOverflowError, Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals(1, stack.size());
    }

    @Test
    public void pushWhenFullTest() throws StackOverflowError, Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        stack.push("cat");
        stack.push("cat");
        stack.push("cat");
        stack.push("cat");
        assertThrows(StackOverflowError.class, () -> stack.push("cat"));
    }

    @Test
    public void peekTest() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals("cat", stack.peek());
    }

    @Test
    public void peekWhenEmptyTest() {
        Stack<String> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void sizeTest() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        assertEquals(1, stack.size());
        stack.push("cat");
        assertEquals(2, stack.size());
    }

    @Test
    public void popTest() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        stack.push("cat");
        var returned = stack.pop();
        assertEquals("cat", returned);
        assertEquals(1, stack.size());
    }

    @Test
    public void popWhenEmptyTest() {
        Stack<String> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

}