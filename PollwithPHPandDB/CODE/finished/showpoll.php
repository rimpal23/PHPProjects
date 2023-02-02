<?php
/**
 * This page will display a poll title, question, and possible answers. The poll
 * is retrieved from a MySQL database based on a pollid passed as a GET parameter.
 * 
 * This page needs the accompanying pollExample.sql import file. Import the file
 * into your local DB using phpMyAdmin.
 * 
 * In this version, the poll can be filled in and submitted, and the result will
 * be recorded.
 * 
 * Sam Scott, February 2015 
 */
session_start();
include "connect.php";
include "Poll.php";

if (isset($_GET["pollid"])) {
    $pollid = $_GET["pollid"];
    // store poll id in the session
    $_SESSION["pollid"] = $pollid;
    // get the information from the polls table
    $command = "SELECT * FROM polls WHERE PollID=?";
    $stmt = $dbh->prepare($command);
    $stmt->execute(array($pollid));
    // The result should be unique, so just get the first row
    $row = $stmt->fetch();
    // if $row is false, $poll is not created. We can check that later.
    if ($row) {
        // display the poll
        $answers = Array();
        for ($i = 1; $i <= 4; $i++) {
            array_push($answers, $row["Answer$i"]);
        }
        $poll = new Poll($_SESSION["pollid"], $row['Title'], $row['Question'], $answers);
    }
}
?>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Poll page</title>
        <link rel="stylesheet" href="../css/style.css">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="container">
            <form action="vote.php" method="post">
                <?php
                // make sure the GET parameter was set
                if (isset($pollid)) {
                    // if $poll not set, then the pollid must have been wrong
                    if ($poll) {
                        // display the poll
                        echo "<h1>$poll->title</h1>\n";
                        echo "<p><b>$poll->question</b></p>\n";
                        for ($i = 1; $i <= 4; $i++) {
                            echo "<input type='radio' name='answer' value='$i' id='answer$i'>\n";
                            echo "<label for='answer$i'>{$poll->answers[$i - 1]}</label><br>";
                        }
                        echo "<input type='submit' value='Vote'>\n";
                    } else {
                        echo "<p>Poll ID {$_SESSION['pollid']} not found.</p>\n";
                    }
                    echo "<i style='color:blue'>$command</i><br>"; // uncommment this for debugging
                } else {
                    echo '<p>No poll selected</p>';
                }
                ?>
            </form>
            <p><a href="index.html">back</a></p>
        </div>
    </body>
</html>
