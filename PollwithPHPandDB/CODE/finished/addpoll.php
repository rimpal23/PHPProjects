<?php
/**
 * Adds a poll to the database with basic input validation and using prepared 
 * statements.
 * 
 * This page needs the accompanying polls.sql import file. Import the file
 * into your local DB using phpMyAdmin.
 *
 * Sam Scott, February 2015
 */
include "connect.php";
include "Poll.php";

if (isset($_POST["title"]) && isset($_POST["question"]) && isset($_POST["answer1"]) && isset($_POST["answer2"]) & isset($_POST["answer3"]) && isset($_POST["answer4"])) {
// create poll and validate parameters
    $poll = new Poll(
            -1, $_POST["title"], $_POST["question"], array(
        $_POST["answer1"],
        $_POST["answer2"],
        $_POST["answer3"],
        $_POST["answer4"]
            )
    );
// do the insert
    $command = "INSERT INTO polls (Title, Question, Answer1, Answer2, Answer3, Answer4) VALUES (?,?,?,?,?,?)";
    $stmt = $dbh->prepare($command);
    $result = $stmt->execute(Array($poll->title, $poll->question, $poll->answers[0], $poll->answers[1], $poll->answers[2], $poll->answers[3]));
    if ($result) {
        $msg = "Insert successful";
    } else {
        $msg = "Insert failed";
        $command = "";
    }
} else {
    $msg = "Parameters not sent";
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
