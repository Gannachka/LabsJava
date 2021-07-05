<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>UWSR</title>
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <script src="js/index.js" type="text/javascript"></script>
      <script src="js/references.js" type="text/javascript"></script>
      <script src="js/comments.js" type="text/javascript"></script>
  </head>
  <body onload="getReferences()">
    <h1>--UWSR--</h1>
    <form>
      <input type="password" id="password" name="password"/>
      <input type="button" id="set" value="Set" onclick="authorization()">
      <input type="button" id="reset" value="Reset" onclick="logOff()" class="display-no">
    </form>
    <div id="buttons">
      <input type="button" id="insert" value="insert" class="display-no" onclick="visibilityInsertForm()">
      <input type="button" id="filter" value="filter" onclick="visibilityFilterForm()">
    </div>
    <div id="filter-form"></div>
    <div id="insert-form"></div>
    <div id="reference-models"></div>
  </body>
</html>
