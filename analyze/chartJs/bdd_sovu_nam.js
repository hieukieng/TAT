FusionCharts.ready(function () {
    var visitChart = new FusionCharts({
        type: 'zoomline',
        renderAt: 'chart-container',
        width: '600',
        height: '400',
        dataFormat: 'json',
        dataSource: {
            "chart": {
                "caption": "số vụ tai nạn theo từng năm",
                "subcaption": "2015-2017",
                "yaxisname": "số vụ",
                "xaxisname": "năm",
                "yaxisminValue": "800",                
                "lineThickness": "1",
                "compactdatamode" : "1",
                "dataseparator" : "|",                
                //Pixel per point
                "pixelsPerPoint": "40",
                "theme": "fint"
            },
            "categories": [
                {
                    "category":  "năm 2015|năm 2016|năm 2017"
                }
            ],
            "dataset": [
                {
                    "data": "10000|5000|30000"
                    
                }
            ]
        }
    });
    visitChart.render();
});