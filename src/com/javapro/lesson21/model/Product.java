package com.javapro.lesson21.model;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Andrii Andriutsa on 31.10.2022
 */
public class Product {

  ProductType type;
  private double price;
  private double discount;
  private int id;
  private final LocalDate localDate = java.time.LocalDate.now();


  public Product(ProductType type, double price) {
    this.type = type;
    this.price = price;

  }

  public Product(ProductType type, double price, double discount) {
    this.type = type;
    this.price = price;
    this.discount = discount;

  }

  public Product(ProductType type, double price, double discount, int id) {
    this.type = type;
    this.price = price;
    this.discount = discount;
    this.id = id;
  }


  public Product() {
  }

  /**
   * @author Andrii Andriutsa on 31.10.2022
   * Return a list whose category is equivalent ProductType
   * and price is more than the indicated price.
   */
  public List<Product> getListWithPrice(double indicatedPrice, ProductType type,
      List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;
    }
    return productList.stream()
        .filter(
            product -> product.getType() != null && product.getPrice() > indicatedPrice
                && product.getType()
                .equals(type))
        .collect(Collectors.toList());

  }

  /**
   * @author Andrii Andriutsa on 31.10.2022
   * Return a list whose category is equivalent ProductType
   * and with the possibility of applying a discount. And apply the indicated discount.
   */
  public List<Product> addListWithDiscount( ProductType type,
      List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;
    }
    return productList.stream()
        .filter(product -> product.getType() != null && product.getType().equals(type)
            && product.getDiscount() != 0)
        .peek(Product::setPrice)
        .collect(Collectors.toList());

  }

  /**
   * @author Andrii Andriutsa on 31.10.2022
   * Return the cheapest product from the category
   * ProductType
   */
  public Product minValue(ProductType type, List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;
    }
    return productList.stream()
        .filter(product -> product.getType() != null && product.getType().equals(type)
            && product.getDiscount() != 0)
        .min(Comparator.comparing(Product::getPrice))
        .orElseThrow(() -> new NoFindElementException("Продукт " + type + " Не найден"));

  }

  /**
   * @author Andrii Andriutsa on 31.10.2022 Return a list of the three most recently added products
   */
  public List<Product> addListLastThee(List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;
    }
    return productList.stream()
        .skip(productList.size() - 3)
        .collect(Collectors.toList());


  }

  /**
   * @author Andrii Andriutsa on 31.10.2022 Returns the sum of the cost of products that meet the
   * following criteria: - product added during the indicated year - ProductType - the price of the
   * product does not exceed the specified price
   */
  public Double addListInThisYear(int year, double maxPrice, ProductType type,
      List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;

    }
    return productList.stream()
        .filter(product -> product.getType() != null && product.getType().equals(type)
            && product.getPrice() <= maxPrice
            && product.getLocalDateTime().getYear() == year)
        .mapToDouble(Product::getPrice).sum();

  }

  /**
   * @author Andrii Andriutsa on 31.10.2022 Returns map (grouping objects by product type)
   */
  public Map<ProductType, List<Product>> addMap(List<Product> productList) {
    if (productList == null) {
      System.out.println("List can't be null");
      return null;
    }
    return productList.stream()
        .filter(product -> product.getType() != null)
        .collect(Collectors.groupingBy(Product::getType));

  }

  public ProductType getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }

  public LocalDate getLocalDateTime() {
    return localDate;
  }

  public double getDiscount() {
    return discount;
  }

  public void setPrice() {
    this.price = getPrice() - getPrice() / getDiscount();
  }

  @Override
  public String toString() {
    return "Product{" +
        "type=" + type +
        ", price=" + price +
        ", discount=" + discount +
        ", id=" + id +
        ", localDate=" + localDate +
        "'}'\n";
  }
}
