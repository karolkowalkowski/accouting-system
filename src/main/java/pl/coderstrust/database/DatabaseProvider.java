package pl.coderstrust.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pl.coderstrust.database.file.InFileDatabase;
import pl.coderstrust.database.memory.InMemoryDatabase;
import pl.coderstrust.database.multifile.MultiFileDatabase;
import pl.coderstrust.model.Company;
import pl.coderstrust.model.Invoice;


@Configuration
@PropertySource("classpath:application.properties")
public class DatabaseProvider {

  @Value("${pl.coderstrust.database.Database}")

  private String databaseType;

  @Bean
  public Database<Invoice> withInvoices() {
    switch (databaseType) {
      case "inFile":
        return new InFileDatabase<>(Invoice.class);
      case "inMultiFile":
        return new MultiFileDatabase<>(Invoice.class);
      default:
        return new InMemoryDatabase<>(Invoice.class);
    }
  }

  @Bean
  public Database<Company> withCompanies() {
    switch (databaseType) {
      case "inFile":
        return new InFileDatabase<>(Company.class);
      case "inMultiFile":
        return new MultiFileDatabase<>(Company.class);
      default:
        return new InMemoryDatabase<>(Company.class);
    }

  }
}
