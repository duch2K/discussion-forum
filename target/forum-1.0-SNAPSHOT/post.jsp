<%@ page import="com.project.forum.bean.PostBean" %>
<%@ page import="com.project.forum.bean.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="postDao" class="com.project.forum.db.dao.PostDao" scope="session"/>
<jsp:useBean id="commentDao" class="com.project.forum.db.dao.CommentDao" scope="session"/>
<jsp:useBean id="userDao" class="com.project.forum.db.dao.UserDao" scope="session"/>
<jsp:useBean id="post" class="com.project.forum.bean.Post" scope="session"/>

<%
    Integer postId = Integer.parseInt(request.getParameter("id"));
    post = postDao.getPostById(postId);
    List<Comment> comments = new ArrayList<>(commentDao.getCommentsByPostID(postId));

    String commentsStr = "";
    for (Comment comment : comments) {
        commentsStr += "<div class=\"comment-card\">\n" +
                "\n" +
                "                <div class=\"comment-text\">\n" +
                "                    <p>\n" +
                "                        " + comment.getText() + "\n" +
                "                    </p>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"comment-info-flex\">\n" +
                "\n" +
                "                    <div class=\"comment-info-child\">\n" +
                "                        <div>\n" +
                "                            " + comment.getCountLike() + " likes\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"comment-info-child\">\n" +
                "                        <div>\n" +
                "                            " + userDao.getUserById(comment.getId()).getUsername() + "\n" +
                "                        </div>\n" +
                "                        <div>\n" +
                "                            " + comment.getDay() + "\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                </div>\n" +
                "\n" +
                "            </div>";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <link href="styles/style.css" rel="stylesheet" type="text/css">
    <title>Post Page</title>
</head>
<body>

    <%-- header.jsp --%>
    <%@ include file="header.jsp"%>

    <div class="post-box">

        <div class="post-box-date">
            Publish Date: <%= post.getDay() %>
        </div>

        <div class="post-box-title">
            <h1>
                <%= post.getTitle() %>
            </h1>
        </div>

        <div class="post-box-text">
            <p>
                <%= post.getText() %>
            </p>
        </div>

        <div class="comment-div">Comments</div>

        <div class="comment-flex flex-direct-column">
            <%= commentsStr %>
        </div>

    </div>


</body>
</html>
