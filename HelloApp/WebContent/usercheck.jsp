<!-- 25-1 -->
<html>
<head>
<title>Login Page for helloApp</title>
<body bgcolor="white">
<form method="POST" action=j_security_check>
  <table border="1">
    <tr>
      <th align="right">UserName:</th>
      <td align="left"><input type="text" name="j_username"></td>
    </tr>
    <tr>
      <th align="right">Password:</th>
      <td align="left"><input type="password" name="j_password"></td>
    </tr>
    <tr>
      <td align="right"><input type="submit" value="Log In"></td>
      <td align="left"><input type="reset" value="reset"></td>
    </tr>
  </table>
</form>
</body>
</html>
