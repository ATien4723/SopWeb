<%-- 
    Document   : login
    Created on : Oct 12, 2023, 3:25:39 PM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Detail</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <!--t?o hi?u ?ng tr??t cho trang-->
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body class="position-relative">
        <section id="header">
            <div class="container">
                <div class="row align-items-center h-78">
                    <div class="col-md-1">
                        <div class="header-logo">
                            <a href="#"><img src="./images/shopping_Logo.png" alt=""></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="">
            <div class="bg-white p-5 form-login">
                <form action="change" method='post'>
                    <h1 class="text-center fw-bold" style="text-align: center">Change Password</h1>
                    <p class="text-danger">${ms}</p>
                    <div class="">
                        <div class="border-bottom mt-5">
                            <span class="fs-5 fw-bold text-black-weak">Old password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password" name="opass" placeholder="OldPassword" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <input type="hidden" name="user" value="${sessionScope.acc.username}">
                        <div class="border-bottom mt-5">
                            <span class="fs-5 fw-bold text-black-weak">New password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password" name="pass" placeholder="NewPassword" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Comfirm password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="password" name="rpass" placeholder="Repassword" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>

                    </div>
                    <div class="text-center mt-3 fs-5">
                        Don't want to change password?
                        <a href="ProductURL" class="text-black-weak text-info">Home</a>
                    </div>
                    <button type="submit" class="d-block rounded-xl fs-4 fw-bold w-100 text-white py-3 mt-5 bg-red text-center bg-danger">Change<button>
                </form>
            </div>
        </section>
    </body>
</html>

