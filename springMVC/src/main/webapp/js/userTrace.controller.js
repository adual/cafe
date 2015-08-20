 
 
 function findByNumberCtrol($scope,$location,$http){
	 $scope.showResult =false;
	$scope.search= function(){
	//$scope.submitted =true;
		//console.log($scope.webQuoteNumber);
			
	//	$http.get("http://www.w3schools.com/website/Customers_JSON.php")
		$http.get("/DSWDataAnalysisPlatform/usertrack.wss?userId="+$scope.userId+"&quoteNum=" +$scope.webQuoteNumber+"&startDate="+$scope.startDate+"&endDate="+$scope.endDate)
	//	$http.get("http://localhost:9080/DSWDataAnalysisPlatform/usertrack.wss",{userId: "liruiwh@cn.ibm.com",quoteNum: "0005011496"})
    .success(function(response) {
	
	$scope.logs = response.result;
	$scope.showResult =true;
	$scope.showLog = function(){
		return $scope.showResult;
	};
	console.log($scope.showResult);
	
	})
	.error(function(data,status,headers,config){
	$scope.error ="Exception when get data from Restful";
	console.log(data);
	});
		
	};
}



function searchTypeCtrol($scope){
$scope.byQuoteNum =false;
$scope.byUserId =false;
$scope.searchType =function(n){};
  
};


function showResultCtrol($scope){}