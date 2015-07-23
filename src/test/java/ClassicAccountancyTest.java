import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicAccountancyTest {


  @Test
  public void should_work() {
    // Given
    ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

    // When
    double totalPrice = classicAccountancy.totalInvoice();

    // Then
    assertThat((int) totalPrice).isEqualTo(26);


  }

}