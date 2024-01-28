
<%-- 
    Document   : Admin
    Created on : Oct 12, 2023, 3:33:40 PM
    Author     : ADMIN
--%>
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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <%@include file="./Menu.jsp"%> 
        <h3 class="text-danger">${requestScope.mess?requestScope.mess:""}</h3>
        <section>
            <div class="col-md-10 h-100">
                <h1 class="fw-bold my-4">Product</h1>
                <div class="row my-5">
                    <a href="?Service=addProduct" class="text-decoration-none fs-3 text-success
                       border px-3 py-2 fw-bold w-25 mx-auto text-center rounded-lg" >
                        Add more product
                    </a>
                </div>
                <div class="row my-5">
                    <a href="Order" class="text-decoration-none fs-3 text-success
                       border px-3 py-2 fw-bold w-25 mx-auto text-center rounded-lg" >
                        Manager Orders
                    </a>
                </div>
                <div class="row my-5">
                    <div class="col-md-6">
                        <form action="Manage" class="w-50 bg-white border d-flex align-items-center rounded-md overflow-hidden">
                            <button type="submit" class="p-3 border-0 text-black-weak" name="Service"
                                    value="SearchProduct"/>
                            <i class="fa-solid fa-magnifying-glass fs-3"></i>
                            </button>
                            <input type="text" placeholder="Search Product By Id" 
                                   value="${SearchValue!=null?SearchValue:""}"
                                   class="border-0 w-100 py-4 px-3 fs-4"
                                   name="searchId"/>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <select class="form-select w-50 ms-auto fs-3" aria-label="Default select example">
                            <option value="1">Order list by: Id</option>
                            <option value="2">Order list by: Date</option>
                            <option value="3">Order list by: Total</option>
                        </select>
                    </div>
                </div>
                <div class="">
                    <div class="row bg-weak rounded-lg px-3 py-4 fs-4">
                        <div class="col">product_id</div>
                        <div class="col">image</div>
                        <div class="col">name</div>
                        <div class="col">category</div>
                        <div class="col">brand</div>
                        <div class="col">discount</div>
                        <div class="col">price_import</div>
                        <div class="col">price_sell</div>
                        <div class="col">date</div>
                        <div class="col">setting</div>
                    </div>

                    <div class="">
                        <!--Sản phẩm được lấy ra theo search-->
                        <h3 class="text-danger my-3">${mess}</h3>
                        <!--Tất cả sản phẩm được lấy ra--> 
                        <c:if test="${requestScope.listProduct != null}">
                            <c:forEach var="product" items="${requestScope.listProduct}">

                                <div class="mt-5 border-top bg-white rounded-lg border">
                                    <div class="row position-relative fs-4 px-3 py-4 d-flex align-items-center ">
                                        <div class="col">${product.product_id}</div>
                                        <div class="col">
                                            <img src="./images/${product.product_img}" alt="alt"/>
                                        </div>
                                        <div class="col">${product.product_name}</div>
                                        <div class="col">${product.category_name}</div>
                                        <div class="col">${product.getBrandName()}</div>
                                        <div class="col">${product.discount}</div>
                                        <div class="col">${product.price_import}</div>
                                        <div class="col">${product.price_sell}</div>
                                        <div class="col">${product.date_added}</div>
                                        <div class="col d-flex">
                                            <a href="Manage?Service=Update&pid=${product.product_id}" class="me-4 text-info fw-bold fs-5">Update</a>
                                            <a href="Manage?Service=Delete&pid=${product.product_id}" class="text-danger fw-bold fs-5">Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>  
                        </c:if>
                    </div>
                </div> 
            </div>

        </section>
    </body>
</html>
