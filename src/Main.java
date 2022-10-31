import static com.javapro.lesson21.ProductType.BOOK;
import static com.javapro.lesson21.ProductType.ERASER;
import static com.javapro.lesson21.ProductType.NOTEBOOK;
import static com.javapro.lesson21.ProductType.PEN;
import static com.javapro.lesson21.ProductType.PENCIL;

import com.javapro.lesson21.NoFindElementException;
import com.javapro.lesson21.Product;
import java.time.Year;
import javax.xml.crypto.Data;


public class Main {

  public static void main(String[] args) {
    ;
    Product product = new Product();

    product.addAllProductToList(new Product(BOOK, 350));
    product.addAllProductToList(new Product(NOTEBOOK, 300));
    product.addAllProductToList(new Product(PENCIL, 200));
    product.addAllProductToList(new Product(PEN, 120));
    product.addAllProductToList(new Product(BOOK, 280));
    product.addAllProductToList(new Product(PENCIL, 200));
    product.addAllProductToList(new Product(PEN, 140));
    product.addAllProductToList(new Product(PEN, 260));
    product.addAllProductToList(new Product(BOOK, 100));
    product.addAllProductToList(new Product(ERASER, 150));
    product.addAllProductToList(new Product(BOOK, 40, 10));
    product.addAllProductToList(new Product(BOOK, 60, 15));
    product.addAllProductToList(new Product(BOOK,70,10,111));



    System.out.println(product.addListWithPrice(250, BOOK));
    System.out.println(product.addListWithDiscount(10, BOOK));
    try {
      System.out.println(product.minValue(PENCIL));
    } catch (
        NoFindElementException e) {
      System.out.println(e.getMessage());
    }
    System.out.println(product.getProductList());
    System.out.println(product.addListLastThee());
    System.out.println(product.addListInThisYear(Year.now(),75,BOOK));
    System.out.println(product.addMap());
  }
}