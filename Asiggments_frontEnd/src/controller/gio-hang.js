
window.gioHangController = function($scope,$http,$routeParams,$rootScope,$location) {

$rootScope.dem = 0;
$scope.listGiohang = [];
$scope.form = {
    name :"",
    price :"",
    category :" ",
    img :"",
    soLuong :0
 };
$http.get(giohangAPI).then(function(response){
    $scope.listGiohang = response.data;  
    $rootScope.dem = response.data.length ;
    console.log($rootScope.dem = response.data.length)
});

$scope.remove = function(event,index) {
    event.preventDefault();
    let sp = $scope.listGiohang[index];
    let api = giohangAPI + "/" + sp.id;
    $http.delete(api).then(function(){
        $scope.listGiohang.splice(index,1);
        alert('xoa thanh cong')
     });
     };
   
  $scope.mua = function()
         {
           
        var tientra = prompt("Nhập tien cua ban:");
              if(tientra == ""){
                 alert("Please nhap tien vao")
                 return;
              }else if(tientra == $scope.total){        
                
                $scope.clearCart();
                
                return;
                  
              }
         }

         $scope.clearCart = function() {
        if($scope.listGiohang != null){
       for (let i = 0; index < $scope.listGiohang.length; i++) {
        let sp = $scope.listGiohang[i].id;      
        
};

}
            

 }

      
          


// Khai báo mảng
//$scope.myArray = [{id: 1, name: 'Obj 1'}, {id: 2, name: 'Obj 2'}, {id: 3, name: 'Obj 3'}];

// Hàm xóa tất cả đối tượng trong mảng
// //$scope.deleteAll = function() {
//   $http.delete('/api/objects').then(function(response) {
//     // Nếu xóa thành công, xóa tất cả các đối tượng trong mảng
//     $scope.myArray = [];
//   }, function(error) {
//     console.log(error);
//   });
// };


};