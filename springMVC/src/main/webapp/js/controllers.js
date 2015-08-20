'use strict';

/* Controllers */

angular.module('myApp.controllers', [])
  .controller('findByNumberCtrol', function($scope,$location,$http) {

 
	  $scope.envs = [{name:'FVT', value:'FVT'},
	                   {name:'UAT', value:'UAT'},
	                   {name:'PS', value:'PS'},
	                   {name:'PROD', value:'PROD'},	                   
	                 ];
	  $scope.env = $scope.envs[0];
	$scope.show = false;
	$scope.search= function(){
		
	console.log($scope.env)	;
	$scope.submitted =true;
	 
    $scope.isStartEmpty = true;
    $scope.isEndEmpty = true;
    if (typeof($scope.startDate) != "undefined") {
        $scope.isStartEmpty = false;
        if (typeof($scope.endDate) != "undefined") {
            $scope.isEndEmpty = false;
        } else {
            return;
        }
    } else {
        if (typeof($scope.endDate) != "undefined") {
            $scope.isEndEmpty = false;
        } else {
            return;
        }
    }
    $scope.dateErrorMsg ="";
    if ($scope.startDate > $scope.endDate){
        $scope.dateErrorMsg ="Start date Must earlier than end date!";
        return;
    }
    
    
	//	$http.get("http://www.w3schools.com/website/Customers_JSON.php")
		$http.get("http://localhost:9080/DSWDataAnalysisPlatform/usertrack.wss?env=" +$scope.env.value 
													+ "&quoteNum=" + $scope.webQuoteNumber 
													+ "&startDate=" + $scope.startDate
													+ "&endDate=" + $scope.endDate)
	//	$http.get("http://localhost:9080/DSWDataAnalysisPlatform/usertrack.wss",{userId: "liruiwh@cn.ibm.com",quoteNum: "0005011496"})
    .success(function(response) {
    	console.log(response);
	$scope.logs = response.result;
	console.log(response.result);
	//$location.path('/result')
	
	$scope.show = true;
    })
	.error(function(data,status,headers,config){
	$scope.error ="Exception when get data from Restful";
	console.log(data);
	});
		$scope.showResult = function()
		{return $scope.show;};
			
	};
	
	
	$scope.dateDuration =function($scope){
	
	console.log($scope.startDate);
	};
  });
  