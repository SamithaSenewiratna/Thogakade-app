package controller.order;

import controller.item.ItemController;
import db.DBConnection;
import dto.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderController {
    public boolean placeOrder(Order order) throws SQLException {

        String SQL = "INSERT INTO orders VALUES (?,?,?)";

        Connection connection = DBConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setString(1,order.getId());
            psTm.setObject(2,order.getDate());
            psTm.setString(3,order.getCustomerId());

            boolean isOrderAdd = psTm.executeUpdate() > 0;
            if(isOrderAdd){
                boolean isOrderDetailAdd = new OrderDetailController().addOrderDetail(order.getOrderDetails());
                if (isOrderDetailAdd){
                    boolean isUpdateStock = new ItemController().updateStock(order.getOrderDetails());
                    if (isUpdateStock){
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;

        }finally {
            connection.setAutoCommit(true);
        }
    }
}
