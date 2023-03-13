<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AUTA821</title>
<link rel="stylesheet" href="./resources/css/auta821_main.css">
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<link rel="stylesheet"
    href="https://pro.fontawesome.com/releases/v5.15.4/css/all.css" />
<script src="https://code.jquery.com/jquery-3.6.1.js"
    integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
    crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="d-flex p-3 mb-3 justify-content-between top-content">
            <div>
                <h1>
                    <a href="./index">AUTA821</a>
                </h1>
            </div>
            <div>
                <h1>新ﾃﾞﾎﾟ変換マスター更新</h1>
            </div>
            <div>
                <h1 id="now"></h1>
            </div>
        </div>
        <form action="search" method="GET">
            <div class="d-flex row mb-1">
                <div class="text-danger error flex-column-reverse mb-3 ">
                    <p><<< エラーメッセージ>>></p>
                    <p id="mess-errorOP"></p>
                    <p id="mess-error404"></p>
                    <p class="text-danger">${err}</p>
                    <p id="mess-error出荷デポempty"></p>
                    <p id="mess-error出荷デポlenght"></p>
                    <p id="mess-error出荷デポNotExist"></p>
                    <p id="mess-errorManufacturerPartNumberLenght"></p>
                    <p id="mess-errorManufacturerPartNumberNotExist"></p>
                    <p id="mess-errorError車種Lenght"></p>
                    <p id="mess-error4メS搬車"></p>
                    <c:if test="${countC > 0}">
                        <p class="text-success">${success}</p>
                    </c:if>
                    <c:if test="${countD > 0}">
                        <p class="text-success">${successD}</p>
                    </c:if>
                </div>
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control me-4">
                        <p class="psearch11">メーカー</p>
                        <c:choose>
                            <c:when test="${メーカー == 'KI' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option selected value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'TO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option selected value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'FO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option selected value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="">
                            </c:when>
                            <c:otherwise>
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control me-2 ms-2">
                        <p class="psearch11">ﾒｰｶｰ品番</p>
                        <input maxlength="18" class="form-control" type="text"
                            name="manufacturerPartNumber" value="${manufacturerPartNumber}">
                        <input type="hidden" maxlength="18" class="form-control"
                            type="text" name="stt" value="${stt}">
                    </div>
                </div>
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control ms-4">
                        <p class="psearch11">SS</p>
                        <input maxlength="1" class="form-control" type="text" name="SS"
                            value="${SS}">
                    </div>
                </div>
            </div>
            <div class="d-flex row">
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control me-4">
                        <p class="psearch11">搬入場所</p>
                        <input maxlength="8" class="form-control edelete" type="text"
                            name="搬入場所" value="${搬入場所}">
                    </div>
                </div>
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control me-2 ms-2">
                        <p class="psearch11">出荷デポ</p>
                        <input id="inputS出荷デポ" maxlength="2" class="form-control i出荷デポ "
                            type="text" name="出荷デポ" value="${出荷デポ}">
                        <p class="p参照 psearch11">参照</p>
                        <input maxlength="20" class="form-control" readonly>
                    </div>
                </div>
                <div class="d-flex col-sm-12 col-md-12 col-lg-4">
                    <div class="d-flex form-control ms-4">
                        <p class="psearch11">車種</p>
                        <input maxlength="1" class="form-control " type="text" name="車種"
                            value="${車種}">
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-end threebutton">
                <button id="btnS" class="btn 検索 mt-3 me-3">検索 (S)</button>
                <a id="btnC" class="btn 検索 mt-3 me-3" href="index">キャンセル (C)</a> <a
                    class="btn 検索 mt-3" href="./dangkimoi">新規登録 (N)</a>
            </div>
        </form>
        <c:if test="${totalPages != 0}">
            <div class="paging mt-3 pb-1 pt-1 d-flex align-items-center">
                <input id="totalpage" type="hidden" readonly value="${totalPages}">
                <span>${currentPage}</span>/ <span class="me-2">${totalPages}
                    ページ</span>
                <c:if test="${totalPages == 1}">
                    <a id="btn-left" class="btn disabled me-2 ps-2 pe-2"
                        href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage-1}&pagesize=${pagesize}"><i
                        class="far fa-arrow-square-left"></i></a>
                    <a id="btn-right" class="btn disabled me-2 ps-2 pe-2"
                        href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage+1}&pagesize=${pagesize}"><i
                        class="far fa-arrow-square-right"></i></a>
                </c:if>
                <c:if test="${totalPages > 1}">
                    <c:choose>
                        <c:when test="${currentPage == 1}">
                            <a id="btn-left" class="btn disabled me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage-1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-left"></i></a>
                            <a id="btn-right" class="btn 表示 me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage+1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-right"></i></a>
                        </c:when>
                        <c:when test="${currentPage == totalPages}">
                            <a id="btn-left" class="btn 表示 me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage-1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-left"></i></a>
                            <a id="btn-right" class="btn disabled me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage+1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-right"></i></a>
                        </c:when>
                        <c:otherwise>
                            <a id="btn-left" class="btn 表示 me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage-1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-left"></i></a>
                            <a id="btn-right" class="btn 表示 me-2 ps-2 pe-2"
                                href="search?メーカー=${メーカー}&manufacturerPartNumber=${manufacturerPartNumber}&SS=${SS}&搬入場所=${搬入場所}&出荷デポ=${出荷デポ}&車種=${車種}&currentPage=${currentPage+1}&pagesize=${pagesize}"><i
                                class="far fa-arrow-square-right"></i></a>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                <span class="me-2">ページ</span>
                <form class="d-flex" action="search" method="POST">
                    <div style="display: none;" class=" form-control">
                        <p class="psearch11">メーカー</p>
                        <c:choose>
                            <c:when test="${メーカー == 'KI' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option selected value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'TO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option selected value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'FO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option selected value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="">
                            </c:when>
                            <c:otherwise>
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                        <input maxlength="18" class="form-control" type="text"
                            name="manufacturerPartNumber" value="${manufacturerPartNumber}">
                        <input maxlength="1" class="form-control" type="text" name="SS"
                            value="${SS}"> <input maxlength="8"
                            class="form-control edelete" type="text" name="搬入場所"
                            value="${搬入場所}"> <input id="inputS出荷デポ" maxlength="2"
                            class="form-control i出荷デポ " type="text" name="出荷デポ"
                            value="${出荷デポ}"> <input maxlength="1"
                            class="form-control " type="text" name="車種" value="${車種}">
                        <input type="hidden" maxlength="18" class="form-control"
                            type="text" name="stt" value="${stt}">
                        <c:if test="${pagesize != 10}">
                            <select name="pagesize" id="value-totalpage">
                                <option selected="selected" value="5">5</option>
                                <option value="10">10</option>
                            </select>
                        </c:if>
                        <c:if test="${pagesize == 10}">
                            <select name="pagesize" id="value-totalpage">
                                <option value="5">5</option>
                                <option selected="selected" value="10">10</option>
                            </select>
                        </c:if>
                    </div>
                    <input name="currentPage" id="value-currentpage" type="number"
                        value="${currentPage}">
                    <button id="btn-currentpage" class="表示 me-2 ps-1 pe-1">表示</button>
                </form>
                <form action="search" method="POST">
                    <div style="display: none;" class=" form-control">
                        <p class="psearch11">メーカー</p>
                        <c:choose>
                            <c:when test="${メーカー == 'KI' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option selected value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'TO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option selected value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="${メーカー == 'FO' }">
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option selected value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:when>
                            <c:when test="">
                            </c:when>
                            <c:otherwise>
                                <select class="form-control" name="メーカー" id="">
                                    <option value="">Choose</option>
                                    <option value="KI">KI</option>
                                    <option value="FO">FO</option>
                                    <option value="TO">TO</option>
                                </select>
                            </c:otherwise>
                        </c:choose>
                        <input maxlength="18" class="form-control" type="text"
                            name="manufacturerPartNumber" value="${manufacturerPartNumber}">
                        <input maxlength="1" class="form-control" type="text" name="SS"
                            value="${SS}"> <input maxlength="8"
                            class="form-control edelete" type="text" name="搬入場所"
                            value="${搬入場所}"> <input id="inputS出荷デポ" maxlength="2"
                            class="form-control i出荷デポ " type="text" name="出荷デポ"
                            value="${出荷デポ}"> <input maxlength="1"
                            class="form-control " type="text" name="車種" value="${車種}">
                        <input type="hidden" maxlength="18" class="form-control"
                            type="text" name="stt" value="${stt}">
                    </div>
                    <span class="me-2">表 示 件数</span>
                    <c:if test="${pagesize != 10  }">
                        <select name="pagesize" id="value-totalpage">
                            <option selected="selected" value="5">5</option>
                            <option value="10">10</option>
                        </select>
                    </c:if>
                    <c:if test="${pagesize == 10  }">
                        <select name="pagesize" id="value-totalpage">
                            <option value="5">5</option>
                            <option selected="selected" value="10">10</option>
                        </select>
                    </c:if>
                    <button id="btn-totalpage" class="表示 ps-1 pe-1">表示</button>
                </form>
            </div>
            <div>
                <form id="tableUpdate" action="update" method="POST">
                    <table class="table table-striped">
                        <tr>
                            <th></th>
                            <th>OP</th>
                            <th>メーカー</th>
                            <th>メーカー名</th>
                            <th>SS</th>
                            <th>S S 名</th>
                            <th>搬入場所</th>
                            <th colspan="3">出荷デポ <span class="text-danger">(*)</span></th>
                            <th>出荷デポ名</th>
                            <th>メーカ品番</th>
                            <th>車種</th>
                        </tr>
                        <c:forEach var="c" items="${carList}" varStatus="loop">
                            <tr>
                                <td class="参照">${loop.count}</td>
                                <td class="op"><input class="iop cdnewQty" type="text"
                                    name="cdnewQty"> <input type="hidden" name="stt"
                                    value="${c.stt}"></td>
                                <td><input class="input-update メーカー" type="text"
                                    value="${c.メーカー}" name="メーカー"></td>
                                <td><input readonly class="form-control メーカー名 " type="text"
                                    name="メーカー名" value="${c.メーカー名}"></td>
                                <td><input class="input-update SS" type="text" name="SS"
                                    value="${c.SS}"></td>
                                <td><input readonly class="form-control SS名 " type="text"
                                    name="SS名" value="${c.SS名}"></td>
                                <td><input class="input-update 搬入場所" type="text"
                                    name="搬入場所" value="${c.搬入場所}"></td>
                                <td class="出荷デポ"><input class="i出荷デポ form-control newQty"
                                    type="text" value="${c.出荷デポ}" name="newQty"></td>
                                <td></td>
                                <td class="参照"><button class="btn参照 ">参照</button></td>
                                <td><input class="form-control oldQty" type="text"
                                    name="oldQty" value="${c.出荷デポ名}" readonly></td>
                                <td><input class="input-update manufacturerPartNumber"
                                    type="text" name="manufacturerPartNumber"
                                    value="${c.manufacturerPartNumber}"></td>
                                <td><input class="input-update 車種" type="text"
                                    value="${c.車種}" name="車種"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <button id="btnU更新" class="btn 検索 me-3">更新 (U)</button>
                </form>
                <div class="d-flex mb-5 justify-content-end threebutton">
                    <form class="d-flex" action="search" method="GET">
                        <div style="display: none;" class=" form-control">
                            <p class="psearch11">メーカー</p>
                            <c:choose>
                                <c:when test="${メーカー == 'KI' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option selected value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="${メーカー == 'TO' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option selected value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="${メーカー == 'FO' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option selected value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="">
                                </c:when>
                                <c:otherwise>
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                            <input maxlength="18" class="form-control" type="text"
                                name="manufacturerPartNumber" value="${manufacturerPartNumber}">
                            <input maxlength="1" class="form-control" type="text" name="SS"
                                value="${SS}"> <input maxlength="8"
                                class="form-control edelete" type="text" name="搬入場所"
                                value="${搬入場所}"> <input id="inputS出荷デポ" maxlength="2"
                                class="form-control i出荷デポ " type="text" name="出荷デポ"
                                value="${出荷デポ}"> <input maxlength="1"
                                class="form-control " type="text" name="車種" value="${車種}">
                            <input type="hidden" maxlength="18" class="form-control"
                                type="text" name="stt" value="${stt}">
                        </div>
                        <button class="btn 検索 me-3 ">クリアー (R)</button>
                    </form>
                    <form class="d-flex" action="export" method="GET">
                        <div style="display: none;" class=" form-control">
                            <p class="psearch11">メーカー</p>
                            <c:choose>
                                <c:when test="${メーカー == 'KI' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option selected value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="${メーカー == 'TO' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option selected value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="${メーカー == 'FO' }">
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option selected value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:when>
                                <c:when test="">
                                </c:when>
                                <c:otherwise>
                                    <select class="form-control" name="メーカー" id="">
                                        <option value="">Choose</option>
                                        <option value="KI">KI</option>
                                        <option value="FO">FO</option>
                                        <option value="TO">TO</option>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                            <input maxlength="18" class="form-control" type="text"
                                name="manufacturerPartNumber" value="${manufacturerPartNumber}">
                            <input maxlength="1" class="form-control" type="text" name="SS"
                                value="${SS}"> <input maxlength="8"
                                class="form-control edelete" type="text" name="搬入場所"
                                value="${搬入場所}"> <input id="inputS出荷デポ" maxlength="2"
                                class="form-control i出荷デポ " type="text" name="出荷デポ"
                                value="${出荷デポ}"> <input maxlength="1"
                                class="form-control " type="text" name="車種" value="${車種}">
                            <input type="hidden" maxlength="18" class="form-control"
                                type="text" name="stt" value="${stt}">
                        </div>
                        <button class="btn 検索 ">エクスポート (E)</button>
                    </form>
                </div>
            </div>
        </c:if>
    </div>
    <script src="./resources/js/auta8021_main.js"></script>
</body>
</html>