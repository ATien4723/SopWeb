let mobileCart = document.querySelector("#header #mobile .menu-icon"); //icon menu
let navBar = document.getElementById("navbar"); //Menu
let closeBar = document.getElementById("close"); //Chữ x
let modal = document.getElementById("modal"); //Phần tối
mobileCart.addEventListener('click', ()=> {  //Khi nhấp vào biểu tượng menu
    navBar.style.right = 0; //làm cho thanh điều hướng trượt ra từ phía bên phải của trang
    modal.classList.add("open");  //mở khoảng đen
});
modal.addEventListener('click', ()=> {
    modal.classList.remove("open");
    navBar.style.right = "-300px";
});
closeBar.addEventListener('click', ()=> {
    navBar.style.right = "-300px";
    modal.classList.remove("open");
});

// increase, decrease number product order
