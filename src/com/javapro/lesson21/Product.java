package com.javapro.lesson21;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Product {

  ProductType type;
  private double price;
  private  List<Product> productList = new ArrayList<>();


  public List<Product> getProductList() {
    return productList;
  }

  public Product(ProductType type, double price) {
    this.type = type;
    this.price = price;

  }

  public Product() {
  }

  public void addAllProductToList(Product[] products) {
    Collections.addAll(productList, products);
  }

  public List<Product> addListWithPrice(double price, ProductType type) {
    return productList.stream()
        .filter(product -> product.getPrice() > price & product.getType().equals(type)).collect(
            Collectors.toList());


  }

  public List<Product> addListWithDiscount(double discount, ProductType type) {
    return productList.stream()
        .filter(product -> product.getType().equals(type))
        .peek(product -> product.setPrice(product.getPrice() - product.getPrice() / discount)).collect(
            Collectors.toList());



  }

  public Product minValue( ProductType type) {
    return productList.stream()
        .filter(product -> product.getType().equals(type))
        .min(Comparator.comparing(Product::getPrice))
        .orElseThrow(()->new NoFindElementException("Продукт "+type+" Не найден"));

  }


  public ProductType getType() {
    return type;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "type=" + type +
        ", price=" + price +
        '}';
  }
}
