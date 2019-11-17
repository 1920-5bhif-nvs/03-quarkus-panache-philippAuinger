package at.htl.supermarket.business;

import at.htl.supermarket.model.*;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class InitBean {

    @Transactional
    void init(@Observes StartupEvent ev)
    {
        System.err.println("Init started!");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");


        Storage storage = new Storage();
        storage.persist();
        Storage store = new Storage();
        store.persist();

        Product innocent_greensmoothie = new Product("Green Smoothie", 2.26, LocalDate.parse("19.12.2018",formatter), "Innocent",10,store);
        innocent_greensmoothie.persist();

        Product chiquita_bananen  = new Product("Original Chiquita Bananen", 1.00, LocalDate.parse("10.12.2018",formatter), "Chiquita",20,store);
        chiquita_bananen.persist();

        Product green_apfel = new Product("Green Apfel", 0.98, LocalDate.parse("05.12.2018",formatter),"Green",150,storage);
        green_apfel.persist();

        Product clever_wasser = new Product("Clever Wasser", 1.30, LocalDate.parse("05.05.2019",formatter),"Clever",7,storage);
        clever_wasser.persist();

        Product SBudget_Kaese = new Product("SBudget Kaese", 5.40, LocalDate.parse("16.08.2020",formatter),"SBudget",222,storage);
        SBudget_Kaese.persist();
/*
    Person philipp = new Person("Philipp","Auinger",LocalDate.parse("13.12.2000",formatter),"+4306804423123","philipp-email.com");
    em.persist(philipp);
    Person nenad = new Person("Nenad","Tripic",LocalDate.parse("06.11.2000",formatter),"+43 4345222122","nenad-saveemail.com");
    em.persist(nenad);
    Person thomas = new Person("Thomas","Antensteiner",LocalDate.parse("05.06.2001",formatter),"+43 4323422211","thomas.antensteiner@hotmail.com");
    em.persist(thomas);
    Person stephan = new Person("Stephan","Do",LocalDate.parse("28.11.2000",formatter),"+4312344444","stephan-do@bestmail.com");
    em.persist(stephan);

    Person cashier_1 = new Person("Susanna", "Geld", LocalDate.parse("05.07.1999",formatter),"+66 43242342","");
    em.persist(cashier_1);
    Person cashier_2 = new Person("Bernd", "Moneten", LocalDate.parse("17.04.1980",formatter),"+1244444342","bernd.newemail.com");
    em.persist(cashier_2);
*/
        Customer c_philipp = new Customer("Philipp","Auinger",LocalDate.parse("13.12.2000",formatter),"+4306804423123","philipp-email.com",
                LocalDate.parse("10.01.2014",formatter),940,45352,"Friend");
        c_philipp.persist();
        Customer c_nenad = new Customer("Nenad","Tripic",LocalDate.parse("06.11.2000",formatter),"+43 4345222122","nenad-saveemail.com",
                LocalDate.parse("14.10.2015",formatter),264,12344,"Normal");
        c_nenad.persist();
        Customer c_thomas = new Customer("Susanna", "Geld", LocalDate.parse("05.07.1999",formatter),"+66 43242342","",
                LocalDate.parse("03.04.2017",formatter),102,12219,"Normal");
        c_thomas.persist();
        Customer c_stephan = new Customer("Stephan","Do", LocalDate.parse("28.11.2000",formatter),"+4312344444","stephan-do@bestmail.com",
                LocalDate.parse("09.06.2011",formatter),9,10103,"Newbie");
        c_stephan.persist();

        Cashier ca_cashier_1 = new Cashier("Susanna", "Geld", LocalDate.parse("05.07.1999",formatter),"+66 43242342","",
                LocalDate.parse("01.01.2000",formatter),2300.20);
        ca_cashier_1.persist();
        Cashier ca_cashier_2 = new Cashier("Bernd", "Moneten", LocalDate.parse("17.04.1980",formatter),"+1244444342","bernd.newemail.com",
                LocalDate.parse("04.06.2014",formatter),1000.99);
        ca_cashier_2.persist();

        Activity a = new Activity(LocalDateTime.parse("02.12.2018 13:20:01",time_formatter),2,green_apfel,ca_cashier_1,c_philipp);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 13:20:06",time_formatter),2,clever_wasser,ca_cashier_1,c_philipp);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 14:01:30",time_formatter),1,green_apfel,ca_cashier_2,c_nenad);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 11:46:10",time_formatter),1,SBudget_Kaese,ca_cashier_1,c_thomas);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 13:46:14",time_formatter),1,chiquita_bananen,ca_cashier_1,c_thomas);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 20:10:30",time_formatter),2,chiquita_bananen,ca_cashier_2,c_nenad);
        a.persist();
        a = new Activity(LocalDateTime.parse("02.02.2018 21:40:55",time_formatter),1,chiquita_bananen,ca_cashier_1,c_stephan);
        a.persist();


        PanacheQuery<Customer> query = Customer.find("SELECT c FROM Customer c JOIN Person p on c.id = p.id");
        query.list().forEach(c -> System.err.print(c.toString()));
    }
}
