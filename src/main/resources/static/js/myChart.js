var chartDataString = decodeHTML(chartData);
var chartJsonArr = JSON.parse(chartDataString);

var arrLength = chartJsonArr.length;

var numericData =[]
var labelData =[]

for(var i =0; i< arrLength; i++){
	numericData[i] = chartJsonArr[i].projectCount;
	labelData[i] = chartJsonArr[i].project;
}

//for pie chart
new Chart(document.getElementById('myPieChart'), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },
    
    options: {
    	title:{
    		display: true,
    		text: 'project statuses'
    	}
    }
});

function decodeHTML(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}
	
	