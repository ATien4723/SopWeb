<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.Normalizer" %>
<%@page import="java.util.regex.Pattern" %>
<%@page import="DAL.*" %>
<%@page import="Models.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cartegories</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <%@include file="./Menu.jsp" %>


        <c:forEach items="${sessionScope.listD}" var="pro">
            <h3>${pro}</h3>
        </c:forEach>
        <section>
            <div class="container">
                <div class="row border-top ">
                    <div class="col-md-12 row border-top py-3">
                        <%--<c:forEach items="${cart.items}" var="item" >--%>
                        <div class="col-md-12 pe-5">
                            <div class="row order-item py-5">
                                <div class="row bg-black text-white rounded-md py-3">
                                    <div class="col-md-3 fs-3 fw-bold">Product image</div>
                                    <div class="col-md-2 fs-3 fw-bold">Name</div>
                                    <div class="col-md-1 fs-3 fw-bold">Discount</div>
                                    <div class="col-md-1 fs-3 fw-bold">Price</div>
                                    <div class="col-md-2 fs-3 fw-bold">Quantity</div>
                                    <div class="col-md-1 fs-3 fw-bold">Apply</div>
                                    <div class="col-md-2 fs-3 fw-bold">Setting</div>
                                </div>
                                <%
                                  Account acc = null;
                                 if(session.getAttribute("account") != null) {
                                     acc = (Account)session.getAttribute("account");
                                  }
                                  int numberOrder = 0;
                                 double totalBill = 0;
                                     
                                 java.util.Enumeration em = session.getAttributeNames();
                                 while(em.hasMoreElements()){
                                     //id la cart-id
                                     String id = em.nextElement().toString();
                                    if (id.startsWith("key")) {
                                      numberOrder++;
                                      Product pro = (Product)session.getAttribute(id);
                                      totalBill += pro.getAfterPrice();
                                %>
                                <div class="row border mt-3 align-items-center rounded-sm">
                                    <div class="col-md-3"><a href="ProductURL?Service=ProductDetail&Pid=" class="d-block h-100">
                                            <img src="./images/<%=pro.getProduct_img()%>" alt="" style="width: 150px;" class="rounded-lg object-fit-cover">
                                        </a>
                                    </div>
                                    <div class="col-md-2">
                                        <h3 class="fw-bold"><%=pro.getProduct_name()%></h3>
                                    </div>
                                    <div class="col-md-1">
                                        <h3 class=""><%=pro.getDiscount()%><span class="text-danger fw-bold fs-3">%</span></h3>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <span class="fs-4"><%=pro.getPrice_sell()%> vnd</span>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="box-input" >
                                            <div class="box-input">

                                                <button class="border-0 bg-white">
                                                    <a href="cart?Service=minus&product_id=<%=pro.getProduct_id()%>" class="p-3 text-black"><i class="fa-solid fa-minus fs-5"></i></a>
                                                </button>

                                                <input type="text" value="<%=pro.getQuantity()%>" class="input-number" id="numberValue" />

                                                <button class="border-0 bg-white">
                                                    <a href="cart?Service=add&product_id=<%=pro.getProduct_id()%>" class="p-3 text-black"><i class="fa-solid fa-plus fs-5"></i></a>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-1 text-center">
                                        <span class="fs-4"><%=String.format("%,.0f",pro.getAfterPrice()).replace(",", ".")%> vnd</span>
                                    </div>
                                    <div class="col-md-2">
                                        <a href="cart?Service=remove&product_id=<%=pro.getProduct_id()%>" 
                                           class="text-decoration-none fs-4 fw-bold text-danger">
                                            Delete
                                        </a>
                                    </div>
                                </div>
                                <%}%>
                                <%}%>

                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-12 text-order fs-4 fw-500 p-5">
                    <div class="w-80 m-auto">
<!--                        <h4 class="fw-semibold text-dark">Order Summary</h4>-->
                        <div class="d-flex align-items-center justify-content-between border-bottom py-3">
                            <span>Total: </span>
                            <span><%=String.format("%,.0f",totalBill).replace(",", ".")%> vnd</span>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <a href="cart?Service=checkout" class="mt-5 d-block py-3 text-decoration-none fs-2 text-center w-100 text-white bg-dark rounded-xl box-shadow1">
                                    Checkout
                                </a>
                            </div>
                            <div class="col-md-6">
                                <div class="text-end">
<!--                                    <a class="text-danger fs-3 fw-bold py-3" href="cart?Service=removeAll">Delete all</a>-->
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@include file="./Footer.jsp" %>
    <script src="./js/app.js"></script>
</body>
}
}
</script>
</html>