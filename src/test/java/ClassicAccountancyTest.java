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


    @Test
    public void should_return_total_for_a_category_when_viandes()  {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        double totalPriceForMeat = classicAccountancy.totalFor("Viandes");

        // Then
        assertThat(totalPriceForMeat).isEqualTo(19.89);
    }

    @Test
    public void should_return_total_for_a_category_when_conserves()  {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        double totalPriceForMeat = classicAccountancy.totalFor("Conserves");

        // Then
        assertThat(totalPriceForMeat).isEqualTo(6.65);
    }

    @Test
    public void should_return_total_vat()  {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        double totalVat = classicAccountancy.totalVat();

        // Then
        assertThat(totalVat).isEqualTo(2.8);
    }

    @Test
    public void should_return_total_cut()  {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        double totalVat = classicAccountancy.totalCut();

        // Then
        assertThat(totalVat).isEqualTo(0.74);
    }

    @Test
    public void should_return_all_article_names()  {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        String allArticleNames = classicAccountancy.allArticleNames();

        // Then
        assertThat(allArticleNames).isEqualTo("Boeuf,\nPorc,\nSauce Tomate,\nPetits Pois,\nThon");
    }
}