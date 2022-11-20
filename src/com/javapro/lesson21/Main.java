package com.javapro.lesson21;

import static com.javapro.lesson21.model.ProductType.BOOK;
import static com.javapro.lesson21.model.ProductType.ERASER;
import static com.javapro.lesson21.model.ProductType.NOTEBOOK;
import static com.javapro.lesson21.model.ProductType.PEN;
import static com.javapro.lesson21.model.ProductType.PENCIL;

import com.javapro.lesson21.model.NoFindElementException;
import com.javapro.lesson21.model.Product;
import java.time.LocalDate;
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
    productList.get(1).setCreateDate(LocalDate.of(2001, 1, 21));
    productList.get(2).setCreateDate(LocalDate.of(2002, 2, 21));
    productList.get(3).setCreateDate(LocalDate.of(2003, 3, 21));
    productList.get(4).setCreateDate(LocalDate.of(2004, 4, 21));
    productList.get(5).setCreateDate(LocalDate.of(2021, 5, 21));
    productList.get(6).setCreateDate(LocalDate.of(2010, 6, 21));
    productList.get(7).setCreateDate(LocalDate.of(2016, 7, 21));
    productList.get(8).setCreateDate(LocalDate.of(2015, 8, 21));
    productList.get(9).setCreateDate(LocalDate.of(2012, 9, 21));
    productList.get(10).setCreateDate(LocalDate.of(2009, 10, 21));
    productList.get(11).setCreateDate(LocalDate.of(2006, 11, 21));
    productList.get(12).setCreateDate(LocalDate.of(2007, 11, 21));

    try {
      System.out.println(product.getListWithPrice(250, BOOK, productList));
      System.out.println(product.getListWithDiscount(10, BOOK, productList));
      System.out.println(product.getCheapest(BOOK, productList));
      System.out.println(product.getLastTheeAdded(productList));
      System.out.println(product.getAddedInThisYear(2022, 75, BOOK, productList));
      System.out.println(product.getGroupingByType(productList));
    } catch (NoFindElementException | IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

  }
}