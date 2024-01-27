<%-- 
    Document   : Menu
    Created on : Oct 11, 2023, 4:30:04 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>

    </head>
    <body>
        <section id="header">
            <a href="ProductURL"><img src="./images/shopping_Logo.png" class="logo" alt=""></a>  
            <div class="search align-items-center">
                <input type="text" name="txtSearch" id="search-text"
                       class="my-0"
                       placeholder="Search..."/>
                <div class="search-icon p-2 fs-4" onclick="handleSearch()">
                    <div class="border-0 d-flex">
                        <i class='bx bx-search'></i>
                    </div>
                </div>
            </div>


            <div>
                <ul id="navbar">
                    <li class="links-item"><a class="active" href="ProductURL">Home</a></li>
                    <li class="links-item"><a href="Manage">Manage Product</a></li>

                    <c:if test="${sessionScope.acc != null}">
                        <li class="links-item"><a href="#">Hello ${sessionScope.acc.last_name}</a></li>
                        <li class="links-item"><a href="logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                        <li class="links-item"><a href="login">Login</a></li>
                        </c:if>
<!--                    <a href="#" id="close"><i class='bx bx-x' ></i></a>-->
                </ul>
            </div>

            <div class="row1">
                <c:if test="${sessionScope.acc != null}">
                    <div class="col love">
                        <div class="user-status">
                            <div class="user-logo">
                                <i class='bx bx-user'></i>
                            </div>
                            <a class="user-title" href="change" style="text-align: center">Change Password</a>
                        </div>
                    </div>
                </c:if>
                <div class="col love">
                    <a class="d-block text-black" href="cart"> 
                        <div class="cart-status">
                        <div class="cart-logo">
                            <i class='bx bx-shopping-bag'></i>
<!--                           <h3 class="text-white bg-success text-center" style="border-radius: 50%;">
                                ${sessionScope.numOrder!=null?sessionScope.numOrder:""}
                            </h3>-->
                        </div>
                    </div>
                    </a>
                </div>
            </div>

            <div id="mobile">
                <i class='bx bx-menu menu-icon'></i>
            </div>

        </section>
    </body>
</html>
