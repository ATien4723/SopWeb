<%-- 
    Document   : SignUp
    Created on : 17 Oct, 2023, 11:17:47 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign up</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <style>
            .loginbody {
              background-image: url("./images/bgLogin.jpg");
              background-position: center;
              background-size: cover;
            }
        </style>
    </head>

    <body>
        <section id="" class="header-login">
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
        <section class="loginbody d-flex align-items-center" style="height: 89vh">
            <div class="bg-white p-5 form-login">
                <form action="login" method="post">
                    <h3 class="text-center fw-bold">Wellcome to login</h3>
                    <p class="text-danger">${mess}</p>
                    <div class="">
                        <div class="border-bottom">
                            <span class="fs-5 fw-bold text-black-weak">Username</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-user'></i>
                                <input type="text" 
                                       name="username"
                                       placeholder="Username" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                        
                        <div class="border-bottom mt-5">
                            <span class="fs-5 fw-bold text-black-weak">password</span>
                            <div class="d-flex align-items-center fs-4 mt-3">
                                <i class='bx bx-lock'></i>
                                <input type="password"
                                       name="password"
                                       placeholder="Password" class="w-100 py-4 outline-0 border-0 ms-3" />
                            </div>
                        </div>
                    </div>
                    
                    <div class="text-center mt-3 fs-5">
                        Already have an account?
                        <a href="SignUp" class="text-black-weak text-info">SignUp</a>
                    </div>
                    <button type="submit" class="d-block rounded-xl fs-4 fw-bold w-100
                            text-white py-3 mt-5 bg-red text-center bg-info border-0">
                        Login
                    </button>
                </form>
            </div>
        </section>

    </body>
</html>


