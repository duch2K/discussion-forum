<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.project.forum.bean.Post" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="postDao" class="com.project.forum.db.dao.PostDao" scope="session"/>
<jsp:useBean id="commentDao" class="com.project.forum.db.dao.CommentDao" scope="session"/>
<jsp:useBean id="userDao" class="com.project.forum.db.dao.UserDao" scope="session"/>

<%
    List<Post> posts = new ArrayList<>(postDao.getAllPost());
    String postStr = "";

    for (Post post : posts) {
        postStr += "<div class=\"post-card\">\n" +
                "                <a href=\"post?id="+ post.getId() + "\">\n" +
                "                    <div class=\"post-title\">" + post.getTitle() + "</div>\n" +
                "                </a>\n" +
                "\n" +
                "                <div class=\"flex-post-info\">\n" +
                "\n" +
                "                    <div class=\"flex-post-info-child\">\n" +
                "                        <span>" + post.getCountLike() + " likes</span>\n" +
                "                        <span>" + commentDao.getCountCommentsById(post.getId()) + " comments</span>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"flex-post-info-child text-right\">\n" +
                "                        <div>\n" +
                "                            <div>" + post.getDay() + "</div>\n" +
                "                            <div> publisher: " + userDao.getUserById(post.getUserId()).getUsername() + "</div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "            </div>";
    }
%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <link href="styles/style.css" rel="stylesheet" type="text/css">
    <title>Home Page</title>
</head>
<body>
    <%@ include file="header.jsp"%>

    <div class="flex-div flex-direct-column">
        <div class="flex-child">
            <%= postStr %>
        </div>
    </div>

    <h1><%= "Hello World!" %></h1>
    <br/>

</body>
</html>
