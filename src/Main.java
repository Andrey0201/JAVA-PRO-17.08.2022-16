import static com.javapro.lesson21.ProductType.BOOK;
import static com.javapro.lesson21.ProductType.ERASER;
import static com.javapro.lesson21.ProductType.NOTEBOOK;
import static com.javapro.lesson21.ProductType.PEN;
import static com.javapro.lesson21.ProductType.PENCIL;

import com.javapro.lesson21.NoFindElementException;
import com.javapro.lesson21.Product;



public class Main {

  public static void main(String[] args) {

    Product[] products = {new Product(BOOK, 350), new Product(NOTEBOOK, 300),
        new Product(PENCIL, 200), new Product(PEN, 120), new Product(BOOK, 280),
        new Product(PENCIL, 200), new Product(PEN, 120), new Product(PEN, 260),
        new Product(BOOK, 100),
        new Product(ERASER, 150)};

    Product product = new Product();
    product.addAllProductToList(products);
    System.out.println(product.addListWithPrice(250, BOOK));
    System.out.println(product.addListWithDiscount(10,BOOK));
    try {
      System.out.println(product.minValue(BOOK));
    }catch (NoFindElementException e){
      System.out.println(e.getMessage());
    }
    System.out.println(product.getProductList());
  }
}