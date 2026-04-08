<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 4/8/2026
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Danh sách bàn</h2>

<form action="list" method="get">
    Lọc sức chứa: <input name="cap" type="number">
    <button type="submit">Tìm</button>
</form>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Sức chứa</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="t" items="${tables}">
        <tr>
            <td>${t.id}</td>
            <td>${t.capacity}</td>
            <td>${t.status}</td>

            <td>
                <a href="view/${t.id}">Chi tiết</a>

                <form action="update-status" method="post" style="display:inline">
                    <input type="hidden" name="id" value="${t.id}">
                    <input type="hidden" name="status" value="Đang dùng">
                    <button type="submit">Nhận bàn</button>
                </form>

                <form action="delete/${t.id}" method="post" style="display:inline">
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

