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
        <title>Update product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <%@include file="./Menu.jsp"%> 
        <section class="bg-weak">
            <form action="Manage">
                <div class="container bg-white">

                    <div class="row px-5">
                        <div class="col-md-5 mt-5">
                            <c:set var="product" value="${requestScope.product}"/>
                            <h2 class="my-5 fw-bold">Hình ảnh sản phẩm</h2>
                            <div class="">
                                <div class="border-dotted p-5 d-flex flex-column box-input-image w-90 position-relative justify-content-center" style="height: 50vh">
                                    <i class='bx bx-image-add fs-1 text-danger'></i>
                                    <span class="text-danger fs-3">Thêm hình ảnh(1)</span>
                                    <input type="file" 
                                           value="${product.product_img}"
                                           name="productImage"
                                           accept="image/gif, image/jpeg, image/png"
                                           onchange="inputImage(this)"
                                           class="form-control w-100 h-100 position-absolute top-0 start-0" style="z-index: 100; opacity: 0;" name="photo" placeholder="Enter photo">
                                    <input value="${product.product_img}" name="beforeImage" type="hidden"/>
                                    <img src="./images/${product.product_img}"
                                         alt="" class="position-absolute start-0" id="boxImage"/>
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
                                            <label class="fs-4" for="product-name">Mã sản phẩm</label>
                                        </div>
                                        <div class="col-md-10 insert-product-input">
                                            <input type="text" id="product-name" 
                                                   class="rounded-sm border w-100 fs-3 py-4 px-3" 
                                                   name="productId"
                                                   value="${product.product_id}"
                                                   placeholder="Product name"
                                                   style="pointer-events: none;"
                                                   />
                                        </div>
                                    </div>
                                </div>

                                <div class="my-5">
                                    <div class="row d-flex align-items-center">
                                        <div class="col-md-2 text-end">
                                            <label class="fs-4" for="product-name">Tên sản phẩm</label>
                                        </div>
                                        <div class="col-md-10 insert-product-input">
                                            <input type="text" id="product-name" 
                                                   class="rounded-sm border w-100 fs-3 py-4 px-3" 
                                                   name="productName"
                                                   value="${product.product_name}"
                                                   placeholder="Product name"/>  
                                        </div>
                                    </div>
                                </div>

                                <div class="my-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end px-3">
                                        <label class="fs-4" for="product-type">Danh mục</label>
                                    </div>
                                    <div class="w-100">
                                        <select class="form-select py-3 fs-3" aria-label="Default select example"
                                                name="category">
                                            <c:set var="cat_id" value="${product.category_name}"/>
                                            <c:forEach var="category" items="${requestScope.product_category}">
                                                <option value="${category}"
                                                        ${cat_id==category?"selected":""}
                                                        >${category}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="my-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end px-3">
                                        <label class="fs-4" for="product-type">Thương hiệu</label>
                                    </div>
                                    <div class="w-100">
                                        <select class="form-select py-3 fs-3" aria-label="Default select example"
                                                name="brand"
                                                >
                                            <c:set var="pro_brand" value="${product.brand_id}"/>
                                            <c:forEach var="brand" items="${requestScope.product_brand}">
                                                <option value="${brand.brand_id}"
                                                        ${pro_brand==brand.brand_id?"selected":""}
                                                        >${brand.brand_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="row mt-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end">
                                        <label class="fs-4" for="product-quantity">Giá nhập</label>
                                    </div>
                                    <div class="col-md-10 insert-product-input">
                                        <input type="number" min="0" id="product-quantity"
                                               name="price_import"
                                               value="${product.price_import}"
                                               class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="product-quantity"/>  
                                    </div>
                                </div>

                                <div class="row mt-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end">
                                        <label class="fs-4" for="product-quantity">Giá bán</label>
                                    </div>
                                    <div class="col-md-10 insert-product-input">
                                        <input type="number" min="0" id="product-quantity"
                                               name="price_sell"
                                               value="${product.price_sell}"
                                               class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="product-quantity"/>  
                                    </div>
                                </div>
                                <div class="row mt-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end">
                                        <label class="fs-4" for="product-quantity">Số lượng</label>
                                    </div>
                                    <div class="col-md-10 insert-product-input">
                                        <input type="number" min="1" id="product-quantity"
                                               name="quantity"
                                               value="${product.quantity}"
                                               class="rounded-sm border w-100 fs-3 py-4 px-3" placeholder="product-quantity"/>  
                                    </div>
                                </div>
                                <div class="row mt-5 d-flex align-items-center">
                                    <div class="col-md-2 text-end">
                                        <h3 class="fs-4">Sale</h3>
                                    </div>
                                    <div class="col-md-10 insert-product-input">
                                        <input type="number" name="discount"
                                               value="${product.discount}"
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
                                            <input class="form-control fs-3 px-3"
                                                   name="productDesc"
                                                   value="${product.product_desc}"
                                                   placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="Service" value="Update">
                <div class="row py-5">
                    <button type="submit"
                            name="Submit"
                            value="submit"
                            class="d-block mx-auto w-25 px-4 py-4
                            border-0 rounded-sm min-w20 text-center bg-success
                            text-white shadow-lg">
                        <span class="fs-3 fw-semibold">Update</span>
                    </button>
                </div>
            </form>
        </section>
    <script>
    function inputImage(input) {
        var filePath = input.value;
        var fileName = filePath.split('\\').pop();

        var imagePreview = document.getElementById('boxImage');
        imagePreview.src = "./images/" + fileName;
        fileInput.setAttribute('value', file.name);
        console.log(fileName);
    }
</script>

    </body><!--Hàm inputImage được gọi với tham số đầu vào, đại diện cho phần tử đầu vào đã kích hoạt sự kiện thay đổi.

Hàm lấy giá trị của phần tử đầu vào, đại diện cho đường dẫn của tệp đã chọn trên máy cục bộ của người dùng và gán nó cho biến filePath.

Câu lệnh filePath.split('\\').pop() chia đường dẫn tệp theo ký tự dấu gạch chéo ngược ("") và truy xuất phân đoạn cuối cùng tương ứng với 
           tên tệp. Tên tệp này được gán cho biến fileName.

Sau đó, mã sẽ chọn một thành phần hình ảnh có ID "boxImage" bằng cách sử dụng document.getElementById('boxImage') và gán nó cho biến
           imagePreview.

Thuộc tính nguồn (src) của phần tử imagePreview được cập nhật thành "./images/" được nối với tên tệp. Điều này giả định rằng hình ảnh 
           được lưu trữ trong thư mục có tên "hình ảnh" tương ứng với trang hiện tại.

Mã chọn phần tử đầu vào ẩn (không hiển thị trong đoạn mã được cung cấp) bằng cách sử dụng fileInput và đặt giá trị của nó 
           thành file.name. Tuy nhiên, tệp không được xác định trong đoạn mã được cung cấp nên dòng này có thể gây ra lỗi. 
           Nếu bạn định đặt giá trị của phần tử đầu vào bị ẩn thành biến fileName, bạn có thể thay thế file.name bằng fileName.

Cuối cùng, tên tệp được ghi vào bảng điều khiển bằng console.log(fileName).

Điều đáng lưu ý là đoạn mã này giả định sự tồn tại của các phần tử HTML có ID cụ thể ("boxImage" và "fileInput") và phần tử đầu vào tệp tương ứng kích hoạt hàm inputImage.-->
</html>
