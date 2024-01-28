<%-- 
    Document   : productDetail
    Created on : Oct 12, 2023, 2:57:47 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Detail</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"
              />
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <c:set var="product" value="${requestScope.currentProduct}"></c:set>
            <!--biến product sẽ chứa giá trị của currentProduct trong phạm vi requestScope.-->
            <section id="product-detail" class="mt-5">
                <div class="container h-100">
                    <div class="row gx-5 d-flex align-items-center border">
                        
                        <div class="col-md-2">
                           <div class="" style="width: 200px;" >
                                    <img src="./images/${product.product_img}" alt=""/>
                           </div>
                        </div>
                           
                        <div class="product-title col-md-3">
                                <h3 class="fw-bold">${product.product_name}</h3>
                        </div>
                         <div class="col-md-1">
                            <p class="text-decoration-line-through text-black fs-4 m-0">${product.price_sell}₫</p>
                        </div>
                        
                        <div class="col-md-1 d-flex align-items-center text-black rounded-sm">
                            <span class="p-2 mx-2 fs-5 fw-bold fs-2 text-black">sale ${product.discount}%</span>
                        </div>
                        
                        <div class="col-md-1 bg-danger text-white px-2">
                            <span class="fs-3 fw-bold">${product.price_sell * (1-(product.discount/100))}đ</span>
                        </div>
                        
                        <div class="col-md-4">
                            <!--//submit form to add to cart-->
                            <form action="cart" method="post">
                                
                                <!--hidden of data want to send-->
                                <input type="text" name="Service" value="addToCart" hidden/>
                                <input value="${product.product_id}" name="product_id" hidden/>
                                
                                <div class="w-75 mt-5">
                                    <h5 class="fw-semibold">Number:</h5>
                                    <div class="d-flex align-items-center" name="num">
                                        <div class="box-input">
                                            <!--quantity-->
                                            <input type="number" name="quantity" value="1" min="1" max="50">
                                        </div>
                                        <div class="ms-4 fs-5">
                                            <span id="number-available"></span> sản phẩm có sẵn        
                                            <span name="id">${product.getQuantity()}</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-5">
                                    <div class="d-flex">
                                        <input type="submit" class="px-4 py-3 h-100 border-0 rounded-sm min-w20 text-center bg-success text-white shadow-lg fs-3" value="Add to bag" id="minusNumberBtn">
                                    </div>
                                </div>
                            </form>
                         </div>
                        </div>
                       <div class="mt-5">
                                <div class="">
                                    <div class="fs-4">
                                        <p>${product.product_desc}</p>
                                    </div>
                                </div>
                        </div>
                                    
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="Footer.jsp"></jsp:include>
        <script>
            const addNumberBtn = document.getElementById('addNumberBtn');
            const minusNumberBtn = document.getElementById('minusNumberBtn');
            const numberValue = document.getElementById('numberValue');
            const numberAvailable = document.getElementById('number-available');
            //avoid more than available
            numberValue.addEventListener('change', () =>
            {
                if (parseInt(numberValue.value) > parseInt(numberAvailable.innerText)) {
                    numberValue.value = parseInt(numberAvailable.innerText);
                }
            }
            );
            minusNumberBtn.addEventListener('click', () =>
            {
                if ((parseInt(numberValue.value) - 1) > 0) {
                    numberValue.value = (parseInt(numberValue.value) - 1);
                }
            });
            addNumberBtn.addEventListener('click', () => {
                if ((parseInt(numberValue.value) + 1) <= parseInt(numberAvailable.innerText)) {
                    numberValue.value = (parseInt(numberValue.value) + 1);
                }
            });

        </script>
    </body>
</html>
