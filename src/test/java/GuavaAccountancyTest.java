import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class GuavaAccountancyTest {

    @Ignore("Not implemented yet")
    @Test
    public void should_return_total_invoice() {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        double totalPrice = guavaAccountacy.totalInvoice();

        // Then
        assertThat(totalPrice).isEqualTo(26.54);
    }


    @Ignore("Not implemented yet")
    @Test
    public void should_return_total_for_a_category_when_viandes()  {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        double totalPriceForMeat = guavaAccountacy.totalFor("Viandes");

        // Then
        assertThat(totalPriceForMeat).isEqualTo(19.89);
    }

    @Ignore("Not implemented yet")
    @Test
    public void should_return_total_for_a_category_when_conserves()  {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        double totalPriceForMeat = guavaAccountacy.totalFor("Conserves");

        // Then
        assertThat(totalPriceForMeat).isEqualTo(6.65);
    }

    @Ignore("Not implemented yet")
    @Test
    public void should_return_total_vat()  {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        double totalVat = guavaAccountacy.totalVat();

        // Then
        assertThat(totalVat).isEqualTo(2.8);
    }

    @Ignore("Not implemented yet")
    @Test
    public void should_return_total_cut()  {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        double totalVat = guavaAccountacy.totalCut();

        // Then
        assertThat(totalVat).isEqualTo(0.74);
    }

    @Ignore("Not implemented yet")
    @Test
    public void should_return_all_article_names()  {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        String allArticleNames = guavaAccountacy.allArticleNames();

        // Then
        assertThat(allArticleNames).isEqualTo("Boeuf,\nPorc,\nSauce Tomate,\nPetits Pois,\nThon");
    }

}
