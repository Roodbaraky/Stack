import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StackTest {
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

    @Test
    public void toStringTest() throws Exception {
        Stack<String> stack = new Stack<>();
        stack.push("cat");
        stack.push("cat");
        assertEquals("cat, cat",stack.toString());

    }

    @Test
    public void multipleTypesTest() throws Exception{
        Stack<Object> stack = new Stack<>();
        stack.push("cat");
        stack.push(2);
        assertEquals("cat, 2", stack.toString());
    }

}