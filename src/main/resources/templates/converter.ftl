<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Currency Converter</title>
    <link href="/css/main.css" rel="stylesheet">
    <script src="/js/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script>
        function convertInput()
        {

            var x = document.getElementById("baseValue").value;
            var y = document.getElementById("baseUnit").value;

            $('.baseValue').val(parseFloat(x).toFixed(2));

            $.ajax({
                type: "GET",
                url: "convertInput",
                data: {
                    input:x,
                    unit:y
                },
                success: function (data)
                {
                    $('.dollarValue').val('$'+data[0].toFixed(2));
                    $('.euroValue').val('€'+data[1].toFixed(2));
                    $('.poundValue').val('£'+data[2].toFixed(2));

                    console.log("SUCCESS : ", data);
                },
                error: function (err) {
                    $('.dollarValue').val('ERR');
                    $('.euroValue').val('ERR');
                    $('.poundValue').val('ERR');
                }
            });
        }
    </script>
</head>
<body>
    <div id="container">
        <h2>Currency Converter</h2>

        <div id="table-data">
            <input class="baseValue" id="baseValue" type="number" min=0 step=0.01 onchange="convertInput()">
            <select id="baseUnit" onchange="convertInput()">
                <option value="Dollar">(USD) Dollars</option>
                <option value="Euro">(EUR) Euros</option>
                <option value="Pound" default>(GBP) Pounds</option>
            </select>

            <table id="resultTable">
                <tr>
                    <td>(USD) Dollars</td>
                    <td>(EUR) Euros</td>
                    <td>(GBP) Pounds</td>
                </tr>
                <tr>
                    <td><input class="dollarValue" type="text" disabled/></td>
                    <td><input class="euroValue" type="text" disabled/></td>
                    <td><input class="poundValue" type="text" disabled/></td>
                </tr>
            </table>
        </div>

        <br/>

        <div id="table-data">
            <input class="baseValue" id="baseValue" type="number" min=0 step=0.01 onchange="convertInput()">
            <select id="baseUnit" onchange="convertInput()">
                <option value="Dollar">(USD) Dollars</option>
                <option value="Euro">(EUR) Euros</option>
                <option value="Pound" default>(GBP) Pounds</option>
            </select>

            <table id="resultTable">
                <tr>
                    <td>(USD) Dollars</td>
                    <td>(EUR) Euros</td>
                    <td>(GBP) Pounds</td>
                </tr>
                <tr>
                    <td><input class="dollarValue" type="text" disabled/></td>
                    <td><input class="euroValue" type="text" disabled/></td>
                    <td><input class="poundValue" type="text" disabled/></td>
                </tr>
            </table>
        </div>
    </div>




</body>
</html>