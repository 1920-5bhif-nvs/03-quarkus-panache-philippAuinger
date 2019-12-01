package at.htl.supermarket;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
public class StructureDatabaseTest {


    Source source = new Source("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "passme");

    @Test
    public void test01TablePerson(){
        Table table = new Table(source, "person");

        assertThat(table).column("id").isNumber(true);
        assertThat(table).column("dtype").isText(true);
        assertThat(table).column("email").isText(true);
        assertThat(table).column("firstname").isText(true);
        assertThat(table).column("lastname").isText(true);
        assertThat(table).column("mobilephone").isText(true);
        assertThat(table).column("birthdate").isDate(true);
    }

    @Test
    public void test02TableCustomer(){
        Table table = new Table(source, "customer");

        assertThat(table).column("id").isNumber(true);
        assertThat(table).column("accession_date").isDate(true);
        assertThat(table).column("card_number").isNumber(true);
        assertThat(table).column("loyalty_points").isNumber(true);
        assertThat(table).column("rank").isText(true);
    }

    @Test
    public void test03TableCashier(){
        Table table = new Table(source, "cashier");

        assertThat(table).column("id").isNumber(true);
        assertThat(table).column("salary").isNumber(true);
        assertThat(table).column("begin_date").isDate(true);
    }
}
