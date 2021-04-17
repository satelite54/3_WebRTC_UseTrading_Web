<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Kakaocert Spring Example</title>
  </head>
  <body>
    <div>
      <p>Response</p>
      <br>
      <fieldset>
        <legend>본인인증 요청</legend>
        <ul>
          <li>receiptID(접수아이디) : ${receiptID}</li>
        </ul>
      </fieldset>
    </div>
  </body>
</html>
