package core.basesyntax.service.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import org.junit.Test;

public class BalanceHandlerTest {
    private static final int EXPECTED_FRUIT_QUANTITY = 200;
    private OperationHandler operationHandler = new BalanceHandler();
    private FruitTransaction fruitTransaction = new FruitTransaction();

    @Test
    public void balanceOperationHandler_CorrectData_Ok() {
        fruitTransaction.setOperation(Operation.BALANCE);
        fruitTransaction.setFruit("banana");
        fruitTransaction.setQuantity(200);
        operationHandler.apply(fruitTransaction);
        int actual = Storage.getStorage().get("banana");
        int expected = EXPECTED_FRUIT_QUANTITY;
        assertEquals(expected, actual);
    }
}
