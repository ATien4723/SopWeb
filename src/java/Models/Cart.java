//package Models;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart {
//
//    private List<Item> items;
//
//    public Cart() {
//        items = new ArrayList<>();
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public int getQuantityById(int id) {
//        return getItemById(id).getQuantity();
//    }
//
//    private Item getItemById(int id) {
//        for (Item i : items) {
//            if (i.getProduct().getProduct_id() == id) {
//                return i;
//            }
//        }
//        return null;
//    }
//
//    public void addItem(Item t) {
//        if (getItemById(t.getProduct().getProduct_id()) != null) {//sp đã có trong giỏ
//            Item m = getItemById(t.getProduct().getProduct_id());
//            m.setQuantity(m.getQuantity() + t.getQuantity());  // cập nhật lại số lượng
//        } else {
//            items.add(t);
//        }
//    }
//
//    public void removeItem(int id) {
//        if (getItemById(id) != null) {
//            items.remove(getItemById(id));
//        }
//    }
//
//    public double getTotalMoney() {
//        double t = 0;
//        for (Item i : items) {
//            t += (i.getQuantity() * i.getPrice());
//        }
//        return t;
//    }
//
//    private Product getProductById(int id, List<Product> list) {
//        for (Product i : list) {
//            if (i.getProduct_id() == id) {
//                return i;
//            }
//        }
//        return null;
//    }
//
//    public Cart(String txt, List<Product> list) {  //Giỏ hàng đọc từ cookie ra
//        items = new ArrayList<>();
//        try {
//            if (txt != null && txt.length() != 0) {//nếu có tồn tại giỏ hàng
//                String[] s = txt.split(",");
//                for (String i : s) {
//                    String[] n = i.split(":");
//                    int id = Integer.parseInt(n[0]);
//                    int quantity = Integer.parseInt(n[1]);
//                    Product p = getProductById(id, list);
//                    Item t = new Item(p, quantity, p.getProduct_price()*2);
//                    addItem(t);
//                }
//            }
//        }catch(NumberFormatException e){
//            
//        }
//    }
//}
