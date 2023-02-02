<?php
/**
 * This is the second page of the two-page app for adding a new poll. 
 */
include "connect.php";

// create parameters for poll insertion
if (isset($_POST["title"]) && isset($_POST["question"]) && isset($_POST["answer1"]) && isset($_POST["answer2"]) & isset($_POST["answer3"]) && isset($_POST["answer4"])) {
    $params = Array(
        $_POST["title"],
        $_POST["question"],
        $_POST["answer1"],
        $_POST["answer2"],
        $_POST["answer3"],
        $_POST["answer4"]
    );
// do the insert
    $command = "INSERT INTO polls (Title, Question, Answer1, Answer2, Answer3, Answer4) VALUES (?,?,?,?,?,?)";
    $stmt = $dbh->prepare($command);
    $result = $stmt->execute($params);
    if ($result) {
        $msg = "Insert successful (pollid={$dbh->lastInsertId()})";
    } else {
        $msg = "Insert failed";
    }
} else {
    $msg = "Parameters Missing";
    $command = "";
}
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Poll Add Page</title>
        <link rel="stylesheet" href="../css/style.css">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="container">
            <h1>Poll Creation Confirmation</h1>
            <p><?= $msg ?></p>
            <i style='color:blue'><?= $command ?></i><br>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
