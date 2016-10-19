FusionCharts.ready(function () {
    var ageGroupChart = new FusionCharts({
        type: 'pie3d',
        renderAt: 'chart-container',
        width: '550',
        height: '500',
        dataFormat: 'json',
        dataSource: {
            "chart": {
                "caption": "thống kê các vụ tai nạn theo phương tiện",
                "subCaption": "năm 2015",
                "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
                "bgColor": "#ffffff",
                "showBorder": "0",
                "use3DLighting": "0",
                "showShadow": "0",
                "enableSmartLabels": "0",
                "startingAngle": "0",
                "showPercentValues": "1",
                "showPercentInTooltip": "0",
                "decimals": "1",
                "captionFontSize": "14",
                "subcaptionFontSize": "14",
                "subcaptionFontBold": "0",
                "toolTipColor": "#ffffff",
                "toolTipBorderThickness": "0",
                "toolTipBgColor": "#000000",
                "toolTipBgAlpha": "80",
                "toolTipBorderRadius": "2",
                "toolTipPadding": "5",
                "showHoverEffect":"1",
                "showLegend": "1",
                "legendBgColor": "#ffffff",
                "legendBorderAlpha": '0',
                "legendShadow": '0',
                "legendItemFontSize": '10',
                "legendItemFontColor": '#666666'
            },
            "data": [
                {
                    "label": "ô tô",
                    "value": "1000"
                }, 
                {
                    "label": "xe máy",
                    "value": "2000"
                }, 
                {
                    "label": "phương tiện khác",
                    "value": "3000"
                }
            ]
        }
    }).render();
});