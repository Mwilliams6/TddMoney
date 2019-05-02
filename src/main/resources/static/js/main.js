function f()
{
    convertInput();
    addInput();
}

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

function addInput()
{
    var baseValue = document.getElementById("baseValue").value;
    var baseUnit = document.getElementById("baseUnit").value;
    var adderValue = document.getElementById("addValue").value;
    var adderUnit = document.getElementById("addUnit").value;

    if (adderValue>0.00)
    {
        $('.addValue').val(parseFloat(adderValue).toFixed(2));

        $.ajax({
            type: "GET",
            url: "addInput",
            data: {
                input:baseValue,
                unit:baseUnit,
                addInput:adderValue,
                addUnit:adderUnit
            },
            success: function (data)
            {
                $('.totalDollarValue').val('$'+data[0].toFixed(2));
                $('.totalEuroValue').val('€'+data[1].toFixed(2));
                $('.totalPoundValue').val('£'+data[2].toFixed(2));

                console.log("SUCCESS : ", data);
            },
            error: function (err) {
                $('.totalDollarValue').val('ERR');
                $('.totalEuroValue').val('ERR');
                $('.totalPoundValue').val('ERR');
            }
        });
    }


}
