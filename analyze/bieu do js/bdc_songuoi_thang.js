FusionCharts.ready(function () {    
    var revenueChart = new FusionCharts({
        type: 'mscolumn2d',
        renderAt: 'chart-container',
        width: '500',
        height: '300',
        dataFormat: 'json',
        dataSource: {
            "chart": {
                "caption": "thống kê số người tử nạn, bị thương qua các tháng",
                "subCaption": "năm 2015",
                "xAxisname": "tháng",
                "yAxisName": "số người",
                "theme": "fint"
            },
            "categories": [{
                "category": [{
                    "label": "1"
                }, {
                    "label": "2"
                }, {
                    "label": "3"
                }, {
                    "label": "4"
                },
                 {
                    "label": "5"
                },
                 {
                    "label": "6"
                },
                 {
                    "label": "7"
                },
                 {
                    "label": "8"
                },
                 {
                    "label": "9"
                },
                 {
                    "label": "10"
                },
                 {
                    "label": "11"
                },
                 {
                    "label": "12"
                },
                ]
            }],
            "dataset": [{
                "seriesname": "tử nạn",
                
                // Hide this series in the initial view
                "initiallyhidden": "1",
                
                "data": [{
                    "value": "10000"
                }, {
                    "value": "11500"
                }, {
                    "value": "12300"
                }, {
                    "value": "15200"
                },{
                    "value": "10020"
                },{
                    "value": "13000"
                },{
                    "value": "10600"
                },{
                    "value": "12000"
                },{
                    "value": "19000"
                },{
                    "value": "10000"
                },{
                    "value": "11000"
                },{
                    "value": "17000"
                }
                ]
            }, {
                "seriesname": "bị thương",
                "data": [{
                    "value": "102200"
                }, {
                    "value": "115020"
                }, {
                    "value": "123200"
                }, {
                    "value": "152200"
                },{
                    "value": "10020"
                },{
                    "value": "130200"
                },{
                    "value": "106020"
                },{
                    "value": "120002"
                },{
                    "value": "190002"
                },{
                    "value": "100200"
                },{
                    "value": "110020"
                },{
                    "value": "170002"
                }]
            }]
        }
    }).render();   
});