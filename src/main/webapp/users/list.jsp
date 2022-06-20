<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>


<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Użytkownicy</h1>
    <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>
</div>

<c:if test="${not empty message}">
    <div class="alert alert-warning" role="alert">
            ${message}
    </div>
</c:if>


<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Lista użytkowników</h6>
    </div>

    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nazwa użytkownika</th>
                    <th>E-mail</th>
                    <th>Akcja</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>
                            <c:url var="showLink" value="/user/show">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a href="${showLink}">Pokaż</a>

                            <c:url var="editLink" value="/user/edit">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a href="${editLink}">Edytuj</a>

                            <c:url var="deleteLink" value="/user/delete">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a href="${deleteLink}">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <c:if test="${empty users}">
                <div class="alert alert-light" role="alert">
                    Brak danych do wypisania.
                </div>
            </c:if>
        </div>
    </div>
</div>

<%@ include file="/footer.jsp" %>