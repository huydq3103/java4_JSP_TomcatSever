//[] truyền depencies thường thì  để null
var myApp = angular.module('myModule',["ngRoute"]);

//chuyen trang

myApp.config(function($routeProvider,$locationProvider) {
    // xoa duong dan
  
    $locationProvider.hashPrefix('');


     //chuyen trang $routeProvider
      
     $routeProvider.when('/trang-chu',{
        // do something
        // nội dung của trang chủ
           templateUrl :"./pages/trang-chu.html",
           controller : SanPhamController,
     })
 
     .when('/san-pham',{
        // do something
        // nội dung của trang chủ
        templateUrl :"./pages/San-Pham.html",
        controller : SanPhamController,
     })
     .when('/dang-ki',{
        templateUrl :"./pages/Dang-ki.html",
        controller : SanPhamController,
     })
     .when('/gioi-thieu',{
      templateUrl :"./pages/Gioi-Thieu.html",
     })
     .when('/quen-mat-khau',{
      templateUrl :"./pages/DoiMatKhau.html",
      controller : SanPhamController,
     }) 
      .when('/dang-nhap',{
      templateUrl :"./pages/Dang-Nhap.html",
      controller : dangNhapController,
     }) 
      .when('/gio-hang',{
      templateUrl :"./pages/Gio-Hang.html",
      controller : gioHangController,
     })
     
     .when('/detail/:id',{
      templateUrl :"./pages/Detail.html",
      controller : SanPhamController,
     })
     //
       .when('/lien-he',{
      templateUrl :"./pages/lien-he.html",
      controller : SanPhamController,
     }).when('/category',{

      templateUrl :"./pages/quan-li-loaiSP.html",
      controller : SanPhamController,
     }).when('/procduct',{

      templateUrl :"./pages/QuanLiSanPham.html",
      controller : SanPhamController,
     }) 
     .when('/tin-tuc',{
      templateUrl :"./pages/tin-tuc.html",
      controller : SanPhamController,
     })
     .when('/trang-cua-toi',{
      templateUrl :"./pages/QuanLiSanPham.html",
      controller : SanPhamController,
     })
     
     .otherwise({
 
         redirectTo : '/trang-chu'

     })
});