<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>



<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Użytkownicy</h1>
    <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Lista użytkowników</a>
</div>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Dane użytkownika</h6>
    </div>
    <div class="card-body">
        <table class="table">
            <tbody>
            <tr>
                <th scope="row">ID</th>
                <td>${user.id}</td>

            </tr>
            <tr>
                <th scope="row">Nazwa użytkownika</th>
                <td>${user.username}</td>
            </tr>
            <tr>
                <th scope="row">E-mail</th>
                <td>${user.email}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>



<%@ include file="/footer.jsp" %>