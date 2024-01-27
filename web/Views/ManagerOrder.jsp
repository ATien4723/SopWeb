<%-- 
    Document   : MangerOrder
    Created on : 6 Nov, 2023, 8:58:07 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.Normalizer" %>
<%@page import="java.util.regex.Pattern" %>
<%@page import="DAL.*" %>
<%@page import="Models.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div>
            <ul>
                <li>
                    <a href="Order?Service=filterByStatus&OrderStatus=wait">Wait</a>
                </li>
                <li>
                    <a href="Order?Service=filterByStatus&OrderStatus=process">Process</a>
                </li>
                <li>
                    <a href="Order?Service=filterByStatus&OrderStatus=done">Done</a>
                </li>
            </ul>
        
        
        
        <div class="search align-items-center">
            <div class="row order-item py-5">
                <div class="row bg-black text-white rounded-md py-3">
                    <div class="col-md-2 fs-4 fw-bold">order_id</div>
                    <div class="col-md-2 fs-4 fw-bold">account_id</div>
                    <div class="col-md-2 fs-4 fw-bold">order_date</div>
                    <div class="col-md-2 fs-4 fw-bold">recieve date</div>
                    <div class="col-md-2 fs-4 fw-bold">status</div>
                    <div class="col-md-2 fs-4 fw-bold">Setting</div>

                </div>
                <c:forEach items="${listOrder}" var="order">
                    <div class="row border mt-3 align-items-center rounded-sm">
                        <div class="col-md-2">
                            <h4 class="fw-bold fs-3">${order.order_id}</h4>
                        </div>
                        <div class="col-md-2">
                            <h4 class="fw-bold fs-3">${order.account_id}</h4>
                        </div>
                        <div class="col-md-2">
                            <h4 class="fs-3">${order.order_date}</h4>
                        </div>
                        <div class="col-md-2 text-center">
                            <h4 class="fs-3">${order.recieve_date}</h4>
                        </div>
                        <div class="col-md-2">
                            <h4 class="fs-3">${order.status}</h4>
                        </div>
                        <!-- Mã này tạo danh sách thả xuống gồm các tùy chọn trạng thái cho mỗi hàng đơn hàng. 
                        Tùy chọn trạng thái đã chọn sẽ xác định trạng thái mới khi chức năng ChangeStatus được kích hoạt-->
                        <div class="col-md-2">
                            <select name="status" onchange="changeStatus([${order.order_id}, this])">
                                <c:forEach items="${listStatus}" var="status">
                                    <option ${status.equals(order.status)?"selected":""}>${status}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>
                </c:forEach>                 

            </div>
        </div>
        <!--  khi hàm ChangeStatus được gọi, nó sẽ tạo một URL có ID đơn hàng và giá trị trạng thái đã chọn làm tham số,
          sau đó chuyển hướng trình duyệt đến URL đó -->
        <script>
            function changeStatus(param) {
                let url = "Order?Service=changeStatus&OrderID=" + param[0] + "&status=" + param[1].value;
                window.location = url;
            }
        </script>
        
    </body>
</html>
