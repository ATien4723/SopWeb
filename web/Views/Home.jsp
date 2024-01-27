


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.Normalizer" %>
<%@page import="java.util.regex.Pattern" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Detail</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
        <!--tạo hiệu ứng trượt cho trang-->
        <link rel="stylesheet" href="./css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <section id="hero">
                <h4>Trade-in-offer</h4>
                <h2>Super value deals</h2>
                <h1>On all products</h1>
                <p>Save more with coupons & up to 70% off</p>
                <button>Shop Now</button>
            </section>

            <section id="feature" class="section-p1">
                <div class="fe-box">
                    <img src="./images/features/f1.png" alt="">
                    <h6>Free Shipping</h6>
                </div>
                <div class="fe-box">
                    <img src="./images/features/f2.png" alt="">
                    <h6>Online Order</h6>
                </div>
                <div class="fe-box">
                    <img src="./images/features/f3.png" alt="">
                    <h6>Save Money</h6>
                </div>
                <div class="fe-box">
                    <img src="./images/features/f4.png" alt="">
                    <h6>Promotions</h6>
                </div>
                <div class="fe-box">
                    <img src="./images/features/f5.png" alt="">
                    <h6>Happy Sell</h6>
                </div>
                <div class="fe-box">
                    <img src="./images/features/f6.png" alt="">
                    <h6>F24/7 Support/h6>
                </div>
            </section>

            <section id="body" class="mt-5">
                <div class="fashion-container h-100 mt-5">
                    <div class="row box-fashion d-flex">
                        <div class="bg-white">
                            <div class="row list-filter p-5">

                                <div class="col-12 boder p-4">
                                    <div class="d-flex align-items-center justify-content-between">
                                        <h3 class="text-uppercase fs-5 fw-bold">Thể loại: </h3>
                                        <div class="filter-header">
                                            <a id="clearAll" href="ProductURL?Service=clearfilter"
                                               class="text-danger fs-4">
                                                Clear all
                                            </a>
                                        </div>
                                    </div>
                                <c:set value="${requestScope.category}" var="cat_select"/>
                                <c:set var="discount" value="${requestScope.discount}" />
                                <div class="row">
                                    <c:forEach var="category" items="${requestScope.product_category}">
                                        <div class="col-1 mt-3 ms-4 px-4 py-2 rounded-md text-center box-shadow1">
                                            <a href="ProductURL?Service=filter&catFilter=${category}&disFilter=${discount}"  class="
                                                       text-black fs-4 fw-medium ${cat_select==category?"text-danger":""}">
                                                ${category}
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="col-12 boder p-4">
                                <div class="d-flex align-items-center justify-content-between">
                                    <h3 class="text-uppercase fs-5 fw-bold">Discount range</h3>
                                </div>
                                <div class="row">
                                    <c:forEach var="saleItem" items="${requestScope.salePercent}">
                                        <div class="col-1 mt-3 ms-4 px-4 py-2 rounded-md text-center box-shadow1">
                                            <a href="ProductURL?Service=filter&disFilter=${saleItem}&catFilter=${category}"  class="
                                               text-black fs-4 fw-medium ${discount==saleItem?"text-danger":""}">
                                                Sale ${saleItem} %
                                            </a>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row right-product h-100 mx-auto">
                        <div class="row g-5">
                            <c:forEach items="${requestScope.listProduct}"  var="product">
                                <div class="col-sm-6 col-md-4 col-lg-3 box-shadow1">
                                    <c:if test="${acc.is_admin }">
                                        <a href="Manage?Service=Update&pid=${product.product_id}" class="d-block h-100 product-item text-decoration-none position-relative">
                                        </c:if>
                                        <c:if test="${!acc.is_admin}">
                                            <a href="ProductURL?Service=ProductDetail&pid=${product.product_id}" class="d-block h-100 product-item text-decoration-none position-relative">
                                            </c:if>
                                            <div class="position-relative">
                                                <img src="./images/${product.product_img}" alt="">
                                            </div>
                                            <div class="p-4 d-flex flex-column">
                                                <h3 class="fw-bold text-black product-title">${product.product_name}</h3>
                                                <div class="flex-fill mt-auto">
                                                    <div class="">
                                                        <p class="text-decoration-line-through text-black fs-4">${product.price_sell}₫</p>
                                                    </div>
                                                    <div class="d-flex align-items-center justify-content-between mt-4">
                                                        <div>
                                                            <span class="product-sale-percent fw-bold">Discount ${product.discount}%</span>
                                                        </div>
                                                        <span class="text-black fs-3">${product.getProductPrice()}vnd</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </a>
                                </div>
                            </c:forEach>
                            <!--Truyền tới servlet sử dụng cho productDetail bằng 1 link-->

                        </div>
                    </div>
                </div>
                <div class="col-12 py-5">
                    <div class="paging-box d-flex align-items-center">
                        <c:if test = '${page.start!=0}'>
                            <span class='button'>
                                <a href="ProductURL?index=0"class="fs-4 text-black text-decoration-none">Home</a>
                            </span>
                            <span class='button prev-paging'>
                                <a href="ProductURL?index=${page.start-1}" class="d-block">
                                    <i class='bx bx-chevron-left'></i>
                                </a>
                            </span>
                        </c:if>

                        <c:set value="${requestScope.currentIndex}" var="currentIndex" />
                        <c:if  test ='${page.pageEnd > page.pageStart}'>
                            <c:forEach var="i" begin="${1}" end = "${page.totalPage-2}">
                                <a href="ProductURL?index=${i}">
                                    <div class="botton border-0 number-paging ${currentIndex==i?"current-paging":""}" >
                                        ${i}
                                    </div>
                                </a>
                            </c:forEach>
                        </c:if>

                        <c:if test = '${page.start<page.totalPage-1}'>
                            <span class='button next-paging'>
                                <a href="ProductURL?index=${page.start+1}">
                                    <div class="d-block">
                                        <i class='bx bx-chevron-right' ></i>
                                    </div>
                                </a>
                            </span>
                            <span class='button'>
                                <a href="ProductURL?index=${page.totalPage-1}">
                                    <div class="fs-4 text-black text-decoration-none">End</div>
                                </a>
                            </span>
                        </c:if>
                    </div>
                </div>
            </div>


        </section>

        <section id="sm-banner" class="section-p1">
            <div class="banner-list">
                <div class="banner-item">
                    <div class="banner-des">
                        <h5>cazy deals</h5>
                        <h2>buy 1 get 1 free</h2>
                        <span>The best classic dress is on sale at cara</span>
                    </div>
                    <button >Learn More</button>
                </div>
                <div class="banner-item">
                    <div class="banner-des">
                        <h5>spring/summer</h5>
                        <h2>upcomming season</h2>
                        <span>The best classic dress is on sale at cara</span>
                    </div>
                    <button >Collection</button>
                </div>
                <div class="banner-item">
                    <div class="banner-des">
                        <h2>SEASONAL SALE</h2>
                        <h3>winter collection-50% off</h3>
                    </div>
                </div>
                <div class="banner-item">
                    <div class="banner-des">
                        <h2>NEW FOOTWEAR COLLECTION</h2>
                        <h3>spring / summer 2022</h3>
                    </div>
                </div>
                <div class="banner-item">
                    <div class="banner-des">
                        <h2>T-SHIRT</h2>
                        <h3>new Trendy prints</h3>
                    </div>
                </div>
            </div>
        </section>

        <section id="newsletter" class="section-p1 section-m1">
            <div class="newstext">
                <h4>sign up for newsletter</h4>
                <p>Get E-mail update about our latest shop and <span>spacial offers.</span></p>
            </div>
            <div class="form">
                <input type="email" placeholder="Your email address...">
                <button class="normal">Sign Up</button>
            </div>
        </section>

        <jsp:include page="Footer.jsp"></jsp:include>
        <div id="modal"></div>
    </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script>
    function handleSearch() {
        // TÌm phần tử có tên search-text và lưu nó vào headerInput
        const headerInput = document.getElementById("search-text");
        // Thêm 1 chuỗi truy vấn vào URL
        window.location = "?Service=search&keyword=" + headerInput.value;
    }
    // Lắng nghe sự kiện khi click vào "Clear all"
    document.getElementById("clearAll").addEventListener("click", function () {
        // Duyệt qua tất cả input radio và bỏ chọn chúng
        var radioInputs = document.querySelectorAll("input");
        radioInputs.forEach(function (input) {
            input.checked = false;
        });
        // Gửi form để quay về đường dẫn gốc
        window.location = "ProductURL"
    });
</script>