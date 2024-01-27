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
<html>
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
       <section class="bg-weak">
        <div class="container bg-white">
            <form action="Manage">
                <div class="row px-5">
                <div class="col-md-5 mt-5">
                    <h2 class="my-5 fw-bold">Hình ảnh sản phẩm</h2>
                    <div class="">
                        <div class="border-dotted p-5 d-flex flex-column box-input-image w-90 position-relative justify-content-center">
                            <i class='bx bx-image-add fs-1 text-danger'></i>
                            <span class="text-danger fs-3">Thêm hình ảnh(1)</span>
                             <input type="file" 
                                    name="productImage"
                                    accept="image/gif, image/jpeg, image/png"
                                    onchange="inputImage(this)"
                                  class="form-control w-100 h-100 position-absolute top-0 start-0" style="z-index: 100; opacity: 0;" name="photo" placeholder="Enter photo">
                             <img src="" alt="" class="position-absolute start-0" id="boxImage" style="height: 50vh"/>
                            <!-- <input onchange="chooseFile(this)" type="file" accept="image/gif, image/jpeg, image/png" class="w-100 bg-danger h-100 position-absolute top-0 end-0 opacity-0"> -->
                        </div>
                    </div>
                </div>
                <div class="col-md-7 mt-5">
                    <div >
                        <h2 class="my-5">Thông tin chi tiết sản phẩm</h2>
                        <div class="my-5">
                            <div class="row d-flex align-items-center">
                              <div class="col-md-2 text-end">
                                <label class="fs-4" for="product-name">Tên sản phẩm</label>
                              </div>
                              <div class="col-md-10 insert-product-input">
                                <input type="text" id="product-name" 
                                       class="rounded-sm border w-100 fs-3 py-4 px-3" 
                                       name="productName"
                                       placeholder="Product name"/>  
                              </div>
                            </div>
                            
                            <div class="my-5 d-flex align-items-center">
                               <div class="col-md-2 text-end px-3">
                                 <label class="fs-4" for="product-type">Danh mục</label>
                               </div>
                               <div class="w-100">
                                <select class="form-select py-3 fs-3" aria-label="Default select example"
                                        name="category">
                                    <c:forEach var="category" items="${requestScope.product_category}">
                                      <option value="${category}">${category}</option>
                                    </c:forEach>
                                </select>
                               </div>
                            </div>
                            <div class="my-5 d-flex align-items-center">
                               <div class="col-md-2 text-end px-3">
                                 <label class="fs-4" for="product-type">Thương hiệu</label>
                               </div>
                               <div class="w-100">
                                <select class="form-select py-3 fs-3"
                                        name="brand"
                                        aria-label="Default select example">
                                    <c:forEach var="brand" items="${requestScope.product_brand}">
                                      <option value="${brand.brand_id}">${brand.brand_name}</option>
                                    </c:forEach>
                                </select>
                               </div>
                            </div>
                            
                            <div class="row mt-5 d-flex align-items-center">
                                <div class="col-md-2 text-end">
                                  <label class="fs-4" for="product-import">Giá Nhập</label>
                                </div>
                                <div class="col-md-10 insert-product-input">
                                  <input type="number" min="1" id="product-import"
                                         name="priceImport"
                                         class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="Giá Nhập"/>  
                                </div>
                            </div>
                            
                            <div class="row mt-5 d-flex align-items-center">
                                <div class="col-md-2 text-end">
                                  <label class="fs-4" for="product-sell">Giá bán</label>
                                </div>
                                <div class="col-md-10 insert-product-input">
                                  <input type="number" min="1" id="product-sell"
                                         name="priceSell"
                                         class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="Giá bán"/>  
                                </div>
                            </div>
                            
                            <div class="row mt-5 d-flex align-items-center">
                                <div class="col-md-2 text-end">
                                  <label class="fs-4" for="product-quantity">Số lượng</label>
                                </div>
                                <div class="col-md-10 insert-product-input">
                                  <input type="number" min="0" id="product-quantity"
                                         name="quantity"
                                         class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="Số lượng"/>  
                                </div>
                            </div>
                            
                            <div class="row mt-5 d-flex align-items-center">
                                <div class="col-md-2 text-end">
                                    <h3 class="fs-4">discount</h3>
                                  </div>
                                  <div class="col-md-10 insert-product-input">
                                    <input type="number" name="discount"
                                           class="rounded-sm border w-25 fs-3 py-4 px-3" placeholder="Percent"/>  
                                    <span class="px-4 fs-3">%</span> 
                                </div>
                            </div>
                            
                            <div class="row mt-5 d-flex align-items-center">
                                <div class="col-md-2 text-end">
                                  <label class="fs-4">Mô tả sản phẩm</label>
                                </div>
                                <div class="col-md-10">
                                    <div class="form-floating">
                                        <textarea class="form-control fs-3 px-3"
                                                  name="productDesc"
                                                  placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
                                      </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <input type="hidden" name="Service" value="addProduct">
            <div class="row py-5">
                <button type="submit" href="/cartegories.html" 
                        name="add"
                        value="add"
                        class="d-block mx-auto w-25 px-4 py-4
                        border-0 rounded-sm min-w20 text-center bg-success
                        text-white shadow-lg">
                    <span class="fs-3 fw-semibold">Insert</span>
                </button>
            </div>
            </form>
        </div>
    </section>
       <script>
        function inputImage(input) {
           var filePath = input.value;
           var fileName = filePath.split('\\').pop(); 
    
           var imagePreview = document.getElementById('boxImage');
           imagePreview.src = "./images/"+fileName;
           console.log(fileName);
        }
    </script>
    </body>
</html>
