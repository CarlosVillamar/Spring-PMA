var chartDataString = decodeHTML(barChartData);
var chartJsonArr = JSON.parse(chartDataString);

var numData =[]
var nameData =[]

for(var i =0; i< arrLength; i++){
	numData[i] = chartJsonArr[i].projectCount;
	nameData[i] = chartJsonArr[i].firstName;
}

new Chart(document.getElementById('myBarChart'), {
    type: 'bar',
    data: {	
    	labels: nameData,
        datasets: [{
        	label: 'number of projects per employee',
        	backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            barPercentage: 0.5,
            barThickness: 6,
            maxBarThickness: 8,
            minBarLength: 2,
            data: numData,
        }]
    },
    options: {
    	title:{
    		display: true,
    		text: 'project statuses'
    	},
    	    scales: {
    	        xAxes: [{
    	            gridLines: {
    	                offsetGridLines: true
    	            }
    	        }]
    	    }
    	}
});

function decodeHTML(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}