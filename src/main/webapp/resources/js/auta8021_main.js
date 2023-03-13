$(document).ready(function () {
    var options = { year: 'numeric', month: 'long', day: 'numeric' };
    var today = new Date();
    var listValueOP = $('.iop');
    var listValueNewQty = $('.newQty');
    var flag = true;
    var flagOP = true;
    var listManufacturerPartNumber = $('.manufacturerPartNumber');
    var list車種 = $('.車種');
    var listメーカー = $('.メーカー');
    var listSS = $('.SS');
    var list搬入場所 = $('.搬入場所')

    $('#now').text(today.toLocaleDateString("ja-JP", options));

    $(".iop").change(function () {
        flagOP = true
        let cd = $(this).parents("tr").find("input[name='cdnewQty']").val();
        if (cd != "C" && cd != "D") {
            flagOP = false
            $('#mess-errorOP').html('Err [S3M0030E]: 正しいＯＰを入力してください。')
        } else {
            for (var i = 0; i < listValueOP.length; i++) {
                if ($(listValueOP[i]).val() != 'C' &&
                    $(listValueOP[i]).val() != 'D' && $(listValueOP[i]).val() != '') {
                    flagOP = false
                }
            }
            if (flagOP == true) {
                $('#mess-errorOP').html('')
            }
        }
    })

    $(".メーカー").change(function () {
        row = $(this).parents("tr").find("input[name='メーカー']").val();
        if (row == "KI") {
            $(this).parents("tr").find("input[name='メーカー名']").val("KIA");
        }
        if (row == "TO") {
            $(this).parents("tr").find("input[name='メーカー名']").val("Toyota");
        }
        if (row == "FO") {
            $(this).parents("tr").find("input[name='メーカー名']").val("Ford");
        }
    })

    $(".SS").change(function () {
        row = $(this).parents("tr").find("input[name='SS']").val();
        if (row == "C") {
            $(this).parents("tr").find("input[name='SS名']").val("CMA");
        }
        if (row == "M") {
            $(this).parents("tr").find("input[name='SS名']").val("Maersk");
        }
        if (row == "D") {
            $(this).parents("tr").find("input[name='SS名']").val("Cosco");
        }
    })

    $(".btn参照").click(function (e) {
        e.preventDefault();
        flag = true
        row = $(this).parents("tr").find("input[name='newQty']").val();
        if (row != "T" && row != "F") {
            $(this).parents("tr").find("input[name='oldQty']").val("");
            $('#mess-error404').html('Err [S3M0003E]：該当するデータが存在しません。')
        } else {
            if (row == "T") {
                $(this).parents("tr").find("input[name='oldQty']").val("Texas");
            }
            if (row == "F") {
                $(this).parents("tr").find("input[name='oldQty']").val("Florida");
            }
            for (let x = 0; x < listValueNewQty.length; x++) {
                if ($(listValueNewQty[x]).val() != 'T' &&
                    $(listValueNewQty[x]).val() != 'F') {
                    flag = false;
                }
            }
            if (flag == true) {
                $('#mess-error404').html('')
            }
        }
    })

    var flagError出荷デポempty = true;
    var flagError出荷デポlength = true;
    var flagErrorManufacturerPartNumberLenght = true;
    var flagErrorManufacturerPartNumberNotExist = true;
    var flagError車種Lenght = true;
    var flagError出荷デポNotExist = true;
    var flagError4メS搬車 = true;

    $("#btnU更新").click(function (e) {
        flagError出荷デポempty = true;
        flagError出荷デポlength = true;
        flagError出荷デポNotExist = true;
        flag404 = true;
        flagErrorManufacturerPartNumberLenght = true;
        flagErrorManufacturerPartNumberNotExist = true;
        flagError車種Lenght = true;
        flagError4メS搬車 = true;

        let listValueNewQtyLength = listValueNewQty.length;
        let listManufacturerPartNumberLength = listManufacturerPartNumber.length;
        let list車種Lenght = list車種.length;
        let listメーカーLenght = listメーカー.length;
        let listSSLenght = listSS.length;
        let list搬入場所Lenght = list搬入場所.length;

        for (let a = 1; a <= listメーカーLenght; a++) {
            if ($(listメーカー[a - 1]).val() != 'KI' && $(listメーカー[a - 1]).val() != 'FO' && $(listメーカー[a - 1]).val() != 'TO') {
                flagError4メS搬車 = false;
                $('#mess-error4メS搬車').html('Er [S3M0022E]: ' + a + ' 行目の入力された受注デポ変換情報は存在しません。 ')
                break
            }
        }

        if (flagError4メS搬車 == true) {
            for (let a = 1; a <= listSSLenght; a++) {
                if ($(listSS[a - 1]).val() != 'C' && $(listSS[a - 1]).val() != 'M' && $(listSS[a - 1]).val() != 'D') {
                    flagError4メS搬車 = false;
                    $('#mess-error4メS搬車').html('Er [S3M0022E]: ' + a + ' 行目の入力された受注デポ変換情報は存在しません。')
                    break
                }
            }
        }

        if (flagError4メS搬車 == true) {
            for (let a = 1; a <= list搬入場所Lenght; a++) {
                if ($(list搬入場所[a - 1]).val() != 'Yokohama' && $(list搬入場所[a - 1]).val() != 'Jakarta' && $(list搬入場所[a - 1]).val() != 'Dehli') {
                    flagError4メS搬車 = false;
                    $('#mess-error4メS搬車').html('Er [S3M0022E]: ' + a + ' 行目の入力された受注デポ変換情報は存在しません。 ')
                    break
                }
            }
        }

        if (flagError4メS搬車 == true) {
            for (let a = 1; a <= list車種Lenght; a++) {
                if ($(list車種[a - 1]).val() != 'A' && $(list車種[a - 1]).val() != 'B') {
                    flagError4メS搬車 = false;
                    $('#mess-error4メS搬車').html('Er [S3M0022E]: ' + a + ' 行目の入力された受注デポ変換情報は存在しません。 ')
                    break
                }
            }
        }

        for (let x = 1; x <= listValueNewQtyLength; x++) {
            if ($(listValueNewQty[x - 1]).val() == "") {
                flagError出荷デポempty = false;
                $('#mess-error出荷デポempty').html('Er [S3M0011E]: ' + x + ' 行目の出荷デポを入力してください。')
                break
            }
            if ($(listValueNewQty[x - 1]).val().length > 2) {
                flagError出荷デポlength = false;
                $('#mess-error出荷デポlenght').html('Er [S3M0015E]: ' + x + ' 行目の出荷デポは半角文字数を入力してください。')
                break
            }
            if ($(listValueNewQty[x - 1]).val() != 'T' &&
                $(listValueNewQty[x - 1]).val() != 'F') {
                flagError出荷デポNotExist = false;
                $('#mess-error出荷デポNotExist').html('Err [S3M0021E]: ' + x + ' 行目の出荷デポはＦＯＰ関連・加工／購入／委託業者情報に存在しません。')
                break
            }

        }

        for (let j = 1; j <= listManufacturerPartNumberLength; j++) {
            if ($(listManufacturerPartNumber[j - 1]).val().length > 18) {
                flagErrorManufacturerPartNumberLenght = false;
                $('#mess-errorManufacturerPartNumberLenght').html('[S3M0015E]: ' + j + ' 行目のメーカ品番は半角文字数を入力してください。')
                break
            }
        }

        if (flagErrorManufacturerPartNumberLenght == true) {
            for (let a = 1; a <= listManufacturerPartNumberLength; a++) {
                if ($(listManufacturerPartNumber[a - 1]).val() != 'A1111' && $(listManufacturerPartNumber[a - 1]).val() != 'B2222' && $(listManufacturerPartNumber[a - 1]).val() != 'C3333') {
                    flagErrorManufacturerPartNumberNotExist = false;
                    $('#mess-errorManufacturerPartNumberNotExist').html('Er [S3M0021E]: ' + a + ' 行目のメーカ品番は 品目変換マスターに存在しません。')
                    break
                }
            }
        }

        for (let z = 1; z <= list車種Lenght; z++) {
            if ($(list車種[z - 1]).val().length > 1) {
                flagError車種Lenght = false;
                $('#mess-errorError車種Lenght').html('[S3M0015E]: ' + z + ' 行目の車種は半角文字数を入力してください。')
                break
            }
        }

        if (flag404 == true) {
            $('#mess-error404').html('')
        }
        if (flagError出荷デポempty == true) {
            $('#mess-error出荷デポempty').html('')
        }
        if (flagError出荷デポlength == true) {
            $('#mess-error出荷デポlenght').html('')
        }
        if (flagErrorManufacturerPartNumberLenght == true) {
            $('#mess-errorManufacturerPartNumberLenght').html('')
        }
        if (flagErrorManufacturerPartNumberNotExist == true) {
            $('#mess-errorManufacturerPartNumberNotExist').html('')
        }
        if (flagError車種Lenght == true) {
            $('#mess-errorError車種Lenght').html('')
        }
        if (flagError出荷デポNotExist == true) {
            $('#mess-error出荷デポNotExist').html('')
        }
        if (flagError4メS搬車 == true) {
            $('#mess-error4メS搬車').html('')
        }
        if (flagError出荷デポempty == true && flagError出荷デポlength == true && flagError出荷デポNotExist == true && flagOP == true && flag404 == true && flagErrorManufacturerPartNumberLenght == true && flagErrorManufacturerPartNumberNotExist == true && flagError車種Lenght == true && flagError4メS搬車 == true) {
            if (confirm("Are you sure?") == true) {
                 $("#tableUpdate").submit();
            }
        }
        e.preventDefault();
    });
});