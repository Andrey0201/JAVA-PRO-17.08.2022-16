package com.javapro.lesson21;

import static com.javapro.lesson21.model.ProductType.BOOK;
import static com.javapro.lesson21.model.ProductType.ERASER;
import static com.javapro.lesson21.model.ProductType.NOTEBOOK;
import static com.javapro.lesson21.model.ProductType.PEN;
import static com.javapro.lesson21.model.ProductType.PENCIL;

import com.javapro.lesson21.model.NoFindElementException;
import com.javapro.lesson21.model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrii Andriutsa on 31.10.2022
 */
public class Main {

  public static void main(String[] args) {
    List<Product> productList = new ArrayList<>();
    productList.add(new Product(BOOK, 0));
    productList.add(new Product(NOTEBOOK, 300));
    productList.add(new Product(PENCIL, 200));
    productList.add(new Product(PEN, 120));
    productList.add(new Product(BOOK, 280));
    productList.add(new Product(PENCIL, 200));
    productList.add(new Product(PEN, 140));
    productList.add(new Product(PEN, 260));
    productList.add(new Product(BOOK, 100));
    productList.add(new Product(ERASER, 150));
    productList.add(new Product(BOOK, 40, true));
    productList.add(new Product(BOOK, 60, true));
    productList.add(new Product(BOOK, 70, true, 111));

    Product product = new Product();

    System.out.println(product.getListWithPrice(250, BOOK, productList));
    System.out.println(product.getListWithDiscount(10, BOOK, productList));
    try {
      System.out.println(product.getCheapest(BOOK, productList));
    } catch (
        NoFindElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(product.getLastTheeAdded(productList));
    System.out.println(product.getAddedInThisYear(2022, 75, BOOK, productList));
    System.out.println(product.getGroupingByType(productList));
  }
}