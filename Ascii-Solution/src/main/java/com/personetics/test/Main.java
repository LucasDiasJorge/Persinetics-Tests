import com.personetics.test.ChainValidator;
import com.personetics.test.NodeInterface;
import com.personetics.test.NumericNodeImpl;
import com.personetics.test.WordNodeImpl;

import java.util.List;

public void main() {
    // Test cases
    List<NodeInterface> validChain1 = List.of(
            new NumericNodeImpl(36), new NumericNodeImpl(6), new NumericNodeImpl(24),
            new NumericNodeImpl(4), new NumericNodeImpl(47), new NumericNodeImpl(7),
            new NumericNodeImpl(2), new NumericNodeImpl(3), new NumericNodeImpl(27)
    );

    List<NodeInterface> validChain2 = List.of(
            new WordNodeImpl("p"), new WordNodeImpl("aba"), new WordNodeImpl("a"),
            new WordNodeImpl("b"), new WordNodeImpl("perso"), new WordNodeImpl("o"),
            new WordNodeImpl("r"), new WordNodeImpl("e"), new WordNodeImpl("s")
    );

    List<NodeInterface> invalidChain = List.of(
            new NumericNodeImpl(35), new NumericNodeImpl(5), new NumericNodeImpl(65),
            new NumericNodeImpl(6), new NumericNodeImpl(24), new NumericNodeImpl(4)
    );

    List<NodeInterface> validChain3 = List.of(
            new NumericNodeImpl(2), new NumericNodeImpl(5), new NumericNodeImpl(65),
            new NumericNodeImpl(6), new NumericNodeImpl(24), new NumericNodeImpl(4)
    );

    ChainValidator validator = new ChainValidator();

    System.out.println(validator.validate(validChain1)); // should print true
    System.out.println(validator.validate(validChain2)); // should print true
    System.out.println(validator.validate(invalidChain)); // should print false
    System.out.println(validator.validate(validChain3)); // should print true

}