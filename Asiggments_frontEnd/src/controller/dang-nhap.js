window.dangNhapController = function($scope,$http,$routeParams,$rootScope,$location) {
 
$scope.listUser = [];  
$rootScope.loginSuccess = false;
$rootScope.ten = "";

$http.get(userAPI).then(function(response){
  $scope.listUser = response.data;  

 
});

$scope.login = function() {
   
    for (let index = 0; index < $scope.listUser.length; index++) {
      var us = $scope.listUser[index];
        
          if($scope.email == us.email && $scope.password == us.password){              
              alert("dang nhap thanh cong")
              $rootScope.ten = us.email;
              $rootScope.loginSuccess = true;
        //window.location.href = "http://127.0.0.1:5500/src/index.html?#/trang-chu";  
             $location.path("/trang-chu");           
              return;
          }else{
              alert("thong tin username or password khong chinh xac")
              return;
          }

    }
   // https://plnkr.co/edit/tg25kr?p=preview&preview
  };

}