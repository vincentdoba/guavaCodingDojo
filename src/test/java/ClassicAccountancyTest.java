import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicAccountancyTest {


    @Test
    public void should_return_total_invoice() {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        double totalPrice = classicAccountancy.totalInvoice();

        // Then
        assertThat(totalPrice).isEqualTo(26.54);
    }


}