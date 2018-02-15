package pl.coderstrust.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

  private long id;
  private String visibleId;
  private Company buyer;
  private Company seller;
  private LocalDate issueDate;
  private LocalDate paymentDate;
  List<InvoiceEntry> products = new ArrayList<>();
  private PaymentState paymentState;

  private Invoice() {
  }

  public Invoice(long id, String visibleId, Company buyer, Company seller,
                 LocalDate issueDate, LocalDate paymentDate,
                 List<InvoiceEntry> products, PaymentState paymentState) {
    this.visibleId = visibleId;
    this.buyer = buyer;
    this.seller = seller;
    this.issueDate = issueDate;
    this.paymentDate = paymentDate;
    this.products = products;
    this.paymentState = paymentState;
  }

  @Override
  public String toString() {
    return "Invoice{"
        + "id=" + id
        + ", visibleId='" + visibleId + '\''
        + ", buyer=" + buyer
        + ", seller=" + seller
        + ", issueDate=" + issueDate
        + ", paymentDate=" + paymentDate
        + ", products=" + products
        + ", paymentState=" + paymentState + '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVisibleId() {
    return visibleId;
  }

  public void setVisibleId(String visibleId) {
    this.visibleId = visibleId;
  }

  public Company getBuyer() {
    return buyer;
  }

  public void setBuyer(Company buyer) {
    this.buyer = buyer;
  }

  public Company getSeller() {
    return seller;
  }

  public void setSeller(Company seller) {
    this.seller = seller;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(LocalDate paymentDate) {
    this.paymentDate = paymentDate;
  }

  public List<InvoiceEntry> getProducts() {
    return products;
  }

  public void setProducts(List<InvoiceEntry> products) {
    this.products = products;
  }

  public PaymentState getPaymentState() {
    return paymentState;
  }

  public void setPaymentState(PaymentState paymentState) {
    this.paymentState = paymentState;
  }

  public static class Builder {
    private long id;
    private String visibleId;
    private Company buyer;
    private Company seller;
    private LocalDate issueDate;
    private LocalDate paymentDate;
    private List<InvoiceEntry> products;
    private PaymentState paymentState;

    public Builder(long id, String buyerName, String sellerName) {
      this.id = id;
      this.buyer = new Company.Builder(buyerName).createCompany();
      this.seller = new Company.Builder(sellerName).createCompany();
    }

    public Builder setVisibleId(String visibleId) {
      this.visibleId = visibleId;
      return this;
    }

    public Builder setBuyer(Company company) {
      this.buyer = company;
      return this;
    }

    public Builder setSeller(Company company) {
      this.buyer = company;
      return this;
    }

    public Builder setIssueDate(LocalDate issueDate) {
      this.issueDate = issueDate;
      return this;
    }

    public Builder setPaymentDate(LocalDate paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public Builder setProducts(List<InvoiceEntry> products) {
      this.products = products;
      return this;
    }

    public Builder setPaymentState(PaymentState paymentState) {
      this.paymentState = paymentState;
      return this;
    }

    public Invoice createInvoice() {
      Invoice invoice = new Invoice();
      invoice.id = this.id;
      invoice.visibleId = this.visibleId;
      invoice.buyer = this.buyer;
      invoice.seller = this.seller;
      invoice.issueDate = this.issueDate;
      invoice.paymentDate = this.paymentDate;
      invoice.products = this.products;
      invoice.paymentState = this.paymentState;

      return invoice;
    }
  }
}
