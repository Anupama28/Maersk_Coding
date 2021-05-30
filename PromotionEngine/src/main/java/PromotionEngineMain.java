import com.mearsk.pojo.Product;
import com.mearsk.pojo.Promotion;
import com.mearsk.service.TotalCartAmount;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PromotionEngineMain {
  public static void main(String[] args) {

      List<Product> productlist = Arrays.asList(new Product(1,"A", 3, 50, false),
              new Product(2, "B", 5, 30,false));
      List<Promotion> promotionlist = Arrays.asList(new Promotion(1, 130, 3, 1),
              new Promotion(2, 45, 2, 2),
              new Promotion(3, 30, 1, 3),
              new Promotion(4, 30, 1, 3));

      TotalCartAmount pc = new TotalCartAmount();
      if(productlist.size()>0){
          int totalProductPrice = pc.totalCartAmount(productlist, promotionlist);
          System.out.println("Total Product Price ::: " + totalProductPrice);
      } else {
          System.out.println("Cart is empty");
      }
}
}
