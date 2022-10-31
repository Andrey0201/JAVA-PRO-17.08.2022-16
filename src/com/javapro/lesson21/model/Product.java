package com.javapro.lesson21.model;


import java.time.LocalDate;
import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  public Product(ProductType type, double price,double discount , int id) {
    this.type = type;
    this.price = price;
    this.discount = discount;
    this.id = id;
  }


  public Product() {
  }


  public List<Product> getListWithPrice(double price, ProductType type,List<Product>productList) {
    return productList.stream()
        .filter(product -> product.getPrice() > price & product.getType().equals(type))
        .collect(Collectors.toList());


  }

  public List<Product> addListWithDiscount(double discount, ProductType type,List<Product>productList) {
    return productList.stream()
        .filter(product -> product.getType().equals(type) && product.getDiscount() != 0)
        .peek(product -> product.setPrice(discount))
        .collect(Collectors.toList());

  }

  public Product minValue(ProductType type,List<Product>productList) {
    return productList.stream()
        .filter(product -> product.getType().equals(type) && product.getDiscount() != 0)
        .min(Comparator.comparing(Product::getPrice))
        .orElseThrow(() -> new NoFindElementException("Продукт " + type + " Не найден"));

  }

  public List<Product> addListLastThee(List<Product>productList) {
    return productList.stream().skip(productList.size()-3)
        .collect(Collectors.toList());


  }
  public Double addListInThisYear(Year year,double maxPrice,ProductType type,List<Product>productList) {

    return productList.stream()
        .filter(product -> product.getType().equals(type) && product.getPrice() <= maxPrice
            && product.getLocalDateTime().getYear() == year.getValue())
        .mapToDouble(Product::getPrice).sum();

  }
public Map<ProductType,List<Product>> addMap(List<Product>productList){
  return productList.stream().collect(Collectors.groupingBy(Product::getType));

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

  public void setPrice(double discount) {
    this.price = getPrice() - getPrice() / discount;
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