package at.htl.supermarket.database;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
@Tag("integration")
public class BasicDatabaseTest {
    @Test
    public void firstConnection(){
        Source source = new Source("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "passme");
        Table table = new Table(source, "person");

        assertThat(table).column("firstname")
                .value().isEqualTo("Philipp");
    }
}
