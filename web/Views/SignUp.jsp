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
        <style>
            .loginbody {
              background-image: url("./images/bgLogin.jpg");
              background-position: center;
              background-size: cover;
              overflow-y: hidden;
            }
        </style>
    </head>
    <body class="position-relative">
        <section id="header">
            <div class="container">
                <div class="row align-items-center h-78">
                    <div class="col-md-1">
                        <div class="header-logo">
                            <a href="ProductURL"><img src="./images/shopping_Logo.png" alt=""></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="loginbody" >
            <div class="bg-white p-5 form-login" style="height: 89vh">
                <form action="SignUp" method="post">
                    <h2 class="text-center fw-bold">Sign Up</h2>
                    <p class="text-danger">${mess}</p>
                    <div class="">
                        <div class="d-flex align-items-center">
                            <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">First-Name</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="text" name="firstName" placeholder="FirstName" value="${firstName!=null?firstName:""}" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Last-Name</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="text" name="lastName" placeholder="LastName" value="${lastName!=null?lastName:""}" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        </div>
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Email</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="email" name="email" placeholder="Email" value="${email!=null?email:""}"  class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Username</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="text" name="user" placeholder="Username" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom mt-3">
                            <span class="fs-5 fw-bold text-black-weak">Create password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password" name="pass" placeholder="Password" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        <div class="border-bottom mt-3">
                            <span class="fs-5 fw-bold text-black-weak">Confirm password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password" name="repass" placeholder="Password" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        
                        <div class="border-bottom mt-3">
                            <span class="fs-5 fw-bold text-black-weak">PhoneNumber</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="number" name="phone" placeholder="PhoneNumber" value="${phone!=null?phone:""}" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>

                    </div>
                    <div class="text-center mt-3 fs-5">
                        Already have an account?
                        <a href="login" class="text-black-weak text-info"> Login</a>
                    </div>
                    <button type="submit" class="d-block rounded-xl fs-4 fw-bold w-100 text-white py-3 mt-5 bg-red text-center border-0 bg-info">Sign Up<button>
                </form>
            </div>
       </section>
    </body>
</html>
