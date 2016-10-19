 FusionCharts.ready(function(){
 var revenueChart = new FusionCharts({
        "type": "column2d",
        "renderAt": "chart-container",
        "width": "500",
        "height": "300",
        "dataFormat": "json",
        "dataSource":  {
          "chart": {
            "caption": "thống kê số vụ tai nạn theo phuong tien",
            "subCaption": "năm 2015",
            "xAxisName": "loại phương tiện",
            "yAxisName": "số vụ",
            "theme": "fint"
         },
         "data": [
            {
               "label": "ô tô",
               "value": "3000"
            },
            {
               "label": "xe máy",
               "value": "4000"
            },
            {
               "label": "loại khác",
               "value": "720"
            }
          ]
      }

  });
revenueChart.render();
})