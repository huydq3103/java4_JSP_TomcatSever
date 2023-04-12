window.SanPhamController = function($scope,$http,$routeParams,$rootScope,$location) {

$scope.listSanPhamBanChay = [];
$scope.listSP = [];
$scope.listGiohang = [];
$scope.listUser = [];

$scope.form = {
   name :"",
   price :"",
   category :" ",
   img :"",
   soLuong :12
};
$scope.form2 = {
    name :"",
 };
$scope.listCategory = [];
$scope.viTri =-1; // vi chua chon phan tu de update

// phan trang



  // get id sp 

  $scope.getID = $routeParams.id;
// add product theo id

$scope.addCart = function(soLuong) {

  angular.forEach($scope.listSP, function (value) {
        if(value.id == $scope.getID){
           $http.post(giohangAPI,value).then(function (response) {
                $scope.listGiohang.push(response.data);
           });
        }
});
   

   $http.patch(giohangAPI +'/' +$scope.getID, { soLuong: soLuong })
     .then(function(response) {
        $scope.listGiohang.push(response.data);
     }, function(error) {
       // Xử lý lỗi khi cập nhật số lượng sản phẩm
       console.log(error);
     });
 
     
}



//get data sp ban chay + new


$http.get(sanPhamAPI).then(function(response){
   $scope.listSP = response.data;     
});

$http.get(categoryAPI).then(function(response){

   $scope.listCategory = response.data;     
});

$http.get(giohangAPI).then(function(response){
   $scope.listGiohang = response.data;  
 
  
});

$http.get(userAPI).then(function(response){
  $scope.listUser = response.data;  

 
});


 


 // add product


   
$scope.addProduct = function(event){
  event.preventDefault();

  console.log($scope.form.category)
 
 $http.post(sanPhamAPI,$scope.form).then(function(response){

  $scope.listSP.push(response.data);

});
      
}
// add category

$scope.add = function(event){
    $http.post(categoryAPI,$scope.form2).then(function(response){

       $scope.listCategory.push(response.data);

    });
}




// remove 
$scope.xoaProduct = function(event,index) {
event.preventDefault();
let sp = $scope.listSP[index];
 let api = sanPhamAPI + "/" + sp.id;
$http.delete(api).then(function(){
    $scope.listSP.splice(index,1);
    alert('xoa thanh cong')
 });
 };
 // remove category

$scope.xoa = function(event,index) {
    event.preventDefault();
    let loai = $scope.listCategory[index];
    let api = categoryAPI + "/" + loai.id;
    $http.delete(api).then(function(){
        $scope.listCategory.splice(index,1);
        alert('xoa thanh cong')
     });
     };
 
 // details category
  $scope.detailss = function(event,index){
    event.preventDefault();
    let loai = $scope.listCategory[index];  
        $scope.form2.name = loai.name;   
        $scope.viTri = index;       
        console.log(loai.name)
    
  }
   // details 
   $scope.details = function(event,index){
    event.preventDefault();
        let sp = $scope.listSP[index]; // lay sv o vi tri index  
        $scope.form.name = sp.name;
        $scope.form.price = sp.price;
        $scope.form.category = sp.category;
        $scope.form.img = sp.img;
        $scope.viTri = index;       
        console.log(index)
    
  }
 
  // update 
  $scope.updateProduct = function (event) {
    event.preventDefault();

 let sp = $scope.listSP[$scope.viTri];
 let api = sanPhamAPI + "/" + sp.id;

    $http.put(api,$scope.form).then(function (response) {
      $scope.listSP[$scope.viTri] = response.data;
    });
  };

   // update category
   $scope.updates = function (event) {
    event.preventDefault();

 let loai = $scope.listCategory[$scope.viTri];
 let api = categoryAPI + "/" + loai.id;

    $http.put(api,$scope.form2).then(function (response) {
      $scope.listCategory[$scope.viTri] = response.data;
    });
  };


  $scope.getCategory = function (index) {
      $scope.search = "loai"+" " +(index + 1);      
  }

  $scope.clearALL = function () {
   $scope.search = "";
    
  }
//  $scope.tableParams = new NgTableParams({}, { dataset: $scope.data});
// so luong procduct trong gio hang

//xoa gio hang



   $scope.submit = function(){

   
   for (let index = 0; index < $scope.listUser.length; index++) {
    const value = $scope.listUser[index];
     if(value.email === $scope.email){
      alert("Mat khau cua ban la :"+ value.password) 
      return;
   }else{
        alert("Sai thong tin tai khoan")
        return;
     }
   }     
   
     

 
  }

$scope.request = {

  email : "",
  password :"",
  id :""

}  

$scope.Register = function(){
     if($scope.request.email==""){
      alert("vui long nhap tai khoan")
          return false;
     }

     if($scope.request.password==""){
      alert("vui long nhap password")
        return false;

     }
     if($scope.request.password.length >10){
      alert("vui long nhap  password khong duoc qua 10")
      return false;
        
     }

     $http.post(userAPI,$scope.request).then(function(response){
      if($scope.listUser.push(response.data)){
          alert("dang ki thanh cong")
          return;
      }else{
       alert("dang ki that bai")
       return;
      }

  });
} 


// //  $scope.login = function() {
   
//     for (let index = 0; index < $scope.listUser.length; index++) {
//       var us = $scope.listUser[index];
        
//           if($scope.email == us.email && $scope.password == us.password){              
//               alert("dang nhap thanh cong")
//               $rootScope.ten = us.email;
            
//         //window.location.href = "http://127.0.0.1:5500/src/index.html?#/trang-chu";  
//              $location.path("/lien-he");           
//               return;
//           }else{
//               alert("thong tin username or password khong chinh xac")
//               return;
//           }

//     }
       
//   //};
 
 

};