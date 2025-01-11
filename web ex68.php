
<!DOCTYPE html>
<html>
<head>
  <title>Form Validation</title>
</head>
<body>
  <h1>Form</h1>
  <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
    Name: <input type="text" name="name"><br>
    Email: <input type="email" name="email"><br>
    Password: <input type="password" name="password"><br>
    Comment:<input type="text" name="cmt"><br>
    Gender:<input type="radio" name="gender">Male<input type="radio" name="gender">Female<br>
    <input type="submit" name="submit" value="Submit">
  </form>
</body>
</html>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $name = $_POST["name"];
  $email = $_POST["email"];
  $password = $_POST["password"];
  $cmnt = $_POST["cmt"];
  if (empty($name)) {
    echo "\nName is required";
  } else {
    echo "Name: " . $name . "<br>";
  }
  if (empty($email)) {
    echo "\nEmail is required";
  } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo "\nInvalid email format";
  } else {
    echo "Email: " . $email . "<br>";
  }
  if (empty($password)) {
    echo "\nPassword is required";
  } elseif (strlen($password) < 8) {
    echo "\nPassword must be at least 8 characters long";
  } else {
    echo "Password: " . $password . "<br>";
  }
  if (empty($cmnt)) {
    echo "\nComment is required";
  } else {
    echo "Comment: " . $cmnt . "<br>";
  }
}
?>


 