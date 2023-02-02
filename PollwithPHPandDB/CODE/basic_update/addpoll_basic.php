<?php
/**
 * This is the second page of the two-page app for adding a new poll. 
 * 
 * This version checks the input parameters but does not use parameters in 
 * its prepared statement.
 */
include "connect.php";

// create poll and validate parameters
if (isset($_POST["title"]) && isset($_POST["question"]) && isset($_POST["answer1"]) && isset($_POST["answer2"]) & isset($_POST["answer3"]) && isset($_POST["answer4"])) {
    $title = $_POST["title"];
    $question = $_POST["question"];
    $answers = Array(
        $_POST["answer1"],
        $_POST["answer2"],
        $_POST["answer3"],
        $_POST["answer4"]
    );
// do the insert
    $command = "INSERT INTO polls (Title, Question, Answer1, Answer2, Answer3, Answer4) VALUES ('$title','$question','{$answers[0]}','{$answers[1]}','{$answers[2]}','{$answers[3]}')";
    $stmt = $dbh->prepare($command);
    $result = $stmt->execute();
    if ($result) {
        $msg = "Insert successful (pollid={$dbh->lastInsertId()})";
    } else {
        $msg = "Insert failed";
    }
} else {
    $msg = "Parameters not set";
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
