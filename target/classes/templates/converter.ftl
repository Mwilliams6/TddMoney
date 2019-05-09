<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Currency Converter</title>
    <link href="css/main.css" rel="stylesheet">
    <script src="js/main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
    <div id="currencyTable">
        <h4>${baseCurrency} conversion rate</h4>
        <p>as of ${dateOfRetrieval}</p>
        <#list quotes as key, value>
            <p>${key} - ${value}</p>
        </#list>
    </div>

    <div id="container">
        <h2>Currency Converter</h2>

        <div id="table-data" class="convert">
            <input class="baseValue" id="baseValue" type="number" min=0 step=0.01 onchange="convertChosenInput()" value="0.00">
            <select id="baseUnit" onchange="convertChosenInput()">
                <#list quotes as key, value>
                    <option value="${key}">${key}</option>
                </#list>
            </select>

        </div>
        <div class="spacerArrow">

        </div>
        <div id="table-data" class="convert">
            <select id="destUnit" onchange="convertChosenInput()">
                <#list quotes as key, value>
                    <option value="${key}">${key}</option>
                </#list>
            </select>
            <input class="resultValue" type="text" disabled/>
        </div>
        <br/>
        <br/>
        <div id="table-data" class="adding">
            <input class="addValue" id="addValue" type="number" min=0 step=0.01 onchange="f()" value="0.00">
            <select id="addUnit" onchange="f()">
                <option value="Dollar">(USD) Dollars</option>
                <option value="Euro">(EUR) Euros</option>
                <option value="Pound" default>(GBP) Pounds</option>
            </select>

            <table class="resultTable">
                <tr>
                    <td>(USD) Dollars</td>
                    <td>(EUR) Euros</td>
                    <td>(GBP) Pounds</td>
                </tr>
                <tr>
                    <td><input class="totalDollarValue" type="text" disabled/></td>
                    <td><input class="totalEuroValue" type="text" disabled/></td>
                    <td><input class="totalPoundValue" type="text" disabled/></td>
                </tr>
            </table>
        </div>
    </div>





</body>
</html>