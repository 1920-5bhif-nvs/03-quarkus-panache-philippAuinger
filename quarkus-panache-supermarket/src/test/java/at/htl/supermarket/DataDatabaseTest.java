package at.htl.supermarket;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
public class DataDatabaseTest {
    Source source = new Source("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "passme");

    @Test
    public void test01PersonData(){
        Table person = new Table(source, "person");
        assertThat(person).hasNumberOfRows(6);

        assertThat(person).column("firstname")
                .hasValues(
                        "Susanna",
                        "Bernd",
                        "Philipp",
                        "Nenad",
                        "Susanna",
                        "Stephan");
    }
}
