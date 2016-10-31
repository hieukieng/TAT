 FusionCharts.ready(function(){
 var revenueChart = new FusionCharts({
        "type": "column2d",
        "renderAt": "chart-container",
        "width": "500",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "thống kê số vụ tai nạn theo tháng",
            "subCaption": "năm 2015",
            "xAxisName": "tháng",
            "yAxisName": "số vụ",
            "theme": "fint"
         },
         "data": [
            {
               "label": "1",
               "value": "4200"
            },
            {
               "label": "2",
               "value": "810"
            },
            {
               "label": "3",
               "value": "720"
            },
            {
               "label": "4",
               "value": "550"
            },
            {
               "label": "5",
               "value": "910"
            },
            {
               "label": "6",
               "value": "510"
            },
            {
               "label": "7",
               "value": "680"
            },
            {
               "label": "8",
               "value": "620"
            },
            {
               "label": "9",
               "value": "610"
            },
            {
               "label": "10",
               "value": "490"
            },
            {
               "label": "11",
               "value": "900"
            },
            {
               "label": "12",
               "value": "730"
            }
          ]
      }

  });
revenueChart.render();
})