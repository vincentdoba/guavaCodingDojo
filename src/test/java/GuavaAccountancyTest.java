import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void should_return_price_by_category() {
        // Given
        ClassicAccountancy classicAccountancy = new ClassicAccountancy(new Shopping());

        // When
        Map<String,Double> priceByCategory = classicAccountancy.priceByCategory();

        // Then
        assertThat(priceByCategory).hasSize(2);
        assertThat(priceByCategory.keySet()).containsExactly("Viandes", "Conserves");
        assertThat(priceByCategory.values()).containsExactly(19.89, 6.65);
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

    @Ignore("Not implemented yet")
    @Test
    public void should_return_the_list_of_the_top_three_ingredients_in_the_shopping_list() {
        // Given
        GuavaAccountacy guavaAccountacy = new GuavaAccountacy(new Shopping());

        // When
        List<String> ingredients = guavaAccountacy.topIngredientList(3);

        // Then
        assertThat(ingredients).hasSize(3);
        assertThat(ingredients).containsOnly("Conservateur","Eau", "Sel");
    }

}
